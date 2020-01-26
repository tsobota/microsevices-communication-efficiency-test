package microservice.http.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ServiceApplication {
    public static void main(String[] args) {
        System.setProperty("spring.config.name", "http-service");
        SpringApplication.run(ServiceApplication.class, args);
    }
}
