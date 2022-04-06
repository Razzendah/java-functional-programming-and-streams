package com.programming;

import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.DoubleBinaryOperator;
import java.util.function.IntBinaryOperator;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.IntPredicate;
import java.util.function.IntSupplier;
import java.util.function.IntToDoubleFunction;
import java.util.function.IntToLongFunction;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class FP03FunctionalInterfaces2 {

	public static void main(String[] args) throws Exception {
		List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);

		// supplier 
		// No input > return something
		System.out.println("- - - - - - -Simple Supplier - - - - - - - - - - - ");
		Supplier<Integer> simpleSupplier = () -> 2;
		System.out.println(simpleSupplier.get());

		System.out.println("- - - - - - -Random Integer Supplier - - - - - - - - - - - ");
		Supplier<Integer> randomIntegerSupplier = () -> {
			int a = new Random().nextInt(1000);
			return a;
		};
		System.out.println(randomIntegerSupplier.get());

		// The UnaryOperator takes one argument, and returns a result of the same type of its arguments.
		System.out.println("- - - - - - -UnaryOperator - - - - - - - - - - - ");
		UnaryOperator<Integer> unaryOperator = x -> 3 * x;
		System.out.println(unaryOperator.apply(5));

		System.out.println("- - - - - - -BiPredicate - - - - - - - - - - - ");
		BiPredicate<Integer, String> biPredicate = (number, str) -> number < 10 && str.length() > 5;
		System.out.println(biPredicate.test(5, "ejemplo"));

		System.out.println("- - - - - - -BiFunction - - - - - - - - - - - ");
		// en las expresiones lambda los tipos de datos son inferidos, pero también podemos ponerlos
		BiFunction<Integer, String, String> biFunction = (Integer number, String str) -> number + " " + str;
		System.out.println(biFunction.apply(15, "ejemplo"));

		System.out.println("- - - - - - -BiConsumer - - - - - - - - - - - ");
		BiConsumer<Integer, String> biConsumer = (s1, s2) -> {
			System.out.println(s1);
			System.out.println(s2);
		};
		biConsumer.accept(15, "ejemplo");

		// Las siguientes funciones son usadas con primitivos, para evitar el uso de wrappers y así no
		// opacar el rendimiento de la aplicación con autoboxing

		// IntBinaryOperator
		DoubleBinaryOperator doubleBinaryOperator;
		IntBinaryOperator intBinaryOperator;

		// IntConsumer
		IntConsumer intConsumer;

		// IntFunction
		IntFunction intFunction;

		// IntPredicate
		IntPredicate intPredicate;

		// IntSupplier
		IntSupplier intSupplier;

		// IntToDoubleFunction
		IntToDoubleFunction intToDoubleFunction = i -> i;
		System.out.println(intToDoubleFunction.applyAsDouble(15));

		// IntToLongFuncion
		IntToLongFunction intToLongFunction;

	}

}