package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@RestController
public class HelloWorldController {

    @RequestMapping
    public String helloWorld() {
        return "Hello world";
    }
    @RequestMapping("/new")
    public String test(){
        return "new";
    }
    @GetMapping("/good")
    public String good(){
        return "good";
    }



    @Autowired
    private RestTemplate restTemplate;
    public  String url = "https://randomuser.me/api/?seed=abc";
    @GetMapping ("users/{seed}")
    public ResponseEntity<?> getusers(@PathVariable("seed") String seed){
        url = url+seed;
        var users = restTemplate.getForObject(url, String.class);
         return ResponseEntity.ok(users);
    }





}
