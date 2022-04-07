package com.programming;

public class FP06HigherOrderFunctions {
	
	public static void main(String[] args) {
		// Huge operation
		// 0, 1000000000
		long time = System.currentTimeMillis();
		System.out.println(LongStream.range(0, 1000000000).sum());
		System.out.println(System.currentTimeMillis() - time);

		// parallel
		System.out.println(LongStream.range(0, 1000000000).parallel().sum());
		System.out.println(System.currentTimeMillis() - time);
	}
}