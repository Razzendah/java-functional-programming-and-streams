package com.programming;

import java.util.List;

public class FP02Structured {

	public static void main(String[] args) throws Exception {
		List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);

		addListStructured(numbers);
	}

	private static void addListStructured(List<Integer> numbers) {
		// how to loop?
		// how to store the sum
		int sum = 0;
		for (int number : numbers) {
			sum += number;
		}

		System.out.println(sum);
	}

}
