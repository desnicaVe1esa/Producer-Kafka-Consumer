package ru.cbr.dekart.ma1gus.controllers;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.cbr.dekart.ma1gus.services.ParseOESForReportObjectService;
import ru.cbr.dekart.ma1gus.services.SenderService;
import ru.cbr.dekart.objects.ReportObject;



@RestController
@RequestMapping("/api")
public class ReportObjectController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ParseOESForReportObjectService parseOESForReportObjectService;

    @Autowired
    private SenderService senderService;


    @RequestMapping(value = "properties", method = RequestMethod.GET)
    public ResponseEntity<String> getProperties(@RequestParam(value = "priority", required = true) String priority) {
        ReportObject reportObject = new ReportObject();
        try {
            reportObject = parseOESForReportObjectService.putParameter(priority);
            logger.info("Данные внесены в поле объекта");
        } catch (Exception e) {
            logger.error(String.valueOf(e));
        }
        logger.info(" ");
        senderService.send("route_bus_leveldown", reportObject);
        return ResponseEntity.ok("Все нормально");
    }
}
