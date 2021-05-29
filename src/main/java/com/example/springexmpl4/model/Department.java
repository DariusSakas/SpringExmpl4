package com.example.springexmpl4.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "department_id")
    private Long id;
    @Column(nullable = false)
    private String name;
    private String address;

    @OneToMany(mappedBy = "department" )
    private List<Employee> employee;

    public Department(String name, String address) {
        this.name = name;
        this.address = address;
    }
}
