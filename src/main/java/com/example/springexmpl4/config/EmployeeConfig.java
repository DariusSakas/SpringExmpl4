package com.example.springexmpl4.config;

import com.example.springexmpl4.model.Employee;
import com.example.springexmpl4.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class EmployeeConfig {

    @Bean
        //use Emp. repo. to save data in DB
    CommandLineRunner commandLineRunner(EmployeeRepository employeeRepository) {
        return args -> {
            employeeRepository.saveAll(
                    Arrays.asList(
                            new Employee("Will", "Smith", 1200, 4
                            ),
                            new Employee("Vidas", "Pavardenis", 1900, 8
                            ),
                            new Employee("Igor", " Kas ", 1400, 3),
                            new Employee("Agne", " Tas ", 1450, 4),
                            new Employee("Vilius", " Rasras ", 1600, 6),
                            new Employee("Igor", " Antrasis ", 2100, 8)
                    )
            );
        };
    }

}
