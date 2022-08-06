package com.bridgelabz.springsecurityjwt.controller;


import com.bridgelabz.springsecurityjwt.dto.ResponseDTO;
import com.bridgelabz.springsecurityjwt.entity.AddressBookDTO;
import com.bridgelabz.springsecurityjwt.entity.AddressBookData;
import com.bridgelabz.springsecurityjwt.entity.JwtResponse;
import com.bridgelabz.springsecurityjwt.service.user.IAddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class Home {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private IAddressBookService userService;


    //this api is accessible to authenticated user only
    @RequestMapping("/welcome")
    public String welcome() {
        String text = "This is a private page!!! ";
        text += "Only authorized user can access this page!!!";
        return text;
    }


    //registration api permitted to be accessed by all the users
    @PostMapping("/register")
    public ResponseEntity<AddressBookData> addUser(@Valid @RequestBody AddressBookDTO addressBookDTO) {
        addressBookDTO.setPassword(passwordEncoder.encode(addressBookDTO.getPassword()));
        AddressBookData user = userService.addUser(addressBookDTO);
        return ResponseEntity.ok(user);
    }

    @PostMapping(value = {"/add"})
    public ResponseEntity<ResponseDTO> addAddressBookData(@Valid @RequestBody AddressBookDTO addressBookDTO) {
        AddressBookData addressBookData = userService.createAddressBookData(addressBookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Data got added Successfully!!!", addressBookData);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }


}
