package microservices.comunication.test.services.amqp.transmitter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import microservices.comunication.test.amqp.transmitter.AmqpServiceTransmitterConfig;

@SpringBootApplication
@EnableDiscoveryClient
@Import(AmqpServiceTransmitterConfig.class)
public class AmqpServiceTransmitter {
    public static void main(String[] args) {
        System.setProperty("spring.config.name", "amqp-transmitter-server");
        SpringApplication.run(AmqpServiceTransmitter.class, args);
    }
}
