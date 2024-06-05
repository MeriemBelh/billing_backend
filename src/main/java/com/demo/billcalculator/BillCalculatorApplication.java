package com.demo.billcalculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan
public class BillCalculatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(BillCalculatorApplication.class, args);
	}

}
