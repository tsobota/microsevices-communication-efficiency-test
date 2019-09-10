package microservices.comunication.test.amqp.transmitter;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import microservices.comunication.test.amqp.receiver.Receiver;

@Configuration
@ComponentScan
public class AmqpServiceTransmitterConfig {
    public static final String topicExchangeName = "spring-boot-exchange";

    @Bean
    RabbitTemplate rabbitTemplate() {
        return new RabbitTemplate();
    }

    @Bean
    Receiver receiver() {
        return new Receiver();
    }

}
