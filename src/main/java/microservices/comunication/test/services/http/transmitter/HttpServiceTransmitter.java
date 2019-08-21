package microservices.comunication.test.services.http.transmitter;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

import microservices.comunication.test.http.transmitter.HttpReceiverService;

@SpringBootApplication
@ComponentScan(basePackages="microservices.comunication.test.http.transmitter")
@EnableDiscoveryClient
public class HttpServiceTransmitter {
    protected Logger logger = Logger.getLogger(HttpServiceTransmitter.class.getName());

    public static final String HTTP_RECEIVER_SERVICE_URL = "http://http-receiver-server";

    @LoadBalanced
    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }


    @Bean
    public HttpReceiverService httpReceiverService(){
        return new HttpReceiverService(HTTP_RECEIVER_SERVICE_URL); //TODO Change ACCOUNT_SERVICE +_URL NAME
    }

    /**
     * Run the application using Spring Boot and an embedded servlet engine.
     *
     * @param args
     *            Program arguments - ignored.
     */
    public static void main(String[] args) {
        // Tell server to look for accounts-server.properties or
        // accounts-server.yml
        System.setProperty("spring.config.name", "http-transmitter-server");

        SpringApplication.run(HttpServiceTransmitter.class, args);
    }
}
