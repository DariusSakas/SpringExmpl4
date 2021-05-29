package com.example.springexmpl4.service;

import com.example.springexmpl4.model.Employee;
import com.example.springexmpl4.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class EmployeeServiceTest {

    private Long id = 0L;

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeService employeeService;

    @Test
    public void testGetAllEmployess(){

        when(employeeRepository.findAll()).thenReturn(createEmployeeList());

        List<Employee> fetchedEmployees = employeeService.getAllEmployees();

        assertThat(fetchedEmployees.get(0).getFirstName(), is("Test0"));
        assertThat(fetchedEmployees.get(1).getFirstName(), is("Test1"));
        assertThat(fetchedEmployees.get(2).getFirstName(), is("Test2"));
        assertThat(fetchedEmployees.get(3).getFirstName(), is("Test3"));
    }

    private Employee createEmployee(){
        Employee employee = new Employee("Test" +id , "Test" +id, Math.toIntExact(id), Math.toIntExact(id));
        employee.setId(id);
        id++;
        return employee;
    }
    private List<Employee> createEmployeeList(){
        List<Employee> employees = new ArrayList<>();
        employees.add(createEmployee());
        employees.add(createEmployee());
        employees.add(createEmployee());
        employees.add(createEmployee());

        return employees;

    }
}
