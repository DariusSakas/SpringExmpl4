package com.example.springexmpl4.config;

import com.example.springexmpl4.model.Department;
import com.example.springexmpl4.model.Employee;
import com.example.springexmpl4.repository.DepartmentRepository;
import com.example.springexmpl4.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class ManagementConfiguration {

    @Bean
        //use Emp. repo. to save data in DB
    CommandLineRunner commandLineRunner(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository) {
        return args -> {
            Department department1 = new Department("Dep1", "Address1");
            Department department2 = new Department("Dep2", "Address2");
            Department department3 = new Department("Dep3", "Address3");

            departmentRepository.saveAll(
                    Arrays.asList(department1, department2, department3)
            );

            employeeRepository.saveAll(
                    Arrays.asList(
                            new Employee("Will", "Smith", 1200, 4, department1
                            ),
                            new Employee("Vidas", "Pavardenis", 1900, 8, department1
                            ),
                            new Employee("Igor", " Kas ", 1400, 3, department2),
                            new Employee("Agne", " Tas ", 1450, 4, department2),
                            new Employee("Vilius", " Rasras ", 1600, 6, department3),
                            new Employee("Igor", " Antrasis ", 2100, 8, department1)
                    )

            );


        };
    }

}
