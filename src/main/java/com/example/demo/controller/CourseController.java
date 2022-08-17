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
import com.example.demo.service.CourseService;



@Controller
public class CourseController {
	@Autowired
	private CourseService service;

	@RequestMapping("/")
	public String uselogin() {
		return "login";
	}
	@GetMapping("/registry")
	public String userRegister(){
		return "registry";
	}
	


	@GetMapping("/questions")
	public String userQuestions() {
		return "questions";
	}
	
	
	@RequestMapping("/index")
	public String userFromQuestions() {		
		return "index";
	}

	
	@RequestMapping("/course")
	public String viewCoursePage(Model model) {
		List<Course> listProducts = service.listAll();
		model.addAttribute("listCourse", listProducts);
		return "course";
	}

	
	@RequestMapping("/new")
	public String showNewProductFrom(Model model) {
		Course course = new Course();
		model.addAttribute("course", course);
		return "new_course";
	}
	
	
	@RequestMapping(value= "/save", method = RequestMethod.POST)
	public String saveCourse(@ModelAttribute("course") Course course) {
		service.save(course);
		
		
		return "redirect:/course";
	}
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditProductFrom(@PathVariable(name = "id") Integer id) {
		ModelAndView mav = new ModelAndView("edit_course");
		Course course = service.get(id);
		mav.addObject("course", course);
		return mav;
	}

	@RequestMapping("/delete/{id}")
	public String deleteProduct(@PathVariable(name="id") Integer id) {
		service.delete(id);
		return "redirect:/course";
	}
}
