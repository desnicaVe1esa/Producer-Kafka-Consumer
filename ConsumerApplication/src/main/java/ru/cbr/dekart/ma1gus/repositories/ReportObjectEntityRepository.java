package ru.cbr.dekart.ma1gus.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.cbr.dekart.ma1gus.models.ReportObjectEntity;

@Repository
public interface ReportObjectEntityRepository extends JpaRepository<ReportObjectEntity, Integer> {

    @Query(value = "SELECT REPORT_ATTACHMENTS FROM REPORT_OBJECT_ENTITY",
            nativeQuery = true)
    String selectReportAttachments();

    @Query(value = "SELECT PROPERTIES FROM REPORT_OBJECT_ENTITY WHERE id=:id",
            nativeQuery = true)
    String selectForeignKeyTable(int id);
}
