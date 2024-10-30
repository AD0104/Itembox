package com.itembox.itembox.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
    @RequestMapping(method = RequestMethod.GET, value = "/healthcheck")
    public ResponseEntity<String> healthCheck() {
        return new ResponseEntity<>("Ok", HttpStatus.OK);
    }
}
