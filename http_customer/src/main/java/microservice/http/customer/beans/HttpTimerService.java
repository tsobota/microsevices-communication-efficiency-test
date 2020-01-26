package microservice.http.customer.beans;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

public class HttpTimerService {
    private String serviceUrl;
    protected Logger logger = Logger.getLogger(HttpTimerService.class.getName());
    @Autowired
    protected RestTemplate restTemplate;

    public HttpTimerService(String serviceUrl) {
        this.serviceUrl = serviceUrl;
    }

    public String sendTime(Long size) {

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        Byte[] bytesArray = new Byte[size.intValue()];

        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        body.add("file", bytesArray);

        HttpEntity<MultiValueMap<String, Object>> requestEntity =
                new HttpEntity<>(body, httpHeaders);

        Date date = new Date();
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        String stringDate = sdf.format(date);
        String url = serviceUrl + "/?time=" + stringDate;

        ResponseEntity<String> response = restTemplate.exchange(
                url,
                HttpMethod.POST,
                requestEntity,
                String.class);

        return response.getBody() + "\n";
    }
}
