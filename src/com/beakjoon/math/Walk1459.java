package com.beakjoon.math;

import java.util.Scanner;

public class Walk1459 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		int bar = sc.nextInt();
		int ma = sc.nextInt();
		if(ma < bar)
			System.out.println((long)ma*Math.min(x, y) + 
									(Math.abs(x - y)%2 == 0 
										? (long) ma * Math.abs(x - y) : ((long) ma * (Math.abs(x - y) != 0 ? (Math.abs(x - y) - 1) : 0) + bar)
									)
							  );
		else if(ma < bar*2)
			System.out.println((long)ma*Math.min(x, y) + (long)bar*Math.abs(x - y));
		else
			System.out.println((long)bar*x + (long)bar*y);
		sc.close();
	}
}
