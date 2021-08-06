package com.example.mysqlexample.repository;

import com.example.mysqlexample.entity.Course;
import com.example.mysqlexample.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher() {
        Course course = Course.builder()
                .title("Chess course")
                .credit(3)
                .build();

        List<Course> courseList = new ArrayList<Course>();
        courseList.add(course);

        Teacher teacher = Teacher.builder()
                .firstName("John")
                .lastName("Lenon")
                .courses(courseList)
                .build();

        teacherRepository.save(teacher);
    }

    @Test
    public void getAllTeachers() {
        List<Teacher> teacherList = teacherRepository.findAll();

        System.out.println("teacherList = " + teacherList);
    }
}