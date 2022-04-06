package com.programming;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

record Course(String name, String category, int reviewScore, int noOfStudents) {
};

public class FP04CustomClass {
	public static void main(String[] args) {
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

		// allMatch, noneMatch, anyMatch
		Predicate<? super Course> reviewScoreGreaterThan95Predicate = course -> course.reviewScore() > 95;
		Predicate<? super Course> reviewScoreGreaterThan90Predicate = course -> course.reviewScore() > 90;
		Predicate<? super Course> reviewScoreLessThan90Predicate = course -> course.reviewScore() < 90;

		System.out.println(courses.stream().allMatch(reviewScoreGreaterThan95Predicate));
		System.out.println(courses.stream().noneMatch(reviewScoreLessThan90Predicate));
		System.out.println(courses.stream().anyMatch(reviewScoreLessThan90Predicate));
		System.out.println(courses.stream().anyMatch(reviewScoreGreaterThan95Predicate));

		System.out.println("---------------Comparing NoStudents");
		Comparator<Course> comparingByNoOfStudentsIncreasing = Comparator.comparing(Course::noOfStudents);
		System.out.println(
				courses.stream().sorted(comparingByNoOfStudentsIncreasing).collect(Collectors.toList()));
		System.out.println();

		System.out.println("---------------Comparing NoStudents reversed");
		Comparator<Course> comparingByNoOfStudentsDecreasing = Comparator.comparingInt(Course::noOfStudents).reversed(); // comparingInt is more appropiated for primitives for performance
		System.out.println(
				courses.stream().sorted(comparingByNoOfStudentsDecreasing).collect(Collectors.toList()));
		System.out.println();

		System.out.println("---------------Comparing NoStudents and Reviews reversed");
		Comparator<Course> comparingByNoOfStudentsAndNumberOfReviews = Comparator.comparingInt(Course::noOfStudents)
				.thenComparing(Course::reviewScore).reversed();
		System.out.println(
				courses.stream().sorted(comparingByNoOfStudentsAndNumberOfReviews).collect(Collectors.toList()));
		System.out.println();

		// Playing with skip, limit, takeWhile and dropWhile
		System.out.println("---------------Comparing NoStudents and Reviews reversed with limit");
		Comparator<Course> comparingByNoOfStudentsAndNumberOfReviewsAndLimit = Comparator
				.comparingInt(Course::noOfStudents)
				.thenComparing(Course::reviewScore).reversed();
		System.out.println(
				courses.stream().sorted(comparingByNoOfStudentsAndNumberOfReviewsAndLimit)
						.limit(5).collect(Collectors.toList()));
		System.out.println();

		System.out.println("---------------Comparing NoStudents and Reviews reversed with skip");
		Comparator<Course> comparingByNoOfStudentsAndNumberOfReviewsAndSkip = Comparator
				.comparingInt(Course::noOfStudents)
				.thenComparing(Course::reviewScore).reversed();
		System.out.println(
				courses.stream().sorted(comparingByNoOfStudentsAndNumberOfReviewsAndSkip)
						.skip(3).collect(Collectors.toList()));
		System.out.println();

		System.out.println("---------------Comparing NoStudents and Reviews reversed with skip and limit");
		Comparator<Course> comparingByNoOfStudentsAndNumberOfReviewsAndSkipAndLimit = Comparator
				.comparingInt(Course::noOfStudents)
				.thenComparing(Course::reviewScore).reversed();
		System.out.println(
				courses.stream().sorted(comparingByNoOfStudentsAndNumberOfReviewsAndSkipAndLimit)
						.skip(3).limit(5).collect(Collectors.toList()));
		System.out.println();

		System.out.println("---------------Comparing NoStudents and Reviews reversed with takewhile");
		Comparator<Course> comparingByNoOfStudentsAndNumberOfReviewsAndTakeWhile = Comparator
				.comparingInt(Course::noOfStudents)
				.thenComparing(Course::reviewScore).reversed();
		System.out.println(
				courses.stream().sorted(comparingByNoOfStudentsAndNumberOfReviewsAndTakeWhile)
						.takeWhile(course -> course.reviewScore() >= 95)
						.collect(Collectors.toList()));
		System.out.println();

		Comparator<Course> comparingByNoOfStudentsAndNumberOfReviewsAndDropWhile = Comparator
				.comparingInt(Course::noOfStudents)
				.thenComparing(Course::reviewScore).reversed();
		System.out.println(
				courses.stream().sorted(comparingByNoOfStudentsAndNumberOfReviewsAndDropWhile)
						.dropWhile(course -> course.reviewScore() >= 95)
						.collect(Collectors.toList()));
		System.out.println();

		// finding top, min, max, findFirst, findAny
		System.out.println("---------------Max");
		// the last element of the list, using the cirteria
		System.out.println(courses.stream().max(comparingByNoOfStudentsAndNumberOfReviews));
		System.out.println();

		System.out.println("---------------Min");
		// the first element of the list, using the cirteria
		System.out.println(courses.stream().min(comparingByNoOfStudentsAndNumberOfReviews));
		System.out.println();

		System.out.println("---------------En caso de no encontrar, poner uno por default");
		System.out.println(
				courses.stream().filter(reviewScoreLessThan90Predicate).min(comparingByNoOfStudentsAndNumberOfReviews)
						.orElse(new Course("Kubernetes", "Cloud", 91, 20000)));
		System.out.println();

		System.out.println("---------------FindFirst or default");
		System.out.println(
				courses.stream().filter(reviewScoreGreaterThan95Predicate).findFirst()
						.orElse(new Course("Kubernetes", "Cloud", 91, 20000)));
		System.out.println();

		System.out.println("---------------FindAny or default");
		System.out.println(
				courses.stream().filter(reviewScoreGreaterThan95Predicate).findAny()
						.orElse(new Course("Kubernetes", "Cloud", 91, 20000)));
		System.out.println();

		//
		//
		// sum, average and count
		//
		//
		System.out.println("---------------Sum");
		System.out.println(
				courses.stream()
						.filter(reviewScoreGreaterThan95Predicate)
						.mapToInt(Course::noOfStudents)
						.sum());
		System.out.println();

		System.out.println("---------------Average");
		System.out.println(
				courses.stream()
						.filter(reviewScoreGreaterThan95Predicate)
						.mapToInt(Course::noOfStudents)
						.average());
		System.out.println();

		System.out.println("---------------Count");
		System.out.println(
				courses.stream()
						.filter(reviewScoreGreaterThan95Predicate)
						.mapToInt(Course::noOfStudents)
						.count());
		System.out.println();

		System.out.println("---------------The course with the MAX No of students");
		System.out.println(
				courses.stream()
						.filter(reviewScoreGreaterThan95Predicate)
						.mapToInt(Course::noOfStudents)
						.max());
		System.out.println();

		//
		//
		// groupBy
		//
		//
		System.out.println("---------------groupBy");
		System.out.println(
				courses.stream()
						.collect(Collectors.groupingBy(Course::category)));
		System.out.println();

		System.out.println("---------------groupBy category and counting");
		System.out.println(
				courses.stream()
						.collect(Collectors.groupingBy(Course::category, Collectors.counting())));
		System.out.println();

		System.out.println("---------------groupBy category and show the highest reviews");
		System.out.println(
				courses.stream()
						.collect(Collectors.groupingBy(Course::category,
								Collectors.maxBy(Comparator.comparing(Course::reviewScore)))));
		System.out.println();

		System.out.println("---------------groupBy category and show only the name");
		System.out.println(
				courses.stream()
						.collect(Collectors.groupingBy(Course::category,
								Collectors.mapping(Course::name, Collectors.toList()))));
		System.out.println();
	}
}