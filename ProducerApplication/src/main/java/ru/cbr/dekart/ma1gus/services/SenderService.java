package ru.cbr.dekart.ma1gus.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import ru.cbr.dekart.objects.ReportObject;

@Service
public class SenderService {

    @Autowired
    private KafkaTemplate<String, Object> kafkaObjectTemplate;

    private Logger logger;

    public SenderService () {
        logger = LoggerFactory.getLogger(getClass());
    }

    @Async
    public void send(String topic, ReportObject msg) {
        ListenableFuture<SendResult<String, Object>> future = kafkaObjectTemplate.send(topic, msg);

        future.addCallback(new ListenableFutureCallback<SendResult<String, Object>>() {
            @Override
            public void onFailure(Throwable throwable) {
                logger.warn("Сообщение не было отправлено {}", msg, throwable);
            }

            @Override
            public void onSuccess(SendResult<String, Object> stringObjectSendResult) {
                logger.info("Сообщение успешно отправлено {}", msg);

            }
        });
        future.isDone ();
    }

    /**
     * Метод отправки сообщения об успешном результате.
     *
     * @param topic - тема.
     * @param msg   - сообщение.
     */
    public void sendSuccess(String topic, ReportObject msg) {
        msg.setResult(0);
        send(topic, msg);
    }

    /**
     * Метод отправки сообщения о результате с ошибкой.
     *
     * @param topic - тема.
     * @param msg   - сообщение.
     */
    public void sendFailure(String topic, ReportObject msg, String errMessage, int errCode) {
        msg.setResult(errCode);
        msg.setMessage(errMessage);
        send(topic, msg);
    }
}
