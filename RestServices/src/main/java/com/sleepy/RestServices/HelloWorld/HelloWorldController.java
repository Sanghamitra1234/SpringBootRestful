package com.sleepy.RestServices.HelloWorld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	//@RequestMapping(method=RequestMethod.GET,path="/hello") //1. METHOD 2. PATH
		@GetMapping("/helloi")
		public String helloWorld() {
					return "helo World";
				}
		@GetMapping("/user")
		public UserDetails getDetails() {
			return new UserDetails("sanghamitra","hota","pune");
			
		}
	}
