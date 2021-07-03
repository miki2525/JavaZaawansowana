package project.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.model.jaznbp;
import project.service.jaznbpService;

import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

@RestController
@RequestMapping("/jaznbpcontroller")
public class jaznbpController {

    private jaznbpService jaznbpService;

    public jaznbpController(jaznbpService jaznbpService){
        this.jaznbpService = jaznbpService;
    }



    @GetMapping("/{waluta}")
    public ResponseEntity<Double> getKurs(@PathVariable String waluta, @RequestParam("start") String datastartstr,
                                  @RequestParam("koniec") String datakoniecstr){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        LocalDate datastart = LocalDate.parse(datastartstr, dtf);
        LocalDate datakoniec = LocalDate.parse(datakoniecstr, dtf);
        Date requestDateTime = Calendar.getInstance().getTime();
        Double kurs = jaznbpService.getKurs(waluta, datastartstr, datakoniecstr);

        jaznbp log = new jaznbp(waluta, datastart, datakoniec, kurs, requestDateTime);
        jaznbpService.saveLog(log);

        return ResponseEntity.ok(kurs);
    }
}
