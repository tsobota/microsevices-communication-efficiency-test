package microservices.comunication.test.amqp.transmitter;

import java.util.concurrent.TimeUnit;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import microservices.comunication.test.amqp.receiver.Receiver;

@RestController
public class AmqpServiceTransmitterRestController {


    @Autowired
    RabbitTemplate rabbitTemplate;
    @Autowired
    Receiver receiver;

    @GetMapping("/")
    public void sendMessage() throws Exception {
        System.out.println("Sending message...");
        rabbitTemplate.convertAndSend(AmqpServiceTransmitterConfig.topicExchangeName, "foo.bar.baz", "Hello from RabbitMQ!");
        receiver.getLatch().await(10000, TimeUnit.MILLISECONDS);
    }
}
