package microservices.comunication.test.services.http.transmitter;

import java.util.logging.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;
import org.springframework.web.client.RestTemplate;

import microservices.comunication.test.http.transmitter.HttpReceiverService;
import microservices.comunication.test.http.transmitter.HttpServiceTransmitterConfig;
import microservices.comunication.test.services.http.receiver.HttpServiceReceiver;

@SpringBootApplication
//@ComponentScan({"microservices.comunication.test.http.transmitter"})
@EnableDiscoveryClient
@Import(HttpServiceTransmitterConfig.class)
public class HttpServiceTransmitter {
    protected Logger logger = Logger.getLogger(HttpServiceTransmitter.class.getName());

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
