package com.example.demo.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.CourseRepository;
import com.example.demo.Repository.StudentRepository;
import com.example.demo.entity.Course;
import com.example.demo.entity.Student;
import com.example.demo.entity.User;



@Service
public class StudentService {

	@Autowired
	public StudentRepository repo;
	
	@Autowired 
	public CourseRepository courserepo;
	
	
	public List<Student> listAll(){
		return repo.findAll();
		}
	public void save(Student  student) {
		repo.save(student);
	}
//	public Student get(Integer Id) {
//		return repo.findById(Id).get();
//	}
//	public void delete(Integer id) {
//		repo.deleteById(id);
//	
//	}
}
