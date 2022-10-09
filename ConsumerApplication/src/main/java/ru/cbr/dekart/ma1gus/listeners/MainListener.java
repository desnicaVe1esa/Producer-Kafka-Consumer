package ru.cbr.dekart.ma1gus.listeners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;
import ru.cbr.dekart.ma1gus.exceptions.DuplicateException;
import ru.cbr.dekart.ma1gus.repositories.ReportPriorityAndPropertiesKeyValueEntityRepository;
import ru.cbr.dekart.ma1gus.services.*;
import ru.cbr.dekart.objects.ReportObject;


@Component
public class MainListener {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Value("${dekart.leveldown.kafka.topic.check_result}")
    private String checkResult;
    @Autowired
    private SenderService senderService;
    @Autowired
    private ReportObjectEntityService reportObjectEntityService;
    @Autowired
    private ReportPriorityAndPropertiesKeyValueEntityService reportPriorityAndPropertiesKeyValueEntityService;
    @Autowired
    private ReportPriorityAndPropertiesKeyValueEntityRepository reportPriorityAndPropertiesKeyValueEntityRepository;

    @KafkaListener(
            topics = {"${dekart.kafka.topics}"},
            groupId = "descartes",
            containerFactory = "kafkaListenerContainerFactory"
    )
    public void readFromKafka(ReportObject reportObject, Acknowledgment acknowledgment) throws DuplicateException {
        MDC.put("uuid", reportObject.getUuid());
        logger.info("Получено сообщение");

        /**
         * Проверка на наличие ключа
         */
        if (!reportObject.getProperties().containsKey("УникИдОЭС")){
            logger.error("Данные не найдены");
            return;
        }

        /**
         * Проверка на дубликат
         */
        String parameter = "";
        try {
            parameter = reportObject.getProperties().get("УникИдОЭС");
        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.info(parameter);
        if (reportPriorityAndPropertiesKeyValueEntityRepository.checkDuplicate(parameter) > 0) {
            logger.info("Ошибка!");
            throw new DuplicateException("Форма не прошла проверку на дубликат.");
        }

        reportObjectEntityService.fillReportObjectEntityTable(reportObject);
        acknowledgment.acknowledge();
    }
}
