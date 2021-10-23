package com.deiaa.hellospring.dao;

import com.deiaa.hellospring.models.Student;

import javax.sql.DataSource;
import java.util.List;

public interface StudentDAO {

    List<Student> getAllStudent(String tech);
    void SaveStudent(Student student);
    Student getStudentById(int id);
    int update(Student student);
    int delete(int id);

    public void setDataSource(DataSource dataSource);

}