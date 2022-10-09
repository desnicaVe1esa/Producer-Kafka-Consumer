package ru.cbr.dekart.ma1gus.configs.kafka;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRebalanceListener;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.listener.ContainerProperties;
import org.springframework.kafka.listener.DeadLetterPublishingRecoverer;
import org.springframework.kafka.listener.SeekToCurrentErrorHandler;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;
import org.springframework.util.backoff.FixedBackOff;

@EnableKafka
@Configuration
public class KafkaConfiguration {

    @Value("${spring.kafka.bootstrap-servers}")
    private String address;

    @Value("${dekart.kafka.groupId}")
    private  String groupId;

    private Logger logger;

    public KafkaConfiguration () {
        logger = LoggerFactory.getLogger(getClass());
    }

    /**
     *  Конфигурация потребителя для приёма объектов из Kafka.
     *
     *  Автоматическая генерация идентификатора группы.
     */
    @Bean
    public ConsumerFactory<String, Object> consumerFactory() {
        String customGroup = groupId + "_" + UUID.randomUUID().toString();
        Map<String, Object> config = new HashMap<>();
        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, address);
        config.put(ConsumerConfig.GROUP_ID_CONFIG, customGroup);
        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        config.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, "10000");
        config.put(ConsumerConfig.MAX_POLL_INTERVAL_MS_CONFIG, "10000");
        config.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "false");
        JsonDeserializer<Object> customJsonDeserializer = new JsonDeserializer<>();
        customJsonDeserializer.addTrustedPackages("*");
        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, customJsonDeserializer);
        return new DefaultKafkaConsumerFactory<>(config, new StringDeserializer(), customJsonDeserializer);
    }


    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, Object> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, Object> factory = new ConcurrentKafkaListenerContainerFactory<>();

        factory.setConsumerFactory(consumerFactory());
        factory.getContainerProperties().setAckMode(ContainerProperties.AckMode.MANUAL_IMMEDIATE);

        factory.setErrorHandler(new SeekToCurrentErrorHandler(new DeadLetterPublishingRecoverer(kafkaObjectTemplate()), new FixedBackOff(0L, 2L)));
        factory.getContainerProperties().setConsumerRebalanceListener(new ConsumerRebalanceListener() {
            @Override
            public void onPartitionsRevoked(Collection<TopicPartition> collection) {
                logger.info("Балансировка");
            }

            @Override
            public void onPartitionsAssigned(Collection<TopicPartition> collection) {
                logger.info("Балансировка");
            }
        });
        return factory;
    }

    /**
     *  Конфигурация производителя для отправки объектов на Kafka.
     */
    @Bean
    public ProducerFactory<String, Object> producerObjectFactory() {
        Map<String, Object> config = new HashMap<>();
        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, getAddress());
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        return new DefaultKafkaProducerFactory<>(config);
    }

    @Bean
    public KafkaTemplate<String, Object> kafkaObjectTemplate() {
        return new KafkaTemplate<>(producerObjectFactory());
    }


    public String getAddress() {
        return address;
    }

    public String getGroupId() {
        return groupId;
    }
}