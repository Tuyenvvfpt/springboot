package com.example.fw_09.resource;

import com.example.fw_09.dto.EmployeeDTO;
import com.example.fw_09.entities.Employee;
import com.example.fw_09.services.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("employee")
public class EmployeeRest {
    @Autowired
    private IEmployeeService iEmployeeService;

    @GetMapping("/getAll")
    public ResponseEntity<List<EmployeeDTO>> getAll(){
        List<EmployeeDTO> employeeList = iEmployeeService.getAll();

        return new ResponseEntity<>(employeeList,HttpStatus.OK);
    }
}
