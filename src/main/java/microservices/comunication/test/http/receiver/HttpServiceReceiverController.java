package microservices.comunication.test.http.receiver;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HttpServiceReceiverController {

    @RequestMapping(value = "/")
    public String newDate() {
        return "Hello World";
    }
}
