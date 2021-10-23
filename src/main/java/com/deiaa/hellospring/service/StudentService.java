package com.deiaa.hellospring.service;


import com.deiaa.hellospring.models.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class StudentService {
    private static int StudentId=0;
    private static ArrayList<Student> students = new ArrayList<Student>();

    public ArrayList<Student> readAllStudents(){
        ArrayList<Student> student = new ArrayList<Student>();
        for(Student st : students) {
            student.add(st);
        }
        return student;
    }

    public void addStudent(String firstname, String lastName , String date){
        students.add(new Student(++StudentId, firstname,lastName ,date,true));
    }

    public void deletStudent(int id){
        Iterator<Student> itr= students.iterator();
        while(itr.hasNext()){
            Student student= itr.next();
            if(student.getId()==id)
                itr.remove();
        }
    }

    public Student getStudentInfo(int id){
        for (Student s: students) {
            if(s.getId()==id)
                return s;
        }
        return null;
    }
    public void UpdateStudentData(int id,String firstname, String lastName , String date ){
        Iterator<Student> itr= students.iterator();
        while(itr.hasNext()){
            Student student= itr.next();
            if(student.getId()==id) {
                student.setFirstName(firstname);
                student.setLastName(lastName);
                student.setDate(date);
            }
        }
    }


}
