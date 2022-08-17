package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Course;
import com.example.demo.repository.CourseRepository;


@Service
public class CourseService {
	@Autowired
	public CourseRepository repo;
	
	public List<Course> listAll(){
		return repo.findAll();
		}
	public void save(Course  course) {
		repo.save(course);
	}
	public Course get(Integer Id) {
		return repo.findById(Id).get();
	}
	public void delete(Integer id) {
		repo.deleteById(id);
	}
}
