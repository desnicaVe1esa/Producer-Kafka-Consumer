package ru.cbr.dekart.ma1gus.models;

import org.springframework.stereotype.Component;

@Component
public class F0000001field {
    private String uniqueId;
    private String view;
    private String codeForm;
    private String oukd;
    private String viewReport;
    private String reportDate;
    private String periodicity;
    private String dateTimeFormation;

    public F0000001field() {}

    public F0000001field(String uniqueId, String view, String codeForm, String oukd, String viewReport, String reportDate, String periodicity, String dateTimeFormation) {
        this.uniqueId = uniqueId;
        this.view = view;
        this.codeForm = codeForm;
        this.oukd = oukd;
        this.viewReport = viewReport;
        this.reportDate = reportDate;
        this.periodicity = periodicity;
        this.dateTimeFormation = dateTimeFormation;
    }

    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }

    public String getCodeForm() {
        return codeForm;
    }

    public void setCodeForm(String codeForm) {
        this.codeForm = codeForm;
    }

    public String getOukd() {
        return oukd;
    }

    public void setOukd(String oukd) {
        this.oukd = oukd;
    }

    public String getViewReport() {
        return viewReport;
    }

    public void setViewReport(String viewReport) {
        this.viewReport = viewReport;
    }

    public String getReportDate() {
        return reportDate;
    }

    public void setReportDate(String reportDate) {
        this.reportDate = reportDate;
    }

    public String getPeriodicity() {
        return periodicity;
    }

    public void setPeriodicity(String periodicity) {
        this.periodicity = periodicity;
    }

    public String getDateTimeFormation() {
        return dateTimeFormation;
    }

    public void setDateTimeFormation(String dateTimeFormation) {
        this.dateTimeFormation = dateTimeFormation;
    }

    @Override
    public String toString() {
        return "F0000001{" +
                "uniqueId='" + uniqueId + '\'' +
                ", view='" + view + '\'' +
                ", codeForm='" + codeForm + '\'' +
                ", oukd='" + oukd + '\'' +
                ", viewReport='" + viewReport + '\'' +
                ", reportDate='" + reportDate + '\'' +
                ", periodicity='" + periodicity + '\'' +
                ", dateTimeFormation='" + dateTimeFormation + '\'' +
                '}';
    }
}
