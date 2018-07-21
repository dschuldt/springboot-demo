package de.dschuldt.springbootdemo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Controller
public class SimpleWebservice {

    private String version;
    private String ip;


    public SimpleWebservice() throws UnknownHostException {
        this.version = "1.2";
        this.ip = InetAddress.getLocalHost().toString();
    }


    @GetMapping("/")
    @ResponseBody
    public String sayHello() {
        return String.format("Spring Boot Demo v%s running on %s", version, ip);
    }

    @GetMapping("/api")
    @ResponseBody
    public String sayHelloAgain(){
        return String.format("You have hit the /api endpoint of Spring Boot Demo v%s running on %s", version, ip);
    }
}
