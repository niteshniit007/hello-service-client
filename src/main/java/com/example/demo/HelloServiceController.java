package com.example.demo;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloServiceController {

	@Autowired
	RestTemplate restTemplate;
	

    @GetMapping("/")
    public String handleRequest(Model model) {
        //accessing hello-service
        HelloObject helloObject = restTemplate.getForObject("http://ABC-SERVICE/hello", HelloObject.class);
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>"  + helloObject.getMessage());
        model.addAttribute("msg", helloObject.getMessage());
        model.addAttribute("time", LocalDateTime.now());
        return "hello-page";
    }
}
