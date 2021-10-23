package com.deiaa.hellospring.dao;

import com.deiaa.hellospring.models.Student;
import com.deiaa.hellospring.models.Teacher;

import javax.sql.DataSource;

public interface TeacherDAO {
    void SaveTeacher(Teacher teacher);

    int update(Teacher teacher);

    int SaveTeacherRole(Teacher teacher);

    public void setDataSource(DataSource dataSource);
}
