package microservices.comunication.test.http.receiver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.util.logging.Logger;

@EnableAutoConfiguration
@EnableDiscoveryClient
public class HttpServiceReceiver {

    protected Logger logger = Logger.getLogger(HttpServiceReceiver.class.getName());

    /**
     * Run the application using Spring Boot and an embedded servlet engine.
     *
     * @param args
     *            Program arguments - ignored.
     */
    public static void main(String[] args) {
        // Tell server to look for accounts-server.properties or
        // accounts-server.yml
        System.setProperty("spring.config.name", "http-receiver-server");

        SpringApplication.run(HttpServiceReceiver.class, args);
    }
}
