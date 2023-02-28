package com.pradeep.dao;

import com.pradeep.Student;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class RowMapperImpl implements RowMapper<Student> {
    @Override
    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
        Student s=new Student();
        s.setId(rs.getInt(1));//can use column names too.
        s.setName(rs.getString(2));
        s.setCity(rs.getString(3));
        return s;
    }
}
