package com.programming;

import java.util.List;

public class FP01Functional {

	public static void main(String[] args) throws Exception {
		List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);

		//printAllNumbersInListFuntional(numbers);
		// printEvenNumbersInListFuntional(numbers);
		printSquaresOfEvenNumbersInListFunctional(numbers);
	}

	private static void printAllNumbersInListFuntional(List<Integer> numbers) {
		// [12, 9, 13, 4, 6, 2, 4, 12, 15] convert it into a stream of elements

		// What to do
		numbers.stream().forEach(System.out::print); // Syntax for Method Referece
	}

	private static boolean isEven(int number) {
		return number % 2 == 0;
	}

	private static void printEvenNumbersInListFuntional(List<Integer> numbers) {
		// What to do
		numbers.stream()
				.filter(FP01Functional::isEven) // only alow even numbers
				//.filter(n -> n % 2 == 0) // simplified // lambda expresion
				.forEach(System.out::print);
	}

	private static void printSquaresOfEvenNumbersInListFunctional(List<Integer> numbers) {
		numbers.stream()
				.filter(FP01Functional::isEven) // only alow even numbers
				//.filter(n -> n % 2 == 0) // simplified // lambda expresion
				.map(n -> n * n)// take every element and do square
				.forEach(System.out::println);
	}
}
