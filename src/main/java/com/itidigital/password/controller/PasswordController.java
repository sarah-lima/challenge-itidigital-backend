package com.itidigital.password.controller;

import com.itidigital.password.dto.PasswordDto;
import com.itidigital.password.service.PasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class PasswordController {
    @Autowired
    PasswordService passwordService;

    @PostMapping
    public ResponseEntity passwordValidation(@RequestBody PasswordDto password){
        if(passwordService.validationIsUppercase(password.getPassword()) &&
                passwordService.validationIsDigit(password.getPassword()) &&
                passwordService.validationChars(password.getPassword()) &&
                passwordService.validationIsLowercase(password.getPassword()) &&
                passwordService.validationIsCarctereSpecial(password.getPassword()) &&
                passwordService.validationSpaces(password.getPassword()) &&
                passwordService.validationLength(password.getPassword())){
            return ResponseEntity.status(200).body(true);
        }
        return ResponseEntity.status(401).body(false);
    }


}
