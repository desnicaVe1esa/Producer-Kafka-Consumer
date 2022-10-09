package ru.cbr.dekart.ma1gus.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "report_priority_and_properties_key_value_entity")
public class ReportPriorityAndPropertiesKeyValueEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "key_report_object")
    private String keyReportObject;
    @Column(name = "value_report_object")
    private String valueReportObject;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private ReportObjectEntity reportObjectEntity;

    public ReportPriorityAndPropertiesKeyValueEntity() {
    }

    public ReportPriorityAndPropertiesKeyValueEntity(int id, String keyReportObject, String valueReportObject, ReportObjectEntity reportObjectEntity) {
        this.id = id;
        this.keyReportObject = keyReportObject;
        this.valueReportObject = valueReportObject;
        this.reportObjectEntity = reportObjectEntity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKeyReportObject() {
        return keyReportObject;
    }

    public void setKeyReportObject(String keyReportObject) {
        this.keyReportObject = keyReportObject;
    }

    public String getValueReportObject() {
        return valueReportObject;
    }

    public void setValueReportObject(String valueReportObject) {
        this.valueReportObject = valueReportObject;
    }

    public ReportObjectEntity getReportObjectEntity() {
        return reportObjectEntity;
    }

    public void setReportObjectEntity(ReportObjectEntity reportObjectEntity) {
        this.reportObjectEntity = reportObjectEntity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReportPriorityAndPropertiesKeyValueEntity that = (ReportPriorityAndPropertiesKeyValueEntity) o;
        return id == that.id && keyReportObject.equals(that.keyReportObject) && valueReportObject.equals(that.valueReportObject) && reportObjectEntity.equals(that.reportObjectEntity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, keyReportObject, valueReportObject, reportObjectEntity);
    }

    @Override
    public String toString() {
        return "ReportPriorityAndPropertiesKeyValueEntity{" +
                "id=" + id +
                ", keyReportObject='" + keyReportObject + '\'' +
                ", valueReportObject='" + valueReportObject + '\'' +
                ", reportObjectId=" + reportObjectEntity +
                '}';
    }
}
