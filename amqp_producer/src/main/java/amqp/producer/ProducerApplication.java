package amqp.producer;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class ProducerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProducerApplication.class, args);
    }

    @RestController
    public static class MessageController {
        private final RabbitTemplate rabbitTemplate;

        public MessageController(CachingConnectionFactory connectionFactory) {
            this.rabbitTemplate = new RabbitTemplate(connectionFactory);
        }

        @GetMapping("invoke")
        public String sendMessage() {
            Message response = rabbitTemplate.sendAndReceive("uppercase", null, request());
            return new String(response.getBody()) + "\n";
        }

        private static Message request() {
            Date date = new Date();
            DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
            String name = sdf.format(date);
            return new Message(name.getBytes(), new MessageProperties());
        }
    }

    @Bean
    public CachingConnectionFactory connectionFactory() {
        CachingConnectionFactory factory = new CachingConnectionFactory();
        factory.setAddresses("ec2-54-159-165-151.compute-1.amazonaws.com:5672");
        factory.setUsername("MyRabbit");
        factory.setPassword("rabbit");
        return factory;
    }
}
