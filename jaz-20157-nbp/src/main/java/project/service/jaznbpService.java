package project.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import project.model.Root;

import java.time.LocalDate;

@Service
public class jaznbpService {

    private RestTemplate restTemplate;

    public jaznbpService(RestTemplate restTemplate){

        this.restTemplate = restTemplate;
    }

    public Double getKurs(String waluta, String start, String koniec){
        String url = "http://api.nbp.pl/api/exchangerates/rates/a/" + waluta +"/" + start + "/" + koniec +"/";
        Root root = restTemplate.getForObject(url, Root.class);

        return root.getRates()
                .stream()
                .mapToDouble(x->x.getMid())
                .average().orElse(0.0);
    }
}
