package com.example.RentalService.controller;

import com.example.RentalService.model.Rate;
import com.example.RentalService.service.NBPService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.models.auth.In;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/nbp")
public class NBPController {
    private NBPService NBPService;

    public NBPController(NBPService NBPService){
        this.NBPService = NBPService;
    }

    @ApiOperation(value = "Get avarage rate of the currency from last chosen number of days", notes = "Provide your currency and #days")
    @GetMapping("/{currency}")
    public ResponseEntity<Double> getAvarageRateFromLastXDays(@ApiParam(value = "Currency you want to retrieve",
            example = "eur") @PathVariable String currency, @ApiParam(value = "Number of days for which you" +
            "want to calculate the avarage", example = "10") @RequestParam("days") int days){
        return ResponseEntity.ok(NBPService.getAvRate(currency, days));
    }


}
