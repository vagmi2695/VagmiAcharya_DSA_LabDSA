package com.greatlearning.stack;

import java.util.Scanner;
import java.util.Stack;

public class StackBracket {
	private static boolean checkBracket(String input) {
		Stack<Character> stack = new Stack<>();
		char k;
		for (int i = 0; i < input.length(); i++) {
			k = input.charAt(i);
			if (k == '[' || k == '{' || k == '(') {
				stack.push(k);
				continue;
			}
			if (stack.isEmpty())
				return false;

			char checkChar;
			switch (k) {
			case ']':
				checkChar = stack.pop();
				if (checkChar == '(' || checkChar == '{')
					return false;
				break;
			case '}':
				checkChar = stack.pop();
				if (checkChar == '(' || checkChar == '[')
					return false;
				break;
			case ')':
				checkChar = stack.pop();
				if (checkChar == '[' || checkChar == '{')
					return false;
				break;
			}

		}
		return (stack.isEmpty());
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter parenthesis sequence");
		String input = sc.next();
		boolean result = checkBracket(input);
		if (result)
			System.out.println("Valid Input");
		else
			System.out.println("Invalid Input");
	}

}
