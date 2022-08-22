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
	List<Course> products = (List<Course>) repo.findAll();
	assertThat(products).size().isGreaterThan(0);
	}
	
	@Test
	@Rollback(true)
	public void testDeleteProduct() {
	    Course product = repo.findByName("Algebra");
	     
	    repo.deleteById(product.getId());
	     
	    Course deletedCourse = repo.findByName("Algebra");
	     
	    assertThat(deletedCourse).isNull();       
	     
	}
	
	@Test
	@Rollback(true)
	public void testUpdateProduct() {
		Course product = repo.findByName("JavaScript");
		product.setCredit(5);
		repo.save(product);
		Course updatedProduct = repo.findByName("JavaScript");
		assertThat(updatedProduct.getCredit()).isGreaterThan(0);

	}
	
}
	

