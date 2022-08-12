package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.entity.Course;
import com.example.demo.entity.User;
import com.example.demo.service.StudentService;
import com.example.demo.service.UserService;

@Controller
public class StudentController {
	@Autowired
	private StudentService studentServices;
	
	@Autowired
	private UserService userService;

//	@GetMapping("/student")
//	public String showShoppingCart(Model model, @AuthenticationPrincipal Authentication authentication) {
//
//		User username = userService.getCurrentlyLoggedInUser(authentication);
//
//		List<Course> cartItems = courseService.listCartItems(username);
//
//		model.addAttribute("cartItems", cartItems);
//
//		return "student";
//	}
}
