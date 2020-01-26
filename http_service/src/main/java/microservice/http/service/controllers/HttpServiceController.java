package microservice.http.service.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HttpServiceController {
    Logger logger = Logger.getLogger(HttpServiceController.class.getName());

    @PostMapping("/")
    public String newDate(
            @RequestParam("time")
                    String time,
            @RequestBody
                    String body) {
        Date currentTime = new Date();
        Date requestTime = null;
        Long response = 0L;
        try {
            requestTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse(time);
            response = currentTime.getTime() - requestTime.getTime();

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return response.toString();
    }
}
