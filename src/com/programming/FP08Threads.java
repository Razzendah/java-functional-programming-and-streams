package com.programming;

public class FP06HigherOrderFunctions {
	
	public static void main(String[] args) {
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 10000; i ++) {
					System.out.println(Thread.currentThread().getId() + ":" + i);
				}
			}
		};

		Runnable runnable2 = () -> {
			for (int i = 0; i < 10000; i ++) {
				System.out.println(Thread.currentThread().getId() + ":" + i);
			}
		};

		Thread thread1 = new Thread(runnable2);
		thread1.start();
		
		Thread thread2 = new Thread(runnable2);
		thread2.start();

		Thread thread3 = new Thread(runnable2);
		thread3.start();

		// test again removing the loop
		Runnable runnable3 = () -> IntStream.range(0, 10000).forEach(i -> System.out.println(Thread.currentThread().getId() + ":" + i));
	}
}