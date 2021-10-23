package com.deiaa.hellospring.controller;

import com.deiaa.hellospring.DTO.StudentDTO;
import com.deiaa.hellospring.dao.StudentDAO;
import com.deiaa.hellospring.models.Student;
import com.deiaa.hellospring.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@SessionAttributes(value = "Email")
@Controller
public class StudentController {

//    @Autowired
//    StudentService studentService; //not used when I'm using dataBase

    @Autowired
    private StudentDAO studentDAO;

    @RequestMapping(value = "/Students", method = GET)
    public String ShowStudentsPage(ModelMap model) {
        String tech= (String) model.getAttribute("Email");
        //System.out.println(tech);

        List<Student> students = studentDAO.getAllStudent(tech);

        model.addAttribute("Students", students);

        return "Students";
    }

    @RequestMapping(value = "/AddStudent", method = GET)
    public String addStudent(Model model) {
        StudentDTO studentDTO = new StudentDTO();
        model.addAttribute("student", studentDTO);
        //System.out.println("!!!!!!!!!!!!!!!!!!!");
        return "AddStudent";
    }

    @RequestMapping(value = "/saveStudent", method = POST)
    public String addStudent(Student student) {
        studentDAO.SaveStudent(student);
        //System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@");
        return "redirect:/Students";
    }

    @RequestMapping(value = "/edit-student", method = GET)
    public String editStudent(@RequestParam int id, Model model) {
        Student student = studentDAO.getStudentById(id);
        model.addAttribute("student", student);
        return "update";
    }

    @RequestMapping(value = "/update-student", method = POST)
    public String updateStudent(Student student) {
        studentDAO.update(student);
        return "redirect:/Students";
    }

    @RequestMapping(value = "/delete/{id}", method = GET)
    public String deleteStudent(@PathVariable int id) {
        //System.out.println(id);
        studentDAO.delete(id);
        return "redirect:/Students";
    }
}