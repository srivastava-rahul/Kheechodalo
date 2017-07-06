package com.click.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.click.service.courseService;

@RestController
@RequestMapping(value = "/rest")
public class courseController {

	@Autowired
	courseService courseService;

	@RequestMapping(value = "/course")
	protected String getAllCourses(Model model) {
		System.out.println("In controller getAllCourses");
		model.addAttribute("courseList", courseService.getAllCourses());
		return "index";
	}

	@RequestMapping(value = "/courseList")
	protected String getAllCourse() {
		System.out.println("In controller getAllCourses");
		return "hlknj";
	}
	
}
