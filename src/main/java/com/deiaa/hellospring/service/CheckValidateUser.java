package com.deiaa.hellospring.service;

import org.springframework.stereotype.Service;
//not used after add security
@Service
public class CheckValidateUser {


    public boolean checkVlidateuser(String Email,
            String Password){
        if(Email.equals("deiaa@gmail.com") && Password.equals("1234")) {
            return true;
        }
        else
            return false;
    }

}
