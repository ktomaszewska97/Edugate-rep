package edugate.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"edugate.demo.controllers", "edugate.demo.model", "edugate.demo.repositories"})
public class EdugateApplication {

	public static void main(String[] args) {
		SpringApplication.run(EdugateApplication.class, args);
	}

}
