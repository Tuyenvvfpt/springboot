package com.example.fw_09.services;

import com.example.fw_09.dto.EmployeeDTO;
import com.example.fw_09.entities.Employee;

import java.util.List;

public interface IEmployeeService {
    List<EmployeeDTO> getAll();
}
