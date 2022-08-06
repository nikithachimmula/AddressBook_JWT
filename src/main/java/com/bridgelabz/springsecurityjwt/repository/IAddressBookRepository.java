package com.bridgelabz.springsecurityjwt.repository;

import com.bridgelabz.springsecurityjwt.entity.AddressBookData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAddressBookRepository extends JpaRepository<AddressBookData, Long> {

    public AddressBookData findByUsername(String username);
}