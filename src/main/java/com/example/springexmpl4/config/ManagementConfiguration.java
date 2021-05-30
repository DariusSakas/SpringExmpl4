package com.example.springexmpl4.config;

import com.example.springexmpl4.model.Department;
import com.example.springexmpl4.model.Email;
import com.example.springexmpl4.model.Employee;
import com.example.springexmpl4.repository.DepartmentRepository;
import com.example.springexmpl4.repository.EmailRepository;
import com.example.springexmpl4.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class ManagementConfiguration {

    @Bean
        //use Emp. repo. to save data in DB
    CommandLineRunner commandLineRunner(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository, EmailRepository emailRepository) {
        return args -> {

            Department department1 = new Department("Dep1", "Address1");
            Department department2 = new Department("Dep2", "Address2");
            Department department3 = new Department("Dep3", "Address3");

            departmentRepository.save(department1);
            departmentRepository.save(department2);
            departmentRepository.save(department3);

            employeeRepository.saveAll(
                    Arrays.asList(
                            new Employee("Will", "Smith", 1200, 4, department1
                            ),
                            new Employee("Vidas", "Pavardenis", 1900, 8, department3
                            ),
                            new Employee("Igor", " Kas ", 1400, 3, department2),
                            new Employee("Agne", " Tas ", 1450, 4, department2),
                            new Employee("Vilius", " Rasras ", 1600, 6, department2),
                            new Employee("Igor", " Antrasis ", 2100, 8, department1)

//            new Employee("Will", "Smith", 1200, 4
//            ),
//                    new Employee("Vidas", "Pavardenis", 1900, 8
//                    ),
//                    new Employee("Igor", " Kas ", 1400, 3),
//                    new Employee("Agne", " Tas ", 1450, 4),
//                    new Employee("Vilius", " Rasras ", 1600, 6),
//                    new Employee("Igor", " Antrasis ", 2100, 8)
                    )
            );
            emailRepository.saveAll(
                    Arrays.asList(new Email("darius.shakas@gmail.com", "Darius", "Testing mail sending", "Lorem ipsum"))

            );


        };
    }

}
