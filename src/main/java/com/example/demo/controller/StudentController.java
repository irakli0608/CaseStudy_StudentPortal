package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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
	    List<Course> listcourse = services.listAll();
		List<Student> listStudent = service.listAll();
		model.addAttribute("listcourse", listcourse);
		model.addAttribute("course", new Course());
		for(Student S: listStudent) {
			System.out.println(S.getEmail());
		}
		for(Course C: listcourse) {
		System.out.println(C.getName());
		}
		model.addAttribute("liststudent", listStudent);
		  model.addAttribute("student", new Student());
		return "student";
		
	}

	
	@RequestMapping("/addstudent")
	public String showNewProductFrom(Model model) {
		Student student = new Student();
		model.addAttribute("student", student);
		return "addstudent";
	}
//	
//	
//	  @RequestMapping(value = "/save", method = RequestMethod.POST)
//    public String saveStudent(@ModelAttribute("student") Student std)
//    {
//        service.save(std);
//        return "redirect:/student";
//    }
//    
//	 @RequestMapping("/edit/{id}")
//	    public ModelAndView showEditStudentPage(@PathVariable(name = "id") int id) {
//	        ModelAndView mav = new ModelAndView("addstudent");
//	        List<Course> listcourse = services.listAll();
//	        Student std = service.get(id);
//	        mav.addObject("student", std);
//	        return mav;
//	        
//	    }
//	    @RequestMapping("/delete/{id}")
//	    public String deleteStudentPage(@PathVariable(name = "id") int id) {
//	        service.delete(id);
//	        return "student";
//	    }
}