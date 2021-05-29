package com.example.springexmpl4.service;

import com.example.springexmpl4.model.Employee;
import com.example.springexmpl4.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service //sukuria sitos klases BEAN (configuracija)
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired //AllArgsConstructor can be used instead of all this (will autowire automatically)
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees(){

        return employeeRepository.findAll();
    }
    public Employee getAllEmployeesById(Long id){
        return employeeRepository.findById(id).orElse(null);
    }

    public List<Employee> addEmployee(Employee employee) {
        employeeRepository.save(employee);
        return employeeRepository.findAll();
    }

    public void deleteEmployeeById(Long id) {
        employeeRepository.deleteById(id);
    }


    public void updateEmployee(Employee employee) {
        employeeRepository.save(employee); //issaugo, jei neegzistuoja nauja

    }
}
