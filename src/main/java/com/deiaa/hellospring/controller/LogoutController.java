package com.deiaa.hellospring.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class LogoutController {

    @RequestMapping(value = "/logout" , method = GET)
    //@ResponseBody
    public String Logout(HttpServletRequest req , HttpServletResponse res) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(auth != null){
            new SecurityContextLogoutHandler().logout(req,res,auth);
            req.getSession().invalidate();
        }
        return "redirect:/";
    }
}
