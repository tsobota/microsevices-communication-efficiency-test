package microservices.comunication.test.http.transmitter;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transmitter")
public class HttpServiceTransmitterController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String newDate() {
        return "Hello World";
    }
}
