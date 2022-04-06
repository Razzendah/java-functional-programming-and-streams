package com.programming;

import java.util.List;
import java.util.function.Supplier;

public class FP03MethodReferences {

	public static void main(String[] args) throws Exception {
		List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker",
				"Kubernetes");

		courses.stream()
				//.map(str -> str.toUpperCase())
				.map(String::toUpperCase) // non static
				.forEach(FP03MethodReferences::print); // static

		Supplier<String> supplier = String::new; // constructor reference

	}

	private static void print(String string1) {
		System.out.println(string1);
	}

}