package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Student;






public interface StudentRepository extends JpaRepository <Student, Integer>{

	//Student findByEmail(String email);
	@Query("select s from Student s LEFT JOIN FETCH s.course c  ")
	List<Student> findStudents();
	
//	@Query(value="select s.email, c.name from student s Inner JOIN course c ON s.email=c.name", nativeQuery=true)
//	List<Student> findStudent();
}
