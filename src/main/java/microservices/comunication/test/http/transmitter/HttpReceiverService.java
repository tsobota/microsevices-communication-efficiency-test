package microservices.comunication.test.http.transmitter;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class HttpReceiverService {
    @Autowired
    @LoadBalanced
    protected RestTemplate restTemplate;

    protected String serviceUrl;

    protected Logger logger = Logger.getLogger(HttpReceiverService.class.getName());

    public HttpReceiverService(String serviceUrl) {
        this.serviceUrl = serviceUrl.startsWith("http") ? serviceUrl
                : "http://" + serviceUrl;
    }

    @PostConstruct
    public void demoOnly() {
        // Can't do this in the constructor because the RestTemplate injection
        // happens afterwards.
        logger.warning("The RestTemplate request factory is "
                + restTemplate.getRequestFactory().getClass());
    }

    public String sendPing() {
        ResponseEntity<String> response = restTemplate.getForEntity(serviceUrl + "/", String.class);

        logger.log(Level.INFO, response.getBody());
        return response.getBody();
        //        ObjectMapper mapper = new ObjectMapper();
//        JsonNode root = mapper.readTree(response.getBody());
//        JsonNode message = root.path("name")
    }

}
