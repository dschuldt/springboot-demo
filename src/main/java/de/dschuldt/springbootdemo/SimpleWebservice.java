package de.dschuldt.springbootdemo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Properties;

@Controller
public class SimpleWebservice {

    private String version;
    private String ip;


    public SimpleWebservice() throws UnknownHostException {
        this.version = "1.3";
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

    @GetMapping("/env")
    @ResponseBody
    public String printEnv() throws IOException {
        InputStream input = new FileInputStream("/app/config/app.properties");
        Properties prop = new Properties();
        prop.load(input);
        return String.format("This is your environment: %s", prop.getProperty("environment") , ip);
    }
}
