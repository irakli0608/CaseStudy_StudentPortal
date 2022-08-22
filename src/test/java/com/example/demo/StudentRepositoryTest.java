package com.example.demo;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

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
	
	
	
	@Test
	public void testFindProductByName() {
		List<Student> student = (List<Student>) repo.findAll("Irakli@gmail.com");
	assertThat(student.get(0).getEmail()).isEqualTo("Irakli@gmail.com");
	}
	
	@Test
    public void testDelete() {
        Integer student = 87;
        repo.deleteById(87);
        Optional<Student> optionalMember = repo.findById(student);
        Assertions.assertThat(optionalMember).isNotPresent();
    }

	
}
