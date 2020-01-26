package microservice.http.customer.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import microservice.http.customer.beans.HttpTimerService;

@Configuration
public class HttpTimerServiceConfiguration {
    public static final String HTTP_SERVICE_URL = "http://ip-172-31-86-252.ec2.internal:2223";

    @Bean
    SimpleClientHttpRequestFactory simpleClientHttpRequestFactory() {
        return new SimpleClientHttpRequestFactory();
    }

    @Bean
    RestTemplate restTemplate(SimpleClientHttpRequestFactory factory) {
        return new RestTemplate(factory);
    }

    @Bean
    HttpTimerService httpTimerService() {
        return new HttpTimerService(HTTP_SERVICE_URL);
    }
}
