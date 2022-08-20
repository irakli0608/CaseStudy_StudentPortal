package com.example.demo;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.example.demo.entity.Course;
import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
 
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class StudentRepositoryTest {

	@Autowired
	private StudentRepository repo;
	
	@Test
	@Rollback(true)
	public void testListStudent() {
	List<Student> student = (List<Student>) repo.findAll();
	assertThat(student).size();
	}
	
}
