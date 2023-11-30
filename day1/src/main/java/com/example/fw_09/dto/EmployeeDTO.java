package com.example.fw_09.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class EmployeeDTO {
    private Long id;
    private String name;
    private int age;
    private AddressDTO address;
}
