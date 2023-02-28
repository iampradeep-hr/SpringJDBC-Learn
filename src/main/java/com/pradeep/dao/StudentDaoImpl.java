package com.pradeep.dao;

import com.pradeep.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

public class StudentDaoImpl implements StudentDao{

    private JdbcTemplate jdbcTemplate;
    @Override
    public int insert(Student student) {
        //insert
        String query="INSERT INTO student(id,name,city) values(?,?,?)";
        int result=this.jdbcTemplate.update(query,student.getId(),student.getName(),student.getCity());
        return result;
    }

    @Override
    public int change(Student student) {
        //update
        String query="UPDATE student set name=?,city=? WHERE id=?";
        int result=this.jdbcTemplate.update(query,student.getId(),student.getName(),student.getCity());
        return result;
    }

    @Override
    public Student getStudent(int id) {
        String query="SELECT * FROM student WHERE id=?";
        RowMapper<Student> rowMapper=new RowMapperImpl();
        Student student=this.jdbcTemplate.queryForObject(query,rowMapper,id);
        return student;
    }

    @Override
    public List<Student> getAllStudents() {
        String query="SELECT * FROM student";
        List<Student> studentList=this.jdbcTemplate.query(query,new RowMapperImpl());
        return studentList;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
