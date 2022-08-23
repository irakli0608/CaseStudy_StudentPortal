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

	// lists courses
	@RequestMapping("/course")
	public String viewCoursePage(Model model) {
		List<Course> listCourses = service.listAll();
		model.addAttribute("listCourse", listCourses);
		return "course";
	}

	// creates new course 
	@RequestMapping("/new")
	public String showNewCourseFrom(Model model) {
		Course course = new Course();
		model.addAttribute("course", course);
		return "new_course";
	}
	
	// saves courses 
	@RequestMapping(value= "/savecourse", method = RequestMethod.POST)
	public String saveCourse(@ModelAttribute("course") Course course) {
		service.save(course);
		
		
		return "redirect:/course";
	}
	
	// edits course 
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditCourseFrom(@PathVariable(name = "id") Integer id) {
		ModelAndView mav = new ModelAndView("edit_course");
		Course course = service.get(id);
		mav.addObject("course", course);
		return mav;
	}
// deletes course 
	@RequestMapping("/deletecourse/{id}")
	public String deleteCourse(@PathVariable(name="id") Integer id) {
		service.delete(id);
		return "redirect:/course";
	}
}
