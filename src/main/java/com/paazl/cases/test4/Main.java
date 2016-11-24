package com.paazl.cases.test4;

public class Main {
	/*
	 * Write a main method that spawns ten threads. These threads should be
	 * assigned a unique sequence number. Running a thread will make it print
	 * its own sequence number ten times, sleeping 100ms between each print.
	 */
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			new Thread(String.valueOf(i)) {
				@Override
				public void run() {
					System.out.println(Thread.currentThread().getName() + " started.");

					threadOperation();

					System.out.println(Thread.currentThread().getName() + " finished.");
				}
			}.start();
		}
	}

	private static void threadOperation() {
		for (int j = 0; j < 10; j++) {
			System.out.println(Thread.currentThread().getName());
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}