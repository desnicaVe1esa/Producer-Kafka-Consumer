package ru.cbr.dekart.ma1gus.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.cbr.dekart.ma1gus.models.ReportObjectEntity;
import ru.cbr.dekart.ma1gus.models.ReportPriorityAndPropertiesKeyValueEntity;
import ru.cbr.dekart.objects.ReportObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Класс, заполняющий связанную таблицу по соответствущему условию параметру
 */
@Service
public class ReportPriorityAndPropertiesKeyValueEntityService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Transactional
    public List<ReportPriorityAndPropertiesKeyValueEntity> fillReportPriorityAndPropertiesKeyValueEntityTable(ReportObject reportObject, ReportObjectEntity reportObjectEntity) {
        ArrayList<ReportPriorityAndPropertiesKeyValueEntity> list = new ArrayList<>();
            if (!reportObject.getReportPriority().isEmpty()) {
                ReportPriorityAndPropertiesKeyValueEntity reportPriorityAndPropertiesKeyValueEntity = new ReportPriorityAndPropertiesKeyValueEntity();
                reportPriorityAndPropertiesKeyValueEntity.setKeyReportObject("Нет ключа");
                reportPriorityAndPropertiesKeyValueEntity.setValueReportObject(reportObject.getReportPriority());
            } else {
                if (!reportObject.getProperties().isEmpty()) {
                    for (Map.Entry<String, String> item : reportObject.getProperties().entrySet()) {
                        ReportPriorityAndPropertiesKeyValueEntity reportPriorityAndPropertiesKeyValueEntity = new ReportPriorityAndPropertiesKeyValueEntity();
                        reportPriorityAndPropertiesKeyValueEntity.setKeyReportObject(item.getKey());
                        reportPriorityAndPropertiesKeyValueEntity.setValueReportObject(item.getValue());
                        reportPriorityAndPropertiesKeyValueEntity.setReportObjectEntity(reportObjectEntity);
                        list.add(reportPriorityAndPropertiesKeyValueEntity);
                    }
                }
            }
        return list;
    }
}









