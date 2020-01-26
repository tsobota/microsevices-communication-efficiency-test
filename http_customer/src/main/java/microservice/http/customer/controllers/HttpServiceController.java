package microservice.http.customer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import microservice.http.customer.beans.HttpTimerService;

@RestController
@RequestMapping("/")
public class HttpServiceController {

    @Autowired
    HttpTimerService httpTimerService;

    @GetMapping
    String sendMessage(@RequestParam(name = "size")Long size ) {
        return httpTimerService.sendTime(size);
    }
}
