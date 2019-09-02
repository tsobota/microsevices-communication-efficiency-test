package microservices.comunication.test.http.transmitter;

import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@ComponentScan
@AutoConfigureBefore(HttpReceiverService.class)
public class HttpServiceTransmitterConfig {

    public static final String HTTP_RECEIVER_SERVICE_URL = "http://localhost:2223";


    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public HttpReceiverService httpReceiverService(){
        return new HttpReceiverService(HTTP_RECEIVER_SERVICE_URL);
    }
}
