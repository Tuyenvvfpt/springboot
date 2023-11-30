package com.example.fw_09.resource;

import com.example.fw_09.dto.EmployeeDTO;
import com.example.fw_09.entities.Employee;
import com.example.fw_09.model.EmployeeModel;
import com.example.fw_09.services.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody EmployeeModel employeeModel){
        //gui di la DTO
        //nhan ve la Model
        iEmployeeService.save(employeeModel);
        System.out.println("");
        return new ResponseEntity<>("save okkk", HttpStatus.OK);
    }


}
