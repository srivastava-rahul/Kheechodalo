package com.click.serviceImpl;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.click.service.courseService;

@Component
public class courseServiceImpl implements courseService{
	
	public List<String> getAllCourses(){

		List<String> courseList = new ArrayList<String>();
		
		courseList.add("core");
		courseList.add("jdbc");
		courseList.add("hibernate");
		courseList.add("Spring");
		
		return courseList;
	}
}
