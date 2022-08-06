package com.bridgelabz.springsecurityjwt.service.user;

import com.bridgelabz.springsecurityjwt.entity.AddressBookDTO;
import com.bridgelabz.springsecurityjwt.entity.AddressBookData;

import java.util.List;

public interface IAddressBookService {
    public AddressBookData addUser(AddressBookDTO user);

    public List<AddressBookData> getUsers();
    AddressBookData createAddressBookData(AddressBookDTO addressBookDTO);

}
