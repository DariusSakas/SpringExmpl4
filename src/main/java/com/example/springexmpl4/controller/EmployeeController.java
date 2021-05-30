package com.example.springexmpl4.controller;

import com.example.springexmpl4.model.Employee;
import com.example.springexmpl4.service.EmployeeService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@Slf4j
@AllArgsConstructor //@Autowired automatically
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("/")
    public List<Employee> getAllEmployees(){
        log.info("Fetching all employees from database");

        return employeeService.getAllEmployees();
    }
    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id){
        log.info("Fetching employee from DB by ID");
        return employeeService.getAllEmployeesById(id);

    }
    @GetMapping("/{firstName}")
    public Employee getEmployeeByName(@RequestParam String firstName){
        return employeeService.getEmployeeByName(firstName);
    }
    @PostMapping("/")
    public List<Employee> addEmployee(@RequestBody Employee employee){
        log.info("Adding " + employee.toString() +" employee to DB");
        return employeeService.addEmployee(employee);
    }
    @DeleteMapping("/{id}")
    public List<Employee> deleteEmployeeById(@PathVariable Long id){
        log.info("Deleting employee from DB by ID" + id);
        employeeService.deleteEmployeeById(id);
        return employeeService.getAllEmployees();
    }
    @PutMapping("/")
    public Employee updateEmployee(@RequestBody Employee employee){
        log.info("Updating employee with new data "+ employee);
        employeeService.updateEmployee(employee);
        return employeeService.getAllEmployeesById(employee.getId());
    }

}
