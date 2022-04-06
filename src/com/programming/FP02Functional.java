package com.programming;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FP02Functional {

	public static void main(String[] args) throws Exception {
		List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);

		System.out.println("- - - - - - -Sum the elements of the list - - - - - - - - - - - ");
		numbers.stream().reduce(0, (x, y) -> x + y); // another way to sum
		numbers.stream().reduce(0, Integer::sum); // another way to sum
		System.out.println(numbers.stream().reduce(Integer::sum).get());

		//Courses

		List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker",
				"Kubernetes");

		System.out.println("- - - - - - -Sorted - - - - - - - - - - - ");
		courses.stream().sorted().forEach(System.out::println);

		System.out.println("- - - - - - -Sorted Natural Order - - - - - - - - - - - ");
		courses.stream().sorted(Comparator.naturalOrder()).forEach(System.out::println);

		System.out.println("- - - - - - -Sorted Reverse Order - - - - - - - - - - - ");
		courses.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);

		System.out.println("- - - - - - -Distinct Sorted - - - - - - - - - - - ");
		numbers.stream()
				.distinct()
				.sorted()
				.forEach(System.out::println);

		System.out.println("- - - - - - -Compare the str length - - - - - - - - - - - ");
		courses.stream().sorted(Comparator.comparing(str -> str.length())).forEach(System.out::println);

		System.out.println("- - - - - - -Double the numbers - - - - - - - - - - - ");
		List<Integer> doubledNumbers = numbers.stream().map(n -> n * n).collect(Collectors.toList());
		doubledNumbers.stream().forEach(System.out::println);

		System.out.println("- - - - - - -New List With Even Numbers - - - - - - - - - - - ");
		List<Integer> evenNumbers = numbers.stream().filter(n -> n % 2 == 0).toList();
		evenNumbers.stream().forEach(System.out::println);

		System.out.println("- - - - - - -List with legths of all course titles - - - - - - - - - - - ");
		List<String> courseLengths = courses.stream().map(c -> c + " " + c.length()).toList();
		courseLengths.stream().forEach(System.out::println);
	}

}
