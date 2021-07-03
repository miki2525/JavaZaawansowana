package project.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Not found"),
            @ApiResponse(code = 500, message = "BOOM NULL")
    })
    @ApiOperation(value = "Pokaż średnią kursu między wybranymi datami", notes = "Podaj walutę oraz zakres dat")
    @GetMapping("/{waluta}")
    public ResponseEntity<Double> getKurs(@ApiParam(value = "Wybrana waluta",
            example = "eur")@PathVariable String waluta, @ApiParam(value = "Data początek",
            example = "2012-05-05")@RequestParam("start") String datastartstr, @ApiParam(value = "Data koniec",
            example = "2012-05-07") @RequestParam("koniec") String datakoniecstr){
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
