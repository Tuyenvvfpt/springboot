package com.example.fw_09.services.StudentServiceImplement;

import com.example.fw_09.entities.Address;
import com.example.fw_09.repositories.AddressRepository;
import com.example.fw_09.services.IAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AddressService implements IAddressService {
    @Autowired
    private AddressRepository addressRepository;

    @Override
    public List<Address> getAll() {
        return addressRepository.findAll();
    }
}
