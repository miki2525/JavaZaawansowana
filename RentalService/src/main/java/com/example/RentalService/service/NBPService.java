package com.example.RentalService.service;

import com.example.RentalService.model.Rate;
import com.example.RentalService.model.Root;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class NBPService {

    private RestTemplate restTemplate;

    public NBPService(RestTemplate restTemplate){

        this.restTemplate = restTemplate;
    }

    public Double getAvRate(String curr, int days){
        String url = "http://api.nbp.pl/api/exchangerates/rates/a/" + curr + "/last/" + days;
        Root root = restTemplate.getForObject(url, Root.class);

        return root.getRates()
                .stream()
                .mapToDouble(x->x.getMid())
                .average().orElse(0.0);
    }



}
