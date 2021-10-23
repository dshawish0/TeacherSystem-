package com.deiaa.hellospring.controller;

import com.deiaa.hellospring.DTO.TeacherDTO;
import com.deiaa.hellospring.dao.TeacherDAO;
import com.deiaa.hellospring.models.Student;
import com.deiaa.hellospring.models.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class TeacherController {

    @Autowired
    private TeacherDAO teacherDAO;

    @RequestMapping(value = "/SignUp", method = GET)
    public String Register (Model model) {
        TeacherDTO teacherDTO = new TeacherDTO();
        model.addAttribute("teacher", teacherDTO);
        return "SignUpPage";
    }

    @RequestMapping(value = "/saveTeacher", method = POST)
    public String addTeacher(Teacher teacher) {
        teacherDAO.SaveTeacher(teacher);
        //System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        return "redirect:/login";
    }

}
