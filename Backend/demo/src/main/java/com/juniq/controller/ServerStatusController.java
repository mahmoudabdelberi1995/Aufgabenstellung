package com.juniq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ServerStatusController {

    @Autowired
    private RestTemplate restTemplate;


    @GetMapping("/api/checkServerStatus")
    public ResponseEntity<String> checkServerStatus(@RequestParam String url) {
        try {
            ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
            return ResponseEntity.ok().body("200");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Not 200");
        }
    }
}
