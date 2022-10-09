package ru.cbr.dekart.ma1gus.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.cbr.dekart.ma1gus.models.ReportObjectEntity;
import ru.cbr.dekart.ma1gus.repositories.ReportObjectEntityRepository;
import ru.cbr.dekart.ma1gus.repositories.ReportPriorityAndPropertiesKeyValueEntityRepository;
import ru.cbr.dekart.objects.ReportObject;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Класс, заполняющий основную и свзанную таблицу
 */
@Service
public class ReportObjectEntityService {

    @Autowired
    private ReportObjectEntityRepository reportObjectEntityRepository;
    @Autowired
    private ReportPriorityAndPropertiesKeyValueEntityService reportPriorityAndPropertiesKeyValueEntityService;
    @Autowired
    private ReportPriorityAndPropertiesKeyValueEntityRepository reportPriorityAndPropertiesKeyValueEntityRepository;
    @Transactional
    public ReportObjectEntity fillReportObjectEntityTable(ReportObject reportObject) {
        ReportObjectEntity reportObjectEntity = new ReportObjectEntity();
        reportObjectEntity.setReportUuid(reportObject.getReportUuid());
        reportObjectEntity.setParentId(reportObject.getParentId());
        reportObjectEntity.setStreamId(reportObject.getStreamId());
        reportObjectEntity.setTaskId(reportObject.getTaskId());
        reportObjectEntity.setProcessingDate(reportObject.getProcessingDate());
        reportObjectEntity.setProperties(reportObject.getProperties().toString());
        reportObjectEntity.setProcessId(reportObject.getProcessId());
        reportObjectEntity.setRouteId(reportObject.getRouteId());
        reportObjectEntity.setReportPriority(reportObject.getReportPriority());
        reportObjectEntity.setReportPriorityValue(String.valueOf(reportObject.getReportPriorityValue()));
        reportObjectEntity.setResult(String.valueOf(reportObject.getResult()));
        reportObjectEntity.setMassage(reportObject.getMessage());
        reportObjectEntity.setReportFileName(reportObject.getReportFileName());
        reportObjectEntity.setReportFileLink(reportObject.getReportFileLink());
        reportObjectEntity.setReportDate(reportObject.getReportDate());
        reportObjectEntity.setReportCode(reportObject.getReportCode());
        reportObjectEntity.setReportProperties(reportObject.getReportProperties().toString());
        reportObjectEntity.setReportAttachments(reportObject.getReportAttachments().toString());
        reportObjectEntity.setReplyFileName(reportObject.getReplyFileName());
        reportObjectEntity.setDocumentPackId(null);
        /**
         *  Конструкция позволяет работать с листом в дальнейшем и вносить изменения
         */
        reportPriorityAndPropertiesKeyValueEntityRepository.saveAll(
                reportPriorityAndPropertiesKeyValueEntityService.fillReportPriorityAndPropertiesKeyValueEntityTable(reportObject, reportObjectEntity)
        );

        reportObjectEntityRepository.save(reportObjectEntity);
        return reportObjectEntity;
    }

    @Transactional
    public List<ReportObjectEntity> getReportObjectEntities() {
        return reportObjectEntityRepository.findAll();
    }

    @Transactional
    public String getForeignKeyTable(int id) {
        return reportObjectEntityRepository.selectForeignKeyTable(id);
    }

    @Transactional
    public String getReportAttachments() {
        return reportObjectEntityRepository.selectReportAttachments();
    }

    @Transactional
    public void remove(int id) {
        reportObjectEntityRepository.deleteById(id);
    }
}
