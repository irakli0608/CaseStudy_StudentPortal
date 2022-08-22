package com.example.demo;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.ClassOrderer.OrderAnnotation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.example.demo.entity.Course;
import com.example.demo.repository.CourseRepository;
 
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class CourseRepositoryTests {

	@Autowired
	private CourseRepository repo;
	
	@Autowired
	private TestEntityManager entityManager;

	
	@Test
	@Rollback(true)
	public void testListCourse() {
	List<Course> courses = (List<Course>) repo.findAll();
	assertThat(courses).size().isGreaterThan(0);
	}
	
	@Test
	@Rollback(true)
	public void testDeleteProduct() {
	    Course course = repo.findByName("Algebra");
	     
	    repo.deleteById(course.getId());
	     
	    Course deletedCourse = repo.findByName("Algebra");
	     
	    assertThat(deletedCourse).isNull();       
	     
	}
	
	@Test
	public void testFindCourseByName() {
	    Course course = repo.findByName("Java");    
	    assertThat(course.getName()).isEqualTo("Java");
	}

	@Test
	@Rollback(true)
	public void testUpdateCourse() {
		Course course = repo.findByName("JavaScript");
		course.setCredit(5);
		repo.save(course);
		Course updatedProduct = repo.findByName("JavaScript");
		assertThat(updatedProduct.getCredit()).isGreaterThan(0);

	}
	
}
	

