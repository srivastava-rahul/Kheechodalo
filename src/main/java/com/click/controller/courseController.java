package com.click.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.click.service.courseService;

@RestController
@RequestMapping(value = "/rest")
public class courseController {

	private static final Logger LOG = Logger.getLogger(courseController.class);
	
	@Autowired
	courseService courseService;

	@RequestMapping(value = "/course")
	protected String getAllCourses(Model model) {
		LOG.info("In controller getAllCourses from getAllCourses controller");
		model.addAttribute("courseList", courseService.getAllCourses());
		return "index";
	}

	@RequestMapping(value = "/courseList")
	protected String getAllCourse() {
		LOG.info("In controller getAllCourses from getAllCourse controller");
		return "hlknj";
	}
	
}
