package com.pradeep.dao;

import com.pradeep.Student;

import java.util.List;

public interface StudentDao{
     int insert(Student student);
     int change(Student student);

     Student getStudent(int id);
     List<Student> getAllStudents();
}
