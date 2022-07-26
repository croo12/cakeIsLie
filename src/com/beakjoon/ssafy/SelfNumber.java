package com.beakjoon.ssafy;

public class SelfNumber {
	public static void main(String[] args) {
		
		int[] n = new int[10036];
		
		for(int i = 1; i < 10000; i++)
			n[selfNumber(i)] = 1;
		for (int i = 1; i < 10000; i++) {
			if(n[i] == 0) System.out.println(i);
		}
	}
	
	public static int selfNumber(int n) {
		int sum = n;
		while(n!=0) {
			sum += n%10;
			n /= 10;
		}
		return sum;
	}
}
