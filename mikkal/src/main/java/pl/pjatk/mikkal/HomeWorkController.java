package pl.pjatk.mikkal;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/homework")
public class HomeWorkController {

    @GetMapping("/get/{value}")
    public ResponseEntity<String> passValueByPath(@PathVariable ("value") String str){
        return ResponseEntity.ok(str);
    }

    @GetMapping("/get")
    public ResponseEntity<String> passValueByParam(@RequestParam("param") String str){
        return ResponseEntity.ok(str);
    }

    @PutMapping("/put/{value}")
    public ResponseEntity<Pojo> updateByPath(@PathVariable("value") int updateNumber){
        Pojo pojo = new Pojo(1, 2, 3);
        System.out.println(pojo.getField1()); // 1
        pojo.setField1(updateNumber);
        return ResponseEntity.ok(pojo);
    }

    @PutMapping("/put")
    public ResponseEntity<Pojo> updateByBody(@RequestBody Pojo replacePojo){
        Pojo pojo = new Pojo(4, 5, 6);
        System.out.println(pojo.toString());

        pojo = replacePojo;
        System.out.println(pojo.toString());
        ////em.persist(pojo)

        return ResponseEntity.ok(replacePojo);
    }

    @PostMapping("/post")
    public ResponseEntity<Pojo> returnBodyPost(@RequestBody Pojo newPojo){
        return ResponseEntity.ok(newPojo);
    }

    @DeleteMapping("/delete/{value}")
    public ResponseEntity deleteByPath(@PathVariable ("value") String delete){
        return ResponseEntity.ok().build();
    }
}
