package com.baekjoon.greed;

import java.util.Scanner;

public class LostParenthesis {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		
		int result = 0;
		if(input.contains("-")) {
			result = minus(input);
		}else {
			result = 0;
			if(input.contains("+"))
				result = plus(input);
			else
				result = Integer.parseInt(input);
		}	
		System.out.println(result);
		sc.close();
	}
	
	public static int minus(String s) {
		String[] minus = s.split("-");
		int sum = 0;
		if(minus[0].contains("+")) {
			sum = plus(minus[0])*2;
		}else
			sum = Integer.parseInt(minus[0])*2;
		for (int i = 0; i < minus.length; i++) {
			int n = 0;
			if(minus[i].contains("+"))
				n = plus(minus[i]);
			else
				n = Integer.parseInt(minus[i]);
			sum -= n;
		}
		return sum;
	}
	
	public static int plus(String s) {
		String[] plus = s.split("\\+");
		int sum = 0;
		for(String a : plus) {
			sum+= Integer.parseInt(a);
		}
		return sum;
	}
}
