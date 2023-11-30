package com.example.fw_09.services.StudentServiceImplement;

import com.example.fw_09.dto.EmployeeDTO;
import com.example.fw_09.entities.Employee;
import com.example.fw_09.mapper.EmployeeMapper;
import com.example.fw_09.model.EmployeeModel;
import com.example.fw_09.repositories.AddressRepository;
import com.example.fw_09.repositories.EmployeeRepository;
import com.example.fw_09.services.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service


public class EmployeeService implements IEmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;
    @Autowired
    private EmployeeRepository employeeRepository;
    //day 4
    @Autowired
    private AddressRepository addressRepository;

    @Override
    public List<EmployeeDTO> getAll() {
//        return employeeRepository.findAll();
        List<EmployeeDTO> employeeDTOS = employeeRepository.findAll().
                stream().map(e -> employeeMapper.toDto(e)).toList();
        return employeeDTOS;
    }

    @Override
    public void save(EmployeeModel employeeModel) {
        Employee employee = new Employee();
        employee.setName(employeeModel.getName());
        employee.setAge(employeeModel.getAge());
        employee.setAddress(addressRepository.findById(employeeModel.getId_address()).get());
        //
        employeeRepository.save(employee);
    }
}
