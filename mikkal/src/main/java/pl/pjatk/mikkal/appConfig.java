package pl.pjatk.mikkal;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
class AppConfig {

@ConditionalOnProperty(value = "create.the.bean",
                        havingValue = "true",
                        matchIfMissing = false) //default, no need
    @Bean
    public Pojo pojo(){
    System.out.println("Call me Mr. TrueBean");
    return new Pojo(1, 2, 3);
}
        ///zad 2 27.03
//    @Bean
//    public Pojo pojo(Pojo secondPojo){
//        System.out.println("before: " + secondPojo.getField1());
//        secondPojo.setField1(10);
//        System.out.println("after: " + secondPojo.getField1());
//        System.out.println("after: " + secondPojo.getTextDefault());
//        return new Pojo(1, 2, 3);
//    }

//    @Bean
//    public Pojo secondPojo(){
//        return new Pojo(1, 2, 3);
//    }

//    ///zad 3 27.03
//    @Bean
//    public List<String> defaultData() {
//        System.out.println("from defaulData");
//        return List.of("1", "2", "3", "4", "5");
//    }
//
//    @Bean
//    public List<String> anotherDefaultData() {
//        System.out.println("from anotherData");
//        return List.of("1", "2", "3");
//    }
}
