package com.example.fw_09.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@Entity
@Table(name="address")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String code;

    @OneToMany(mappedBy = "address")
//    @JsonIgnore
//    @JsonManagedReference
    private List<Employee> employeeList;
}
