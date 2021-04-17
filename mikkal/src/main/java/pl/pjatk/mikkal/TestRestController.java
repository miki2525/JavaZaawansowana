package pl.pjatk.mikkal;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class TestRestController {


    //ex1
    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("Hello world");
    }
//ex2

    @GetMapping("/model")
    public ResponseEntity<Pojo> giveMePojo() {
        Pojo pojo = new Pojo(1, 2, 3);
        pojo.setText("Hej");
        pojo.setTextDefault("Jestem w body");
        return ResponseEntity.ok(pojo);
    }
//ex3
    @GetMapping("/hello/{someValue}")
    public ResponseEntity<String> giveMeValue(@PathVariable String someValue) {
        return ResponseEntity.ok(someValue);
    }
//ex4
@GetMapping("/hello1")
public ResponseEntity<String> giveMeReqParam(@RequestParam("reqParam") String someValue) {
    return ResponseEntity.ok(someValue);
}
//ex5
    @PostMapping("/model")
    public ResponseEntity<Pojo> returnNewPojo(@RequestBody Pojo pojo){
            return ResponseEntity.ok(pojo);
    }

}
