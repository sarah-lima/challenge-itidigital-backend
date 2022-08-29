package com.itidigital.password.service;

import com.itidigital.password.dto.PasswordDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class PasswordServiceTests {

    @InjectMocks
    PasswordService passwordService;

    @Test
    public void notValidationChars(){
        PasswordDto passwordDto = new PasswordDto();
        passwordDto.setPassword("AbTp9!foA");
        String password = passwordDto.getPassword();
        Boolean result = passwordService.validationChars(password);
        assertEquals(false, result);
    }

    @Test
    public void isValidationChars(){
        PasswordDto passwordDto = new PasswordDto();
        passwordDto.setPassword("AbTp9!fok");
        String password = passwordDto.getPassword();
        Boolean result = passwordService.validationChars(password);
        assertEquals(true, result);
    }

    @Test
    public void isValidationNumeric(){
        PasswordDto passwordDto = new PasswordDto();
        passwordDto.setPassword("AbTp9!fok");
        String password = passwordDto.getPassword();
        Boolean result = passwordService.validationIsDigit(password);
        assertEquals(true, result);
    }

    @Test
    public void notValidationNumeric(){
        PasswordDto passwordDto = new PasswordDto();
        passwordDto.setPassword("AbTp9!fok");
        String password = passwordDto.getPassword();
        Boolean result = passwordService.validationIsDigit(password);
        assertEquals(true, result);
    }

    @Test
    public void isValidationLowerCase(){
        PasswordDto passwordDto = new PasswordDto();
        passwordDto.setPassword("AbTp9!fok");
        String password = passwordDto.getPassword();
        Boolean result = passwordService.validationIsLowercase(password);
        assertEquals(true, result);
    }

    @Test
    public void notValidationLowerCase(){
        PasswordDto passwordDto = new PasswordDto();
        passwordDto.setPassword("AUYFJHBT9!");
        String password = passwordDto.getPassword();
        Boolean result = passwordService.validationIsLowercase(password);
        assertEquals(false, result);
    }

    @Test
    public void isValidationUpperCase(){
        PasswordDto passwordDto = new PasswordDto();
        passwordDto.setPassword("AbTp9!fok");
        String password = passwordDto.getPassword();
        Boolean result = passwordService.validationIsUppercase(password);
        assertEquals(true, result);
    }

    @Test
    public void notValidationUpperCase(){
        PasswordDto passwordDto = new PasswordDto();
        passwordDto.setPassword("abtp9!fok");
        String password = passwordDto.getPassword();
        Boolean result = passwordService.validationIsUppercase(password);
        assertEquals(false, result);
    }

    @Test
    public void isValidationSpecialCaracter(){
        PasswordDto passwordDto = new PasswordDto();
        passwordDto.setPassword("abtp9!fok");
        String password = passwordDto.getPassword();
        Boolean result = passwordService.validationIsCarctereSpecial(password);
        assertEquals(true, result);
    }

    @Test
    public void notValidationSpecialCaracter(){
        PasswordDto passwordDto = new PasswordDto();
        passwordDto.setPassword("abtp9jfok");
        String password = passwordDto.getPassword();
        Boolean result = passwordService.validationIsCarctereSpecial(password);
        assertEquals(false, result);
    }

    @Test
    public void notValidationSpace(){
        PasswordDto passwordDto = new PasswordDto();
        passwordDto.setPassword("AbTp9 fok");
        String password = passwordDto.getPassword();
        Boolean result = passwordService.validationSpaces(password);
        assertEquals(false, result);
    }

    @Test
    public void isValidationSpace(){
        PasswordDto passwordDto = new PasswordDto();
        passwordDto.setPassword("abtp9!fok");
        String password = passwordDto.getPassword();
        Boolean result = passwordService.validationSpaces(password);
        assertEquals(true, result);
    }

    @Test
    public void isValidationLength(){
        PasswordDto passwordDto = new PasswordDto();
        passwordDto.setPassword("Abtp9!fok");
        String password = passwordDto.getPassword();
        Boolean result = passwordService.validationLength(password);
        assertEquals(true, result);
    }

    @Test
    public void notValidationLength(){
        PasswordDto passwordDto = new PasswordDto();
        passwordDto.setPassword("Abtp9!fo");
        String password = passwordDto.getPassword();
        Boolean result = passwordService.validationLength(password);
        assertEquals(false, result);
    }
}
