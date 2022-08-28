package com.beakjoon.math;

import java.util.Scanner;

public class CupHolder2810 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		String seats = sc.next();
		seats = seats.replace("LL", "*");
		int holders = seats.length()+1;
		System.out.println( holders > n ? n : holders );
		
		sc.close();
	}
}
