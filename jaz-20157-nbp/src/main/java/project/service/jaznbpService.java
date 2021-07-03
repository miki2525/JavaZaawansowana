package project.service;

import org.springframework.web.client.RestTemplate;
import project.model.Root;

import java.time.LocalDate;

public class jaznbpService {

    private RestTemplate restTemplate;

    public jaznbpService(RestTemplate restTemplate){

        this.restTemplate = restTemplate;
    }

    public Double getAvRate(String waluta, LocalDate start){
        String url = "http://api.nbp.pl/api/exchangerates/rates/a/gbp/2012-01-01/2012-01-31/" + waluta + "/last/" + start;
        Root root = restTemplate.getForObject(url, Root.class);

        return root.getRates()
                .stream()
                .mapToDouble(x->x.getMid())
                .average().orElse(0.0);
    }
}
