package com.example.springexmpl4.controller;

import com.example.springexmpl4.model.Department;
import com.example.springexmpl4.service.DepartmentService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
@Slf4j
@AllArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;

    @GetMapping("/")
    public List<Department> getAllEmployees(){
        log.info("Fetching all departments from database");
        return departmentService.getAllDepartments();
    }
    @GetMapping("/{id}")
    public Department getEmployeeById(@PathVariable Long id){
        log.info("Fetching departments from DB by ID");
        return departmentService.getAllDepartmentsById(id);
    }
    @GetMapping("/{departmentName}")
    public Department getDepartmentByName(@RequestParam String departmentName){
        return departmentService.getDepartmentByName(departmentName);
    }
    @PostMapping("/")
    public List<Department> addEmployee(@RequestBody Department department){
        log.info("Adding " + department.toString() +" employee to DB");
        return departmentService.addDepartment(department);
    }
    @DeleteMapping("/{id}")
    public List<Department> deleteEmployeeById(@PathVariable Long id){
        log.info("Deleting employee from DB by ID" + id);
        departmentService.deleteDepartmentById(id);
        return departmentService.getAllDepartments();
    }
    @PutMapping("/")
    public Department updateEmployee(@RequestParam Department department){
        log.info("Updating deparment with new data "+ department);
        departmentService.updateDepartment(department);
        return departmentService.getAllDepartmentsById(department.getId());
    }
}
