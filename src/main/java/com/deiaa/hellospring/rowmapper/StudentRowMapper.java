package com.deiaa.hellospring.rowmapper;

import com.deiaa.hellospring.models.Student;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentRowMapper implements RowMapper<Student> {
    @Override
    public Student mapRow(ResultSet resultSet, int i) throws SQLException {
        Student student = new Student();
        student.setId(resultSet.getInt("id"));
        student.setFirstName(resultSet.getString("FirstName"));
        student.setLastName(resultSet.getString("LastName"));
        student.setDate(resultSet.getString("age"));
        student.setActive(resultSet.getBoolean("isActive"));
        return student;
    }

}
