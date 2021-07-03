package project.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jaznbpcontroller")
public class jaznbpController {


    @GetMapping("/{waluta}")
    public Double getKurs(@PathVariable String waluta, @RequestParam("start") String datastart,
                   @RequestParam("koniec") String datakoniec){
        return 1.0;
    }
}
