package com.example.springexmpl4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class SpringExmpl4Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringExmpl4Application.class, args);
    }

}
