
package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
@RestController
public class DemoApplication {


    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name,
                        @RequestParam(value = "date", required = false) String date) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'godzina' HH:mm:ss z");
        if (date == null) {
            date = formatter.format(new Date(System.currentTimeMillis()));
        }
        return String.format("Hello %1$s! Dzisiaj jest %2$s", name, date);
    }

}
            