package com.pradeep;


import com.pradeep.dao.StudentDao;
import com.pradeep.dao.StudentDaoImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.function.Consumer;

@ImportResource("config.xml")



public class App {
    public static void main(String[] args) {

        System.out.println("Welcome to my Student Management App xD:)");

        ApplicationContext context= new ClassPathXmlApplicationContext(
                "file:src/main/resources/config.xml"
        );

       StudentDao studentDao= context.getBean("studentDao", StudentDao.class);
//       Student student=new Student(404,"Mr Beast","US");
//        int insert = studentDao.insert(student);
//        System.out.println(insert+" rows affected...");

        System.out.println("Getting ");
        List<Student> list=studentDao.getAllStudents();
        list.forEach(System.out::println);



    }


}

