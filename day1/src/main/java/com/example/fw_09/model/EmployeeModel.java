package com.example.fw_09.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeModel {
    private long id;
    private String name;
    private int age;
    private long id_address;
}
