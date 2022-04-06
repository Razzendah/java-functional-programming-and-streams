package com.programming;

import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class FP03FunctionalInterfaces {

	public static void main(String[] args) throws Exception {
		List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);

		System.out.println("- - - - - - -Lambda Expressions - - - - - - - - - - - ");
		// stream
		numbers.stream()
				.filter(x -> x % 2 == 0)
				.map(x -> x * x)
				.forEach(System.out::println);

		System.out.println("- - - - - - -Functional Interface - - - - - - - - - - - ");
		// Functional Interface // logic // what the method does // represents a method
		Predicate<Integer> isEvenPredicate = x -> x % 2 == 0; // forma actual
		Function<Integer, Integer> squareFunction = x -> x * x; // forma actual
		Consumer<Integer> sysoutConsumer = System.out::println; // forma actual
		numbers.stream()
				.filter(isEvenPredicate)
				.map(squareFunction)
				.forEach(sysoutConsumer);

		System.out.println("- - - - - - -Anonymous Inner Type - - - - - - - - - - - ");
		Predicate<Integer> isEvenPredicate2 = new Predicate<Integer>() { // forma anterior
			@Override
			public boolean test(Integer x) {
				return x % 2 == 0;
			}
		};

		Function<Integer, Integer> squareFunction2 = new Function<Integer, Integer>() { // forma anterior
			@Override
			public Integer apply(Integer x) {
				return x * x;
			}
		};

		Consumer<Integer> sysoutConsumer2 = new Consumer<Integer>() { // forma anterior
			@Override
			public void accept(Integer x) {
				System.out.println(x);
			}
		};
		numbers.stream()
				.filter(isEvenPredicate2)
				.map(squareFunction2)
				.forEach(sysoutConsumer2);

		System.out.println("- - - - - - -Ejercicio 12 - - - - - - - - - - - ");
		BinaryOperator<Integer> suma1 = (a, b) -> a + b;
		BinaryOperator<Integer> suma2 = new BinaryOperator<Integer>() {
			@Override
			public Integer apply(Integer t, Integer u) {
				return t + u;
			}
		};
		BinaryOperator<Integer> suma3 = Integer::sum;

		int sum1 = numbers.stream().reduce(0, suma1);
		int sum2 = numbers.stream().reduce(0, suma2);
		int sum3 = numbers.stream().reduce(0, suma3);
		int sum4 = numbers.stream().reduce(0, (a, b) -> a + b);

		System.out.println(sum1);
		System.out.println(sum2);
		System.out.println(sum3);
		System.out.println(sum4);
	}

}