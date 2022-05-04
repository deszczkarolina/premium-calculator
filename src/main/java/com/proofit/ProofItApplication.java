package com.proofit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class ProofItApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProofItApplication.class, args);
    }

}
