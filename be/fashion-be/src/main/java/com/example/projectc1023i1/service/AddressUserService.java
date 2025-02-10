package com.example.projectc1023i1.service;

import com.example.projectc1023i1.model.AddressUser;
import com.example.projectc1023i1.model.Users;
import com.example.projectc1023i1.repository.impl.IAddressUserRepo;
import com.example.projectc1023i1.service.impl.IAddressUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressUserService implements IAddressUserService {
    @Autowired
    private IAddressUserRepo addressUserRepository;

    @Override
    public void addAddressUser(AddressUser addressUser) {
        addressUserRepository.save(addressUser);
    }

    @Override
    public AddressUser getAddressUser(Integer id) {
        return addressUserRepository.findByUser(id);
    }

    @Override
    public void saveAddressUser(AddressUser addressUser) {
        addressUserRepository.save(addressUser);
    }


}
