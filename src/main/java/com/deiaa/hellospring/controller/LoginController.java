package com.deiaa.hellospring.controller;

import com.deiaa.hellospring.service.UserInfoStatus;
import com.deiaa.hellospring.service.CheckValidateUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@SessionAttributes(value = "Email")
public class LoginController {

    //CheckValidateUser usv = new CheckValidateUser();
//    @Autowired
//    CheckValidateUser usv;
    @Autowired
    UserInfoStatus userInfoStatus;

    @RequestMapping(value = "/login" , method = GET)
    //@ResponseBody
    public String LoginPage() {

        return "LoginPage";
    }

//    @RequestMapping(value = "/login" , method = POST )
//    //@ResponseBody
//    public String getLoginInf(@RequestParam String Email ,
//                              @RequestParam String Password ,
//                              ModelMap model) {
//
//
////        if(!usv.checkVlidateuser(Email, Password)) {
////            return "LoginPage";
////            //not used after add security;👆🏽
////
////        }
//        model.put("Email", Email);
//        model.put("Password", Password);
//        return "Home";
//
//    }
//
    @RequestMapping(value = "/home" , method = GET)
    //@ResponseBody
    public String homePage(ModelMap model) {
        model.addAttribute("Email", userInfoStatus.getLoggedInUserName());
        return "Home";
    }
}
