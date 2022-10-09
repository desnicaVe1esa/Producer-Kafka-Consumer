package ru.cbr.dekart.ma1gus.models;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "report_object_entity")
public class ReportObjectEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "uuid")
    private String uuid;
    @Column(name = "parent_id")
    private String parentId;
    @Column(name = "stream_id")
    private String streamId;
    @Column(name = "task_id")
    private String taskId;
    @Column(name = "envelope_type")
    private String envelopeType;
    @Column(name = "processing_date")
    private Timestamp processingDate;
    @Column(name = "properties")
    private String properties;
    @Column(name = "process_id")
    private String processId;
    @Column(name = "route_id")
    private String routeId;
    @Column(name = "report_priority")
    private String reportPriority;
    @Column(name = "report_priority_value")
    private String reportPriorityValue;
    @Column(name = "result")
    private String result;
    @Column(name = "massage")
    private String massage;
    @Column(name = "report_uuid")
    private String reportUuid;
    @Column(name = "report_file_name")
    private String reportFileName;
    @Column(name = "report_file_link")
    private String reportFileLink;
    @Column(name = "report_date")
    private String reportDate;
    @Column(name = "report_code")
    private String reportCode;
    @Column(name = "report_properties")
    private String reportProperties;
    @Column(name = "report_attachments")
    private String reportAttachments;
    @Column(name = "reply_file_name")
    private String replyFileName;
    @Column(name = "reply_file_link")
    private String replyFileLink;
    @Column(name = "document_pack_id")
    private String documentPackId;
    @OneToMany(mappedBy = "reportObjectEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ReportPriorityAndPropertiesKeyValueEntity> reportPriorityAndPropertiesKeyValueEntities;

    public ReportObjectEntity() {
    }

    public ReportObjectEntity(int id, String uuid, String parentId, String streamId, String taskId, String envelopeType, Timestamp processingDate, String properties, String processId, String routeId, String reportPriority, String reportPriorityValue, String result, String massage, String reportUuid, String reportFileName, String reportFileLink, String reportDate, String reportCode, String reportProperties, String reportAttachments, String replyFileName, String replyFileLink, String documentPackId, List<ReportPriorityAndPropertiesKeyValueEntity> reportPriorityAndPropertiesKeyValueEntities) {
        this.id = id;
        this.uuid = uuid;
        this.parentId = parentId;
        this.streamId = streamId;
        this.taskId = taskId;
        this.envelopeType = envelopeType;
        this.processingDate = processingDate;
        this.properties = properties;
        this.processId = processId;
        this.routeId = routeId;
        this.reportPriority = reportPriority;
        this.reportPriorityValue = reportPriorityValue;
        this.result = result;
        this.massage = massage;
        this.reportUuid = reportUuid;
        this.reportFileName = reportFileName;
        this.reportFileLink = reportFileLink;
        this.reportDate = reportDate;
        this.reportCode = reportCode;
        this.reportProperties = reportProperties;
        this.reportAttachments = reportAttachments;
        this.replyFileName = replyFileName;
        this.replyFileLink = replyFileLink;
        this.documentPackId = documentPackId;
        this.reportPriorityAndPropertiesKeyValueEntities = reportPriorityAndPropertiesKeyValueEntities;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getStreamId() {
        return streamId;
    }

    public void setStreamId(String streamId) {
        this.streamId = streamId;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getEnvelopeType() {
        return envelopeType;
    }

    public void setEnvelopeType(String envelopeType) {
        this.envelopeType = envelopeType;
    }

    public Timestamp getProcessingDate() {
        return processingDate;
    }

    public void setProcessingDate(Timestamp processingDate) {
        this.processingDate = processingDate;
    }

    public String getProperties() {
        return properties;
    }

    public void setProperties(String properties) {
        this.properties = properties;
    }

    public String getProcessId() {
        return processId;
    }

    public void setProcessId(String processId) {
        this.processId = processId;
    }

    public String getRouteId() {
        return routeId;
    }

    public void setRouteId(String routeId) {
        this.routeId = routeId;
    }

    public String getReportPriority() {
        return reportPriority;
    }

    public void setReportPriority(String reportPriority) {
        this.reportPriority = reportPriority;
    }

    public String getReportPriorityValue() {
        return reportPriorityValue;
    }

    public void setReportPriorityValue(String reportPriorityValue) {
        this.reportPriorityValue = reportPriorityValue;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }

    public String getReportUuid() {
        return reportUuid;
    }

    public void setReportUuid(String reportUuid) {
        this.reportUuid = reportUuid;
    }

    public String getReportFileName() {
        return reportFileName;
    }

    public void setReportFileName(String reportFileName) {
        this.reportFileName = reportFileName;
    }

    public String getReportFileLink() {
        return reportFileLink;
    }

    public void setReportFileLink(String reportFileLink) {
        this.reportFileLink = reportFileLink;
    }

    public String getReportDate() {
        return reportDate;
    }

    public void setReportDate(String reportDate) {
        this.reportDate = reportDate;
    }

    public String getReportCode() {
        return reportCode;
    }

    public void setReportCode(String reportCode) {
        this.reportCode = reportCode;
    }

    public String getReportProperties() {
        return reportProperties;
    }

    public void setReportProperties(String reportProperties) {
        this.reportProperties = reportProperties;
    }

    public String getReportAttachments() {
        return reportAttachments;
    }

    public void setReportAttachments(String reportAttachments) {
        this.reportAttachments = reportAttachments;
    }

    public String getReplyFileName() {
        return replyFileName;
    }

    public void setReplyFileName(String replyFileName) {
        this.replyFileName = replyFileName;
    }

    public String getReplyFileLink() {
        return replyFileLink;
    }

    public void setReplyFileLink(String replyFileLink) {
        this.replyFileLink = replyFileLink;
    }

    public String getDocumentPackId() {
        return documentPackId;
    }

    public void setDocumentPackId(String documentPackId) {
        this.documentPackId = documentPackId;
    }

    public List<ReportPriorityAndPropertiesKeyValueEntity> getReportPriorityAndPropertiesKeyValueEntities() {
        return reportPriorityAndPropertiesKeyValueEntities;
    }

    public void setReportPriorityAndPropertiesKeyValueEntities(List<ReportPriorityAndPropertiesKeyValueEntity> reportPriorityAndPropertiesKeyValueEntities) {
        this.reportPriorityAndPropertiesKeyValueEntities = reportPriorityAndPropertiesKeyValueEntities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReportObjectEntity that = (ReportObjectEntity) o;
        return id == that.id && uuid.equals(that.uuid) && parentId.equals(that.parentId) && streamId.equals(that.streamId) && taskId.equals(that.taskId) && envelopeType.equals(that.envelopeType) && processingDate.equals(that.processingDate) && properties.equals(that.properties) && processId.equals(that.processId) && routeId.equals(that.routeId) && reportPriority.equals(that.reportPriority) && reportPriorityValue.equals(that.reportPriorityValue) && result.equals(that.result) && massage.equals(that.massage) && reportUuid.equals(that.reportUuid) && reportFileName.equals(that.reportFileName) && reportFileLink.equals(that.reportFileLink) && reportDate.equals(that.reportDate) && reportCode.equals(that.reportCode) && reportProperties.equals(that.reportProperties) && reportAttachments.equals(that.reportAttachments) && replyFileName.equals(that.replyFileName) && replyFileLink.equals(that.replyFileLink) && documentPackId.equals(that.documentPackId) && reportPriorityAndPropertiesKeyValueEntities.equals(that.reportPriorityAndPropertiesKeyValueEntities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, uuid, parentId, streamId, taskId, envelopeType, processingDate, properties, processId, routeId, reportPriority, reportPriorityValue, result, massage, reportUuid, reportFileName, reportFileLink, reportDate, reportCode, reportProperties, reportAttachments, replyFileName, replyFileLink, documentPackId, reportPriorityAndPropertiesKeyValueEntities);
    }

    @Override
    public String toString() {
        return "ReportObjectEntity{" +
                "id=" + id +
                ", uuid='" + uuid + '\'' +
                ", parentId='" + parentId + '\'' +
                ", streamId='" + streamId + '\'' +
                ", taskId='" + taskId + '\'' +
                ", envelopeType='" + envelopeType + '\'' +
                ", processingDate=" + processingDate +
                ", properties='" + properties + '\'' +
                ", processId='" + processId + '\'' +
                ", routeId='" + routeId + '\'' +
                ", reportPriority='" + reportPriority + '\'' +
                ", reportPriorityValue='" + reportPriorityValue + '\'' +
                ", result='" + result + '\'' +
                ", massage='" + massage + '\'' +
                ", reportUuid='" + reportUuid + '\'' +
                ", reportFileName='" + reportFileName + '\'' +
                ", reportFileLink='" + reportFileLink + '\'' +
                ", reportDate='" + reportDate + '\'' +
                ", reportCode='" + reportCode + '\'' +
                ", reportProperties='" + reportProperties + '\'' +
                ", reportAttachments='" + reportAttachments + '\'' +
                ", replyFileName='" + replyFileName + '\'' +
                ", replyFileLink='" + replyFileLink + '\'' +
                ", documentPackId='" + documentPackId + '\'' +
                ", reportPriorityAndPropertiesKeyValueEntities=" + reportPriorityAndPropertiesKeyValueEntities +
                '}';
    }
}

