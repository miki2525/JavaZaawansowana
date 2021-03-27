package pl.pjatk.mikkal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
//@ImportResource("classpath:applicationContext.xml")
public class MikkalApplication {

	public static void main(String[] args) {
		SpringApplication.run(MikkalApplication.class, args);
	}

}
