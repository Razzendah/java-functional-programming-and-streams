package com.programming;

public class FP05Playing {
	
	public static void main(String[] args) {
		System.out.println(Stream.of(12,9,13,4,6,2,4,12,15).count()); // stream -> ReferencePipeline
		System.out.println(Stream.of(12,9,13,4,6,2,4,12,15).reduce(0, Integer::sum)); // stream -> ReferencePipeline
		
		
		Arrays.stream(new int[9] {12,9,13,4,6,2,4,12,15}); // IntPipeline
		Arrays.stream(new int[9] {12,9,13,4,6,2,4,12,15}).sum(); // IntPipeline
		Arrays.stream(new int[9] {12,9,13,4,6,2,4,12,15}).average(); // IntPipeline
		Arrays.stream(new int[9] {12,9,13,4,6,2,4,12,15}).min(); // IntPipeline
		Arrays.stream(new int[9] {12,9,13,4,6,2,4,12,15}).max(); // IntPipeline

		// Primitive streams
		IntStream.range(1, 10);
		IntStream.range(1, 10).sum();
		IntStream.rangeClosed(1, 10).sum();
		IntStream.iterate(1, e-> e + 2).limit(10).sum();
		IntStream.iterate(1, e-> e + 2).limit(10).peek(System.out::println).sum();
		IntStream.iterate(2, e-> e + 2).limit(10).peek(System.out::println).sum();
		IntStream.iterate(2, e-> e * 2).limit(10).peek(System.out::println).sum();
		
		IntStream.iterate(2, e-> e * 2).limit(10).collect(Collectors.toList()); // error // we cannot apply collectors on a primitive
		IntStream.iterate(2, e-> e * 2).limit(10).boxed().collect(Collectors.toList()); // we have to boxed

		IntStream.rangeClosed(1,50).reduce(1, (x,y) -> x* y); // gives 0, because exeeds the limit of int max value
		LongStream.rangeClosed(1,20).reduce(1, (x,y) -> x* y); 
		LongStream.rangeClosed(1,50).reduce(1, (x,y) -> x* y); // exceeds long  max value, gives negative number
		LongStream.rangeClosed(1,50).maptTpObj(BigInteger::valueOf).reduce(BigInteger.ONE, BigInteger.multiply); // gives a correct factorial of 50 first numbers

		
	}
}