package microservices.comunication.test.http.transmitter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HttpServiceTransmitterController {

    @Autowired
    HttpReceiverService httpReceiverService;

    @RequestMapping(value = "/")
    String sendMessage(@RequestParam(name = "size")Long size ) {
        return httpReceiverService.sendTime(size);
    }
}
