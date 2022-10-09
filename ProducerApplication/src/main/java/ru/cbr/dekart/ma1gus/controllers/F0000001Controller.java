package ru.cbr.dekart.ma1gus.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.cbr.dekart.ma1gus.services.ParseOESForReportObjectService;
import ru.cbr.dekart.ma1gus.services.SenderService;
import ru.cbr.dekart.objects.ReportObject;


@RestController
@RequestMapping("/api1")
public class F0000001Controller {


    @Autowired(required = false)
    private ReportObject reportObject;

    @Autowired
    private SenderService senderService;

    @Autowired
    private ParseOESForReportObjectService parseOESForReportObjectService;
   private Logger logger = LoggerFactory.getLogger(this.getClass());

    @PostMapping(value = "file",  produces = MediaType.MULTIPART_FORM_DATA_VALUE, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> getFieldF0000001(@RequestParam(value = "infile") MultipartFile textInBytes) throws Exception {
        String strOes = new String(textInBytes.getBytes());
        reportObject = new ReportObject();
        try {
            reportObject = parseOESForReportObjectService.parseF0000001FieldFromXMLFile(strOes);
            logger.info("Данные внесены в поле объекта");
        } catch (Exception e) {
            logger.error("Ошибка:", e);
        }
        senderService.send("route_bus_leveldown", reportObject);
        return ResponseEntity.ok("Файл получен");
    }
}