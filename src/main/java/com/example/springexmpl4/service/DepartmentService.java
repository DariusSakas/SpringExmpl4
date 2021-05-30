package com.example.springexmpl4.service;

import com.example.springexmpl4.model.Department;
import com.example.springexmpl4.repository.DepartmentRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public List<Department> getAllDepartments(){

        return departmentRepository.findAll();
    }
    public Department getAllDepartmentsById(Long id){

        return departmentRepository.findById(id).orElse(null);
    }

    public List<Department> addDepartment(Department department) {
        departmentRepository.save(department);
        return departmentRepository.findAll();
    }

    public void deleteDepartmentById(Long id) {
        departmentRepository.deleteById(id);
    }

    public void updateDepartment(Department department) {
        departmentRepository.save(department); //issaugo, jei neegzistuoja nauja
    }
    public Department getDepartmentByName(String name){
        return departmentRepository.getDepartmentByName(name);
    }

}
