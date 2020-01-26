package amqp.customer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerApplication.class, args);
    }

    public static class MessageListener {
        public String handleMessage(byte[] message) {
            Date currentTime = new Date();
            Date requestTime = null;
            String content = new String(message);
            Long response = 0L;
            try {
                requestTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse(content);
                response = currentTime.getTime() - requestTime.getTime();
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return response.toString();
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

    @Bean
    public SimpleMessageListenerContainer serviceListenerContainer() {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory());
        container.setConcurrentConsumers(20);
        container.setMaxConcurrentConsumers(40);
        container.setQueueNames("uppercase_messages");
        container.setMessageListener(new MessageListenerAdapter(new MessageListener()));
        return container;
    }
}
