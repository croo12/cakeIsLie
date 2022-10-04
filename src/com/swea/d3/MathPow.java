package com.swea.d3;

import java.util.Scanner;

public class MathPow { // 클래스 이름을 Solution으로 바꿔야 한다.

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int test_case = 1; test_case <= 10; test_case++) {
			int me = sc.nextInt();
			int time = sc.nextInt();
			
			int ans = power(me,time);
			
			System.out.printf("#%d %d\n",test_case, ans);
		}
		sc.close();
	}
	
	static int power(int me, int time) {
		if(time == 1)
			return me;
		
		int num = power(me,time/2);

		if(time%2 == 0) {
			return num * num;
		}else {
			return num * num * me;
		}
	}
}
