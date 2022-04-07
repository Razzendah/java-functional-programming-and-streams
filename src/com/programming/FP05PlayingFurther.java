package com.programming;

public class FP05Playing {
	
	public static void main(String[] args) {
		List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker",
				"kubernetes");
		
		System.out.println(courses.stream().collect(Collectors.joining(" ")));
		courses.stream().map(course -> course.split("")).collect(Collectors.toList()); // returns a stream of string arrays Stream[{"a", "b"}, {"c", "d"}, {"e", "f", "a"}]
		courses.stream().map(course -> course.split("")).flatMap(Arrays::stream).collect(Collectors.toList()); // Stream["a", "b", "c", "d", "e", "f", "a"]
		courses.stream().map(course -> course.split("")).flatMap(Arrays::stream).distinct().collect(Collectors.toList()); // Stream["a", "b", "c", "d", "e", "f"]
		
		// Tuples with the same length
		List<String> courses2 = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker",
				"kubernetes");
		
		courses.stream().flatMap(course -> courses2.stream().map(course2 -> List.of(courses, courses2))).collect(Collectors.toList())
		// elimimate same elements repeated twice
		courses.stream().flatMap(course -> courses2.stream().map(course2 -> List.of(courses, courses2))).filter(list -> !list.get(0).equals(list.get(1))).collect(Collectors.toList())
		// Filter Tuples with the same length
		courses.stream().flatMap(course -> courses2.stream().filter(course2 -> course2.length() == course.length()).map(course2 -> List.of(courses, courses2))).filter(list -> !list.get(0).equals(list.get(1))).collect(Collectors.toList())	
	}
}