package com.deiaa.hellospring.dao;


import com.deiaa.hellospring.models.Student;
import com.deiaa.hellospring.models.Teacher;
import com.deiaa.hellospring.rowmapper.StudentRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {

    private JdbcTemplate jdbcTemplate;
    private DataSource dataSource;


    public StudentDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public List<Student> getAllStudent(String tech) {
        String sql ="SELECT * FROM `student` WHERE `teacher`="+"'"+tech+"'";
        List<Student> students = jdbcTemplate.query(sql, new StudentRowMapper());
        //System.out.println("*****************&&&&&&&&&&&&&&&!!!!!!!!!!!");
        //System.out.println(sql);
        return students;

    }

    @Override
    public void SaveStudent(Student student) {
        Object [] studentInfo = {
                student.getFirstName(), student.getLastName(), student.getDate(),student.getIsActive(), student.getTeacher()
        };
        String Sql=" INSERT INTO `student`(`FirstName`, `LastName`, `age`, `isActive`, `teacher`) VALUES (?,?,?,?,?)";
        jdbcTemplate.update(Sql,studentInfo);
        //System.out.println(Sql);


    }

    @Override
    public Student getStudentById(int id) {
        String Sql="SELECT `id`, `FirstName`, `LastName`, `age`, `isActive` FROM `student`WHERE `id`=?";
        //return jdbcTemplate.queryForObject(Sql,new Object [] {id},new StudentRowMapper());
        return jdbcTemplate.queryForObject(Sql, new Object [] {id} ,  new StudentRowMapper());
    }

    @Override
    public int update(Student student) {
        String Sql="UPDATE `student` SET `FirstName`='"+student.getFirstName()+"',`LastName`='"+student.getLastName()+"'," +
                "`age`='"+student.getDate()+"',`isActive`='"+student.getIsActive()+"'  WHERE `id`="+student.getId();
        //System.out.println(Sql);

        return jdbcTemplate.update(Sql);
    }

    @Override
    public int delete(int id) {
        String Sql="DELETE FROM `student` WHERE `id`="+id;
        //System.out.println(Sql);
        return jdbcTemplate.update(Sql);
    }

    @Override
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
}