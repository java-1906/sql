package com.example.application;

import java.util.NoSuchElementException;

import com.example.models.User;
import com.exxample.service.UserService;

public class Application {
	public static void main(String[] args) {
		System.out.println("Welcome");
//		
//		try {			
//			User peter = UserService.getService().addUser("Peter", "music", false).get();
//			System.out.println(peter);
//		} catch (NoSuchElementException e) {
//			System.out.println("Something went wrong");
//		}
		 
		try {			
			User user = UserService.getService().login("quinn", "hello").get();
			String admingMsg = (user.isAdmin()) ? " you are admin" : " you are not admin";
			System.out.println("Welcome " + user.getUsername() + admingMsg);			
		} catch(NoSuchElementException e) {
			System.out.println("Service is down sorry \\(^_^)/");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
