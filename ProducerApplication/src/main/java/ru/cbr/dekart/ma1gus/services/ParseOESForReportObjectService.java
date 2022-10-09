package ru.cbr.dekart.ma1gus.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import ru.cbr.dekart.objects.ReportObject;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.Reader;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Класс для парсинга OES.xml
 */

@Service
public class ParseOESForReportObjectService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private XMLService xmlService;

    /**
     * Метод достает аттрибут Ф0000001 и заносит его связки ключ-значение в мапу
     */
    public ReportObject parseF0000001FieldFromXMLFile(String strOES) {
        ReportObject reportObject = new ReportObject();
        try (
                InputStream is = new ByteArrayInputStream(strOES.getBytes());
                Reader reader = xmlService.getFileReader(is, xmlService.getEncoding(new ByteArrayInputStream(strOES.getBytes())))
            ) {
            XMLInputFactory factory = XMLInputFactory.newInstance();
            XMLStreamReader streamReader = factory.createXMLStreamReader(reader);
            logger.info("Данные получены");
            streamReader.next();
            Integer attributesCount = streamReader.getAttributeCount();
            Map<String, String> attributes = new LinkedHashMap<>();
            for (int i = 0; i < attributesCount; i++) {
                String attributeName = streamReader.getAttributeLocalName(i);
                String attributeValue = streamReader.getAttributeValue(i);
                attributes.put(attributeName, attributeValue);
            }
            reportObject = putParameter(attributes);
            logger.info("Данные внесены");
        } catch (Exception e) {
            logger.error("Ошибка: ", e);
        }
        return reportObject;
    }


    /**
     * Зполнение параметров класса ReportObject
     */
    @Async
    public ReportObject putParameter(String field) {
        ReportObject reportObject = new ReportObject();
        reportObject.setUuid(String.valueOf(UUID.randomUUID()));
        reportObject.setReportUuid(String.valueOf(UUID.randomUUID()));
        reportObject.setTaskId("Таска");
        reportObject.setStreamId("Стрим");
        reportObject.setEnvelopeType("Конверт");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
        String date = sdf.format(new Date());
        reportObject.setProcessingDate(Timestamp.valueOf(date));

        reportObject.getProperties().put("", "");
        reportObject.setReportFileName("Имя файла отчета");
        reportObject.setReportDate("Имя даты отчета");
        reportObject.setReportCode("Код отчета");
        reportObject.setRouteId(String.valueOf(123));
        reportObject.setReportPriority(field);
        reportObject.setReportPriorityValue(4);
        reportObject.setProcessId(String.valueOf(UUID.randomUUID()));
        reportObject.getResult();
        reportObject.setMessage("Сообщение");
        reportObject.getReportProperties().put("Ключ", "Значение");
        reportObject.setReplyFileLink("Ссылка на файл ответа");
        reportObject.setReportReplyLink("Сообщить об ответной ссылке");
        reportObject.getReportAttachments().add("Приложения к отчету");
        reportObject.getParentId();
        reportObject.getReplyFileName();
        reportObject.getReplyFileLink();
        return reportObject;
    }

    @Async
    public ReportObject putParameter(Map<String, String> field) {
        ReportObject reportObject = new ReportObject();
        reportObject.setUuid(String.valueOf(UUID.randomUUID()));
        reportObject.setReportUuid(String.valueOf(UUID.randomUUID()));
        reportObject.setTaskId("Таска");
        reportObject.setStreamId("Стрим");
        reportObject.setEnvelopeType("Конверт");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
        String date = sdf.format(new Date());
        reportObject.setProcessingDate(Timestamp.valueOf(date));

        reportObject.setProperties(field);
        reportObject.setReportFileName("Имя файла отчета");
        reportObject.setReportDate("Имя даты отчета");
        reportObject.setReportCode("Код отчета");
        reportObject.setRouteId(String.valueOf(123));
        reportObject.setReportPriority("");
        reportObject.setReportPriorityValue(4);
        reportObject.setProcessId(String.valueOf(UUID.randomUUID()));
        reportObject.getResult();
        reportObject.setMessage("Сообщение");
        reportObject.getReportProperties().put("Ключ", "Значение");
        reportObject.setReplyFileLink("Ссылка на файл ответа");
        reportObject.setReportReplyLink("Сообщить об ответной ссылке");
        reportObject.getReportAttachments().add("Приложения к отчету");
        reportObject.getParentId();
        reportObject.getReplyFileName();
        reportObject.getReplyFileLink();
        return reportObject;
    }
}