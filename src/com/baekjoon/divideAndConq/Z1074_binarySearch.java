package com.baekjoon.divideAndConq;

import java.util.Scanner;

public class Z1074_binarySearch {
	static int r;
	static int c;
	public static void main(String[] args) {
		//틀린이유
		//분할정복하니까 시간초과남
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		r = sc.nextInt()+1;
		c = sc.nextInt()+1;
		
		
		//이분탐색으로 풀어야할듯
		//row 검사하면 수 절반
		//col검사하면 수 절반씩 줄일 수 있을 듯?
		
		int stR = 1;
		int edR = (int)Math.pow(2, N);
		
		int stC = 1;
		int edC = edR;
		
		int midR = (stR + edR)/2;
		int midC = midR;
		
		int stA = 1;
		int edA = edR * edR;
		
		while(stA != edA) {
			if(r <= midR) {
				edR = midR;
				edA = (stA+edA)/2;
			}else {
				stR = midR + 1;
				stA = (stA+edA)/2 + 1;
			}
			
			midR = (stR + edR)/2;
			
			if(c <= midC) {
				edC = midC;
				edA = (stA+edA)/2;
			}else {
				stC = midC + 1;
				stA = (stA+edA)/2 + 1;
			}
			
			midC = (stC + edC)/2;
		}
		
		System.out.println(stA-1);
		sc.close();
	}
}
