package ru.cbr.dekart.ma1gus.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.cbr.dekart.ma1gus.models.ReportPriorityAndPropertiesKeyValueEntity;



@Repository
public interface ReportPriorityAndPropertiesKeyValueEntityRepository extends JpaRepository<ReportPriorityAndPropertiesKeyValueEntity, Integer> {

    @Query(value = "select count(*) from report_priority_and_properties_key_value_entity where key_report_object='УникИдОЭС' and value_report_object=:valueReportObject",
    nativeQuery = true)
    int checkDuplicate(@Param("valueReportObject") String value);
}
