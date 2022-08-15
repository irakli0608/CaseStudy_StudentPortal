package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Student;






public interface StudentRepository extends JpaRepository <Student, Integer>{

//	@Query("select s from Student s  ")
//	public List<Student> findStudents();
}
