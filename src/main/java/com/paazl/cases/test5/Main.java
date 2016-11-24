package com.paazl.cases.test5;

public class Main {
	private static Object monitor = new Object();
	/*
	 * Running test #4 should output a randomly ordered list of sequence
	 * numbers. Your next task is to make your threads wait for each other, so
	 * one (random) thread should print all of its sequence numbers before
	 * another is allowed to print anything. You are not allowed to change the
	 * thread spawning mechanism, i.e. you should still start these threads
	 * "simultaneously" in a single loop.
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
		synchronized (monitor) {
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
}