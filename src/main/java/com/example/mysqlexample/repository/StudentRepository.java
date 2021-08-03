package com.example.mysqlexample.repository;

import com.example.mysqlexample.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByFirstName(String firstName);
    List<Student> findDistinctByLastName(String lastName);
    List<Student> findByFirstNameAndLastName(String firstName,String lastName);

}
