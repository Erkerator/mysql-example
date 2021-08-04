package com.example.mysqlexample.repository;

import com.example.mysqlexample.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.sql.Date;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByFirstName(String firstName);
    List<Student> findDistinctByLastName(String lastName);
    List<Student> findByFirstNameAndLastName(String firstName,String lastName);
    List<Student> findByGuardianName(String name);
//    List<Student> findByBeginningEducationAndEndingEducationBetween(Date start, Date finish);
    List<Student> findByFirstNameContaining(String letters);

    //JPQL
    @Query("select s from Student s where s.emailId = ?1 ")
    Student getStudentByEmailAddress(String emailAddress);

    //JPQL
    @Query("select s.firstName from Student s where s.emailId = ?1 ")
    String getStudentFirsNameByEmailAddress(String emailAddress);

    //Native
    @Query(
            value = "SELECT * FROM tbl_student s where s.email_address = ?1",
            nativeQuery = true
    )
    Student getStudentByEmailAddressNative(String emailAddress);

    //Native Named Param
    @Query(
            value = "SELECT * FROM tbl_student s where s.email_address = :emailId and s.first_name = :name",
            nativeQuery = true
    )
    Student getStudentByEmailAddressNativeNamedParam(
            @Param("emailId") String emailAddress,
            @Param("name") String firstName
    );

    @Modifying
    @Transactional
    @Query(
            value = "update tbl_student set first_name = ?1 where email_address = ?2",
            nativeQuery = true
    )
    int updateStudentNameByEmailId(String name, String emailId);
}
