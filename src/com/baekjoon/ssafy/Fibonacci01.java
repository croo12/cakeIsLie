package com.baekjoon.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Fibonacci01 { // 클래스 이름을 Main으로 바꿔야 한다.
	//성공버전
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine()) ;
		for (int i = 1; i <= T; i++) {
			int n = Integer.parseInt(bf.readLine());
			int[] zone = get_fibonacci(n);
			System.out.print(zone[0]+" ");
			System.out.print(zone[1]+" ");
			System.out.println();
			
		}
	}
	
	public static int[] get_fibonacci(int n) {
	    int[] result = new int[2];
		if (n == 0) {
			result[0]=1;
			result[1]=0;
	        return result;
	    } else if (n < 2) {
	    	result[0]=0;
			result[1]=1;
	        return result;
	    } else {
	    	int fib[] = new int[n+1];
	    	fib[0] = 0;
	    	fib[1] = 1;
	    	for(int i=2; i<= n; i++) {
	    		fib[i] = fib[i-1]+fib[i-2];
	    	}
	    	result[0]=fib[n-1];
			result[1]=fib[n];
	    	return result;
	    }
	}
}
