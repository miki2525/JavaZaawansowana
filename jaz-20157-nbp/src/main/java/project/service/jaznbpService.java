package project.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import project.exception.jaznbpBadRequest;
import project.exception.jaznbpNotFoundException;
import project.model.Root;
import project.model.jaznbp;
import project.repository.jaznbpRepository;

import java.time.LocalDate;

@Service
public class jaznbpService {

    private RestTemplate restTemplate;
    private jaznbpRepository jaznbpRepository;

    public jaznbpService(RestTemplate restTemplate, jaznbpRepository jaznbpRepository){
        this.jaznbpRepository = jaznbpRepository;
        this.restTemplate = restTemplate;
    }

    public jaznbp saveLog(jaznbp jaznbp){
        return jaznbpRepository.save(jaznbp);
    }


    public Double getKurs(String waluta, String start, String koniec){
        if(!start.matches("^[0-9]{4}-[0-9]{2}-[0-9]{2}") || !koniec.matches("^[0-9]{4}-[0-9]{2}-[0-9]{2}")){
            throw new jaznbpBadRequest();
        }
        String url = "http://api.nbp.pl/api/exchangerates/rates/a/" + waluta +"/" + start + "/" + koniec +"/";
        Root root = restTemplate.getForObject(url, Root.class);

        if (root==null || root.getRates().isEmpty()){
            throw new jaznbpNotFoundException();
        }

        return root.getRates()
                .stream()
                .mapToDouble(x->x.getMid())
                .average().orElse(0.0);
    }
}
