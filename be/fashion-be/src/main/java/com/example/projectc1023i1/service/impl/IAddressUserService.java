package com.example.projectc1023i1.service.impl;

import com.example.projectc1023i1.model.AddressUser;
import com.example.projectc1023i1.model.Users;

public interface IAddressUserService {
    void addAddressUser(AddressUser addressUser);
    AddressUser getAddressUser(Integer id);
    void saveAddressUser(AddressUser addressUser);
}
