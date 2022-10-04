package com.swea.d3;

import java.util.Scanner;

public class Hours24 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			System.out.print("#"+test_case+" ");
			int A = sc.nextInt();
			int B = sc.nextInt();
			
			System.out.println((A+B)%24);
		}
		sc.close();
	}
}
