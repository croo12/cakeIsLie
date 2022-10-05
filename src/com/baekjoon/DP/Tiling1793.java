package com.baekjoon.DP;

import java.math.BigInteger;
import java.util.Scanner;

public class Tiling1793 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		BigInteger[] f = new BigInteger[251];
		f[0] = BigInteger.ONE;
		f[1] = BigInteger.ONE;
		
		//수업시간에 배운바 2n타일은 피보나치 수열이다. 그런데 f(0)이 1인
		//그런데 이 문제에는 가로타일과 네모타일이 있다(둘을 사실 동일한 역할을 하지만 다른 취급임)
		//숫자가 너무 큼 -> BigInteger라는게 있대서 써보기로 함
		
		for (int i = 2; i <= 250; i++) {
			f[i] = f[i-1].add(f[i-2].shiftLeft(1));
		}
		
		while(true) {
			int N;
			
			try {
				N = sc.nextInt();
			}catch (Exception e) {
				break;
			}
			
			sb.append(f[N]).append('\n');
		}
		
		System.out.print(sb);

		sc.close();
	}
}
