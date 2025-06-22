package org.example.springapp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app")
public class SpringAppController {

    @GetMapping("/sayHello")
    ResponseEntity<String> sayHello(){
        return ResponseEntity.ok("Hello World!!");
    }
}
