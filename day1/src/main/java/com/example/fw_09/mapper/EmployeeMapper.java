package com.example.fw_09.mapper;

import com.example.fw_09.dto.AddressDTO;
import com.example.fw_09.dto.EmployeeDTO;
import com.example.fw_09.entities.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {
    public EmployeeDTO toDto(Employee employee){
        return  EmployeeDTO.builder()
                .id(employee.getId())
                .name(employee.getName())
                .age(employee.getAge())
                .address(new AddressDTO(
                        employee.getAddress().getId(),
                        employee.getAddress().getName(),
                        employee.getAddress().getCode()))
                .build();
    }
}
