package microservices.comunication.test.http.receiver;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import freemarker.template.SimpleDate;

import static org.aspectj.bridge.Version.getTime;

@RestController
public class HttpServiceReceiverController {
    Logger logger = Logger.getLogger(HttpServiceReceiverController.class.getName());

    @PostMapping("/")
    public String newDate(@RequestParam("time")String time, @RequestBody String body) {
        Date currentTime = new Date();
        Date requestTime = null;
        Long response = 0L;
        try {
            requestTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse(time);
            response = currentTime.getTime() - requestTime.getTime();
            logger.log(Level.INFO, "response: " + response.toString() + " ms");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return response.toString();
    }
}
