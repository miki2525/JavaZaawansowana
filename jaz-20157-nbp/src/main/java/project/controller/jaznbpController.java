package project.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.service.jaznbpService;

@RestController
@RequestMapping("/jaznbpcontroller")
public class jaznbpController {

    private jaznbpService jaznbpService;

    public jaznbpController(jaznbpService jaznbpService){
        this.jaznbpService = jaznbpService;
    }


    @GetMapping("/{waluta}")
    public ResponseEntity<Double> getKurs(@PathVariable String waluta, @RequestParam("start") String datastart,
                                  @RequestParam("koniec") String datakoniec){

        return ResponseEntity.ok(jaznbpService.getKurs(waluta, datastart, datakoniec));
    }
}
