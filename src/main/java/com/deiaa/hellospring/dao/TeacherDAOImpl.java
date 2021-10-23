package com.deiaa.hellospring.dao;

import com.deiaa.hellospring.models.Student;
import com.deiaa.hellospring.models.Teacher;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class TeacherDAOImpl implements TeacherDAO{

    private JdbcTemplate jdbcTemplate;
    private DataSource dataSource;

    public TeacherDAOImpl(DataSource dataSource) {

        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void SaveTeacher(Teacher teacher) {
        Object [] teacherInfo = {
                teacher.getUsername(), teacher.getPassword()
        };
        String Sql=" INSERT INTO `users`(`username`, `password`) VALUES (?,?) ";
        jdbcTemplate.update(Sql,teacherInfo);
        update(teacher);
        SaveTeacherRole(teacher);

    }
    @Override
    public int update(Teacher teacher) {
        String pass="{noop}"+teacher.getPassword();
        String Sql=" UPDATE `users` SET `username`='"+teacher.getUsername()+"',`password`='"+pass+"'WHERE `username`= "+"'"+teacher.getUsername()+"'";
        //String Sql="UPDATE `users` SET `username`="+teacher.getUsername()+"',`password`='"+pass+"' WHERE `username`="+teacher.getUsername();
        //System.out.println(Sql);

        return jdbcTemplate.update(Sql);
    }
    @Override
    public int SaveTeacherRole(Teacher teacher) {
        String Sql=" INSERT INTO `user_roles`(`username`, `role`) VALUES ('"+teacher.getUsername()+"','ROLE_USER') ";
        //System.out.println(Sql);

        return jdbcTemplate.update(Sql);
    }

    @Override
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
}
