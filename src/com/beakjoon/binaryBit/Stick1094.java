package com.beakjoon.binaryBit;

import java.util.Scanner;

public class Stick1094 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int stick = 64;
		int X = sc.nextInt();
		
		if(stick == X) {
			System.out.println(1);
		}else {
			int cnt = 0;
			for (int i = 0; i < 6; i++) {
				if((X & (1 << i)) != 0)
					cnt++;
			}
			System.out.println(cnt);
		}
		
		sc.close();
	}
}
