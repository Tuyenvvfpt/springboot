package com.example.fw_09.resource;

import com.example.fw_09.entities.Address;
import com.example.fw_09.services.IAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("address")
public class AddressRest {
    @Autowired
    private IAddressService iAddressService;

    @GetMapping("/getAll")
    public ResponseEntity<List<Address>> getAll(){
        List<Address> addressList = iAddressService.getAll();

        return new ResponseEntity<>(addressList, HttpStatus.OK);
    }
}
