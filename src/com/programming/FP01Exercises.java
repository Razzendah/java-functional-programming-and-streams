package com.programming;

import java.util.List;

public class FP01Exercises {

	public static void main(String[] args) throws Exception {
		List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
		List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker",
				"kubernetes");

		System.out.println("- - - - - - -Odd Numbers - - - - - - - - - - - ");
		numbers.stream().filter(n -> n % 2 != 0).forEach(System.out::println);

		System.out.println("- - - - - - - - All Courses- - - - - - - - - - ");
		courses.stream().forEach(System.out::println);

		System.out.println("- - - - - - - - Spring- - - - - - - - - - ");
		courses.stream().filter(c -> c.contains("Spring")).forEach(System.out::println);

		System.out.println("- - - - - - - -Word at least 4 chars - - - - - - - - - - ");
		courses.stream().filter(c -> c.length() > 3).forEach(System.out::println);

		System.out.println("- - - - - - - -Print cubes of odd numbers- - - - - - - - - - ");
		numbers.stream().filter(n -> n % 2 == 0).map(c -> c * c * c).forEach(System.out::println);

		System.out.println("- - - - - - - -Print the number of chars in each course - - - - - - - - - - ");
		courses.stream().map(c -> c + " " + c.length()).forEach(System.out::println);

	}

}
