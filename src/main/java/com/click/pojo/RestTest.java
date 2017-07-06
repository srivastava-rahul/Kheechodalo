package com.click.pojo;

import org.springframework.web.client.RestTemplate;

public class RestTest {
public static void main(String[] args) {
	RestTemplate rtemp = new RestTemplate();
	
	System.out.println(rtemp.getForObject("http://localhost:9999/webApp/rest/courseList", String.class));
}
}
