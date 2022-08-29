package com.itidigital.password.service;

import org.springframework.stereotype.Service;

@Service
public class PasswordService {
    public Boolean validationChars(String password) {
        int count = 0;
        char[] chars = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o',
                'p', 'q', 'r', 's','t','u','v','w','x','y','z', 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 , '!',
                '@','#','$','%','^','&','*','(',')','-','+', 'A', 'B','C','D','E','F','G','H','I','J',
                'K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        for (int i=0; i<chars.length; i++){
            count =0;
            for(int j=0; j<password.length();j++){
                if (password!=null && password.toUpperCase().charAt(j) == chars[i])
                    ++count;
                if(count>1) return false;
            }
        }
        return true;
    }

    public Boolean validationSpaces(String password){
        if(password.replace(" ", "").length()>=9) return true;

        return false;
    }

    public Boolean validationIsDigit(String password){
        for (int i = 0; i < password.length(); i++) {
            if (Character.isDigit(password.charAt(i))) return true;
        } return false;
    }

    public Boolean validationIsUppercase(String password){
        for (int i = 0; i < password.length(); i++) {
            if (Character.isUpperCase(password.charAt(i))) return true;
        } return false;
    }

    public Boolean validationIsLowercase(String password){
        for (int i = 0; i < password.length(); i++) {
            if (Character.isLowerCase(password.charAt(i))) return true;
        } return false;
    }

    public Boolean validationIsCarctereSpecial(String password){
        char[] caracterSpecial = {'!','@','#','$','%','^','&','*','(',')','-','+'};
        for (int i = 0; i < password.length(); i++) {
            for(int j=0; j <caracterSpecial.length; j++){
                if (caracterSpecial[j] == password.charAt(i)) return true;
            }
        } return false;
    }

    public Boolean validationLength(String password){
        if(password.length()>=9) return true;
        return false;
    }
}
