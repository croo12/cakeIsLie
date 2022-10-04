package com.swea.d3;

import java.util.Scanner;

public class JunHyungsPracticeManagement {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			System.out.print("#"+test_case+" ");
			
			int A = sc.nextInt();
			int B = sc.nextInt();
			int X = sc.nextInt();
			
			if(X > B) {
				System.out.println(-1);
			}else if(X < A){
				System.out.println( A - X);
			}else {
				System.out.println(0);
			}
		}
		sc.close();
	}
}
