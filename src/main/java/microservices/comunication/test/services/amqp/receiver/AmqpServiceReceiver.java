package microservices.comunication.test.services.amqp.receiver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;

import javafx.application.Application;
import microservices.comunication.test.amqp.receiver.AmqpServiceReceiverConfig;

@SpringBootApplication
@EnableDiscoveryClient
@Import(AmqpServiceReceiverConfig.class)
public class AmqpServiceReceiver {

    public static void main(String[] args) {
        System.setProperty("spring.config.name", "amqp-receiver-server");
        SpringApplication.run(Application.class, args).close();
    }
}
