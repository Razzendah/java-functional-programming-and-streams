package com.programming;

public class FP06HigherOrderFunctions {
	
	public static void main(String[] args) {
		// a higher order function is a function that returns a function
		List<Course> courses = List.of(
				new Course("Spring", "Framework", 98, 20000),
				new Course("Spring Boot", "Framework", 95, 18000),
				new Course("API", "Microservices", 97, 22000),
				new Course("Microservices", "Microservices", 96, 25000),
				new Course("Fullstack", "Fullstack", 91, 14000),
				new Course("AWS", "Framework", 92, 21000),
				new Course("Azure", "Cloud", 99, 21000),
				new Course("Docker", "Cloud", 92, 20000),
				new Course("Kubernetes", "Cloud", 91, 20000));

		Predicate<? super Course> reviewScoreGreaterThan95Predicate = createPredicateWithCutoffReivewScore(95);
		Predicate<? super Course> reviewScoreGreaterThan90Predicate = createPredicateWithCutoffReivewScore(90);

		// Intermediate Stream Operations are Lazy
		// only searches until the condition, next elements are ignored
		courses.stream()
			.peak(System.out::println) // va imprimiendo los elementos
			.filter(courses -> courses.length() > 11) // solo regresa los mayores en longitud a 11
			.map(String::toUpperCase) // convierte el texto a mayusculas
			.peek(System.out::println) // imprime los que pararon las condiciones
			.findFirst() // operación terminal // solo toma el primero, como es lazy, ya no opera los demas strings, solo el primero que pase la condición
	}

	private static Predicate<Course> createPredicateWithCutoffReivewScore(int cutoffReviewScore) {
		return course -> course.reviewScore() > cutoffReviewScore;
	}
}