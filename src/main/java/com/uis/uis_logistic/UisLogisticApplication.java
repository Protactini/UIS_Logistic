package com.uis.uis_logistic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.uis.uis_logistic.model")
public class UisLogisticApplication {

    public static void main(String[] args) {


        SpringApplication.run(UisLogisticApplication.class, args);
    }

}
