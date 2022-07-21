package com.beakjoon.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Fibonacci01_1 { // 클래스 이름을 Main으로 바꿔야 한다.
	//시간초과로 실패 버전
	
	static int zero = 0;
	static int one = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine()) ;
		for (int i = 1; i <= T; i++) {
			zero = 0;
			one = 0;
			int n = Integer.parseInt(bf.readLine());
			get_fibonacci(n);
			System.out.print(zero+" ");
			System.out.print(one+" ");
			System.out.println();
			
		}
	}
	
	public static int get_fibonacci(int n) {
	    if (n == 0) {
	        zero++;
	    } else if (n == 1) {
	        one++;
	    } else {
	        return (get_fibonacci(n-1) + get_fibonacci(n-2));
	    }
	    return 0;
	}
}
