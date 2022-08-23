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
// lists courses 
	@Test
	@Rollback(true)
	public void testListCourse() {
		List<Course> courses = (List<Course>) repo.findAll();
		assertThat(courses).size().isGreaterThan(0);
	}
// create course 
	@Test
	@Rollback(true)
	public void testCreateCourse() {
		Course course = new Course();
		course.setName("junit");
		course.setCredit(3);
		Course savedCourse = repo.save(course);
		assertThat(savedCourse.getName()).isEqualTo("junit");
		assertThat(savedCourse.getCredit()).isEqualTo("3");
		assertThat(savedCourse.getId()).isGreaterThan(0);
	}
// delete course needs actual course in order to delete 
	@Test
	@Rollback(true)
	public void testDeleteCourse() {
		Course course = repo.findByName("junit");
		repo.deleteById(course.getId());
		Course deletedCourse = repo.findByName("junit");
		assertThat(deletedCourse).isNull();

	}
// finds by name 
	@Test
	@Rollback(true)
	public void testFindCourseByName() {
		Course course = repo.findByName("Java");
		assertThat(course.getName()).isEqualTo("Java");
	}
// updates course
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
