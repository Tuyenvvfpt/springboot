package com.example.fw_09.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "employee")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private int age;

    @ManyToOne
    @JoinColumn(name = "address_id", nullable = false)
//  //@JsonIgnore
//    @JsonBackReference
    private Address address;
}
