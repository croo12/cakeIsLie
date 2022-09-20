package com.baekjoon.greed;

import java.util.Scanner;

public class SugarDelivery {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int result = checker(n);
		
		System.out.println(result);
		
		sc.close();
	}
	
	public static int checker(int n) {
		int result = 0;
		if(n%5 == 0) {
			result += n/5;
			return result;
		}else{
			for(int i =n/5; i >= 0 ; i-- ) {
				if((n-5*i)%3 == 0) {
					result += i;
					result += (n-5*i)/3;
					return result;
				}
			}
		}
		return -1;
	}
}
