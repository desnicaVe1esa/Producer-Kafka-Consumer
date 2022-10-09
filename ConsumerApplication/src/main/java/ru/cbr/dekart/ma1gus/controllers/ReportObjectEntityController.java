package ru.cbr.dekart.ma1gus.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.cbr.dekart.ma1gus.models.ReportObjectEntity;
import ru.cbr.dekart.ma1gus.services.ReportObjectEntityService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api2")
public class ReportObjectEntityController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private ReportObjectEntityService reportObjectEntityService;

    @GetMapping("reportObjectEntities")
    public List<ReportObjectEntity> getAllReportObjectEntities() {
        List<ReportObjectEntity> list = new ArrayList<>();
        try {
            list = reportObjectEntityService.getReportObjectEntities();
            logger.info("Данные получены");
        } catch (Exception e) {
            logger.error("Ошибка:", e);
        }
        return list;
    }

    @GetMapping("reportObjectEntities/{id}")
    public String getAllReportPriorityAndPropertiesKeyValueEntity(@PathVariable("id") int id) {
        String s = "";
        try {
            s = reportObjectEntityService.getForeignKeyTable(id);
            logger.info("Данные получены");
        } catch (Exception e) {
            logger.error("Ошибка:", e);
        }
        return s;
    }

    @GetMapping("reportAttachments")
    public String getReportAttachments() {
        String s = "";
        try {
            s = reportObjectEntityService.getReportAttachments();
            logger.info("Данные получены");
        } catch (Exception e) {
            logger.error("Ошибка:", e);
        }
        return s;
    }

    @DeleteMapping(value = "{id}")
    public void deleteParameter(@PathVariable("id") int id) {
        try {
            reportObjectEntityService.remove(id);
            logger.info("Данные удалены");
        } catch (Exception e) {
            logger.error("Ошибка:", e);
        }
    }
}
