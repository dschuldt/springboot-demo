package de.dschuldt.springbootdemo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Controller
public class SimpleWebservice {

    @GetMapping("/")
    @ResponseBody
    public String sayHello() throws UnknownHostException {
        String version = "1.1";
        String ip = InetAddress.getLocalHost().toString();
        return String.format("Spring Boot Demo v%s running on %s", version, ip);
    }

}
