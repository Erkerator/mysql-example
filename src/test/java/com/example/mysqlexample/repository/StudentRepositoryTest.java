package com.example.mysqlexample.repository;

import com.example.mysqlexample.entity.Guardian;
import com.example.mysqlexample.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void printAllStudents() {
        List<Student> studentList = studentRepository.findAll();

        System.out.println("studentList = " + studentList);
    }

    @Test
    public void saveStudent() {
        Guardian guardian = Guardian.builder()
                .email("selena.gomez@gmail.com")
                .name("Selena")
                .mobile("7777777777")
                .build();

        Student student = Student.builder()
                .firstName("Sam")
                .lastName("Smith")
                .emailId("smith.sam@gmail.com")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void saveNewStudent() {
        Guardian guardian = Guardian.builder()
                .email("selena.gomez@gmail.com")
                .name("Selena")
                .mobile("7777777777")
                .build();

        Student student = Student.builder()
                .firstName("Jason")
                .lastName("Derulo")
                .emailId("derulo.jason@gmail.com")
                .beginningEducation(Date.valueOf("2015-09-1"))
                .endingEducation(Date.valueOf("2019-05-25"))
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void searchByFirstName() {
        List<Student> studentList = studentRepository.findByFirstName("sam");

        System.out.println("studentList = " + studentList);
    }

    @Test
    public void searchStudentByFirstNameAndLastName() {
        List<Student> studentList = studentRepository.findByFirstNameAndLastName("sam", "smithd");

        System.out.println("studentList = " + studentList);
    }

    @Test
    public void searchStudentByGuardianName() {
        List<Student> studentList = studentRepository.findByGuardianName("selena");

        System.out.println("studentList = " + studentList);
    }

//    @Test
//    public void searchByEducationYear() {
//        List<Student> studentList = studentRepository.findByBeginningEducationAndEndingEducationBetween(Date.valueOf("2016:09:01"), Date.valueOf("2017"));
//
//        System.out.println("studentList = " + studentList);
//    }

    @Test
    public void searchByFirstNameContaining() {
        List<Student> studentList = studentRepository.findByFirstNameContaining("a");

        System.out.println("studentList = " + studentList);
    }

    @Test
    public void searchStudentUsingQuery() {
        Student student = studentRepository.getStudentByEmailAddress("smith.sam@gmail.com");

        System.out.println("student = " + student);
    }

    @Test
    public void searchStudentFirstNameUsingQuery() {
        String studentFirstName = studentRepository.getStudentFirsNameByEmailAddress("derulo.jason@gmail.com");

        System.out.println("Student firstName = " + studentFirstName);
    }

    @Test
    public void searchStudentUsingQueryNative() {
        Student student = studentRepository.getStudentByEmailAddressNative("smith.sam@gmail.com");

        System.out.println("Student = " + student);
    }

    @Test
    public void searchStudentUsingQueryNativeNamedParam() {
        Student student = studentRepository.
                getStudentByEmailAddressNativeNamedParam("smith.sam@gmail.com", "Sam");

        System.out.println("Student = " + student);
    }

    @Test
    public void updateStudentNameUsingEmailAddress() {

        studentRepository.updateStudentNameByEmailId("Sam", "smith.sam@gmail.com");

    }

}