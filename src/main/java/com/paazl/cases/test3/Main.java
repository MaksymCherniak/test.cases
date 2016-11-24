package com.paazl.cases.test3;

import com.paazl.cases.test2.DeveloperFactory;
import com.paazl.cases.test3.enums.Answers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Map;

public class Main {
	private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	private static int score = 0;
	/*
	 * Implement a main method that is functionally identical to Test #2. In
	 * this case, use a Singleton that poses the questions and gathers the answers.
	 */
	public static void main(String[] args) {
		executeTest();

		DeveloperFactory.create(score).print();
	}

	private static void executeTest() {
		Iterator<Map.Entry<String, Answers>> iterator = Singleton.getInstance().getQUESTIONS().entrySet().iterator();
		String answer;

		System.out.println("Good day, you'll see the questions right here and you need to answer them using only Y(Yes)/N(No).");
		System.out.println();

		try {
			while (iterator.hasNext()) {
				Map.Entry<String, Answers> entry = iterator.next();

				System.out.println(entry.getKey());
				answer = reader.readLine();

				while (true) {
					if (answer.equalsIgnoreCase(String.valueOf(Answers.N)) || answer.equalsIgnoreCase(String.valueOf(Answers.Y))) {
						break;
					}

					System.out.println("Wrong answer format. Please enter Y(Yes)/N(No).");
					System.out.println(entry.getKey());
					answer = reader.readLine();
				}

				if (answer.equalsIgnoreCase(String.valueOf(entry.getValue()))) {
					score++;
				}
			}
			reader.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}