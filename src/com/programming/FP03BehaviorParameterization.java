package com.programming;

import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class FP03BehaviorParameterization {

	public static void main(String[] args) throws Exception {
		List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);

		System.out.println("- - - - - - -Lambda Expressions - - - - - - - - - - - ");
		// pasing the behavior as an argument
		filterAndPrint(numbers, x -> x % 2 == 0);
		filterAndPrint(numbers, x -> x % 2 != 0);
		filterAndPrint(numbers, x -> x % 3 == 0);

		// exercise
		Function<? super Integer, ? extends Integer> squaredFunction = x -> x * x;
		Function<? super Integer, ? extends Integer> cubedFunction = x -> x * x * x;
		Function<? super Integer, ? extends Integer> doubledFuncion = x -> x + x;

		List<Integer> squaredNumbers = mapAndCreateNewList(numbers, squaredFunction);
		List<Integer> cubedNumbers = mapAndCreateNewList(numbers, cubedFunction);
		List<Integer> doubledNumbers = mapAndCreateNewList(numbers, doubledFuncion);

		System.out.println("- - - - - - -Squared Numbers - - - - - - - - - - - ");
		System.out.println(squaredNumbers);
		System.out.println("- - - - - - -Cubed Numbers - - - - - - - - - - - ");
		System.out.println(cubedNumbers);
		System.out.println("- - - - - - -Doubled Numbers - - - - - - - - - - - ");
		System.out.println(doubledNumbers);

	}

	private static List<Integer> mapAndCreateNewList(List<Integer> numbers,
			Function<? super Integer, ? extends Integer> mappingFunction) {
		return numbers.stream().map(mappingFunction).collect(Collectors.toList());
	}

	private static void filterAndPrint(List<Integer> numbers, Predicate<? super Integer> predicate) {
		numbers.stream()
				.filter(predicate)
				.forEach(System.out::println);
	}

}