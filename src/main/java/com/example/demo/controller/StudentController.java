package com.example.demo.controller;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.entity.Course;
import com.example.demo.entity.Student;
import com.example.demo.service.CourseService;
import com.example.demo.service.StudentService;

@Controller
public class StudentController {
	@Autowired
	private StudentService service;

	@Autowired
	private CourseService services;


	@RequestMapping("/student")
	public String viewCoursePage(Model model) {
		List<Student> listStudent = service.listAll();
		List<Course> listCourse = services.listAll();
		for(Student S: listStudent) {
			System.out.println(S.getEmail());
			System.out.println(S.getCourse().get(0).getName());
			System.out.println(S.getCourse().get(0).getCredit());
		}
		model.addAttribute("liststudent", listStudent);
		 model.addAttribute("student", new Student());
		return "student";
	}

	
	@GetMapping("/addstudent")
	public String showNewProductFrom(Model model) {
		Student student = new Student();
		model.addAttribute("student", student);
		return "addstudent";
	}
	
	
  @RequestMapping(value = "/save", method = RequestMethod.POST)
  public String saveStudent(@ModelAttribute("student") Student student)
   {
       service.save(student);
       return "redirect:/student";
   }

	    @GetMapping("/delete/{id}")
	    public   String  deleteStudentPage(@PathVariable(name = "id") int id) {
			List<Student> listStudent = service.listAll();
	        service.delete(id);
	        try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	       return "redirect:/student";
	    }
}