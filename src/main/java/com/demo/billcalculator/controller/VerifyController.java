package com.demo.billcalculator.controller;

import com.demo.billcalculator.model.Order;
import com.demo.billcalculator.model.OrderDTO;
import com.demo.billcalculator.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/verify")
public class VerifyController {


    public static class Hello{
        private String name;
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    }

    @PostMapping
    public ResponseEntity<String> verify(@RequestBody Hello hello ) {

            return ResponseEntity.ok("good");
        }
}


