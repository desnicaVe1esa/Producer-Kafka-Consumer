package ru.cbr.dekart.objects;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ReportObject {
    private String uuid;
    private String reportUuid;
    private String taskId;
    private String streamId;
    private String envelopeType;
    private Timestamp processingDate;
    private Map<String, String> properties = new LinkedHashMap<>();
    private String reportFileName;
    private String reportDate;
    private String reportCode;
    private String routeId;
    private String reportPriority;
    private Integer reportPriorityValue;
    private String processId;
    private Integer result = 0;
    private String message;
    private Map<String, String> reportProperties = new LinkedHashMap<>();
    private String reportFileLink;
    private String reportReplyLink;
    private List<String> reportAttachments = new ArrayList<>();
    private String parentId;
    private String replyFileName;
    private String replyFileLink;

    public ReportObject() {
    }

    public ReportObject(String uuid, String reportUuid, String taskId, String streamId, String envelopeType, Timestamp processingDate, Map<String, String> properties, String reportFileName, String reportDate, String reportCode, String routeId, String reportPriority, Integer reportPriorityValue, String processId, Integer result, String message, Map<String, String> reportProperties, String reportFileLink, String reportReplyLink, List<String> reportAttachments, String parentId, String replyFileName, String replyFileLink) {
        this.uuid = uuid;
        this.reportUuid = reportUuid;
        this.taskId = taskId;
        this.streamId = streamId;
        this.envelopeType = envelopeType;
        this.processingDate = processingDate;
        this.properties = properties;
        this.reportFileName = reportFileName;
        this.reportDate = reportDate;
        this.reportCode = reportCode;
        this.routeId = routeId;
        this.reportPriority = reportPriority;
        this.reportPriorityValue = reportPriorityValue;
        this.processId = processId;
        this.result = result;
        this.message = message;
        this.reportProperties = reportProperties;
        this.reportFileLink = reportFileLink;
        this.reportReplyLink = reportReplyLink;
        this.reportAttachments = reportAttachments;
        this.parentId = parentId;
        this.replyFileName = replyFileName;
        this.replyFileLink = replyFileLink;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getReportUuid() {
        return reportUuid;
    }

    public void setReportUuid(String reportUuid) {
        this.reportUuid = reportUuid;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getStreamId() {
        return streamId;
    }

    public void setStreamId(String streamId) {
        this.streamId = streamId;
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

    public Map<String, String> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, String> properties) {
        this.properties = properties;
    }

    public String getReportFileName() {
        return reportFileName;
    }

    public void setReportFileName(String reportFileName) {
        this.reportFileName = reportFileName;
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

    public Integer getReportPriorityValue() {
        return reportPriorityValue;
    }

    public void setReportPriorityValue(Integer reportPriorityValue) {
        this.reportPriorityValue = reportPriorityValue;
    }

    public String getProcessId() {
        return processId;
    }

    public void setProcessId(String processId) {
        this.processId = processId;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, String> getReportProperties() {
        return reportProperties;
    }

    public void setReportProperties(Map<String, String> reportProperties) {
        this.reportProperties = reportProperties;
    }

    public String getReportFileLink() {
        return reportFileLink;
    }

    public void setReportFileLink(String reportFileLink) {
        this.reportFileLink = reportFileLink;
    }

    public String getReportReplyLink() {
        return reportReplyLink;
    }

    public void setReportReplyLink(String reportReplyLink) {
        this.reportReplyLink = reportReplyLink;
    }

    public List<String> getReportAttachments() {
        return reportAttachments;
    }

    public void setReportAttachments(List<String> reportAttachments) {
        this.reportAttachments = reportAttachments;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
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

    @Override
    public String toString() {
        return "ReportObject{" +
                "uuid='" + uuid + '\'' +
                ", reportUuid='" + reportUuid + '\'' +
                ", taskId='" + taskId + '\'' +
                ", streamId='" + streamId + '\'' +
                ", envelopeType='" + envelopeType + '\'' +
                ", processingDate=" + processingDate +
                ", properties=" + properties +
                ", reportFileName='" + reportFileName + '\'' +
                ", reportDate='" + reportDate + '\'' +
                ", reportCode='" + reportCode + '\'' +
                ", routeId='" + routeId + '\'' +
                ", reportPriority='" + reportPriority + '\'' +
                ", reportPriorityValue=" + reportPriorityValue +
                ", processId='" + processId + '\'' +
                ", result=" + result +
                ", message='" + message + '\'' +
                ", reportProperties=" + reportProperties +
                ", reportFileLink='" + reportFileLink + '\'' +
                ", reportReplyLink='" + reportReplyLink + '\'' +
                ", reportAttachments=" + reportAttachments +
                ", parentId='" + parentId + '\'' +
                ", replyFileName='" + replyFileName + '\'' +
                ", replyFileLink='" + replyFileLink + '\'' +
                '}';
    }
}
