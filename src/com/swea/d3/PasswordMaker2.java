package com.swea.d3;

import java.util.Scanner;

public class PasswordMaker2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int tc = 0; tc < 10; tc++) {
			int t = sc.nextInt();
			
			int arr[] = new int[8];
			int min = Integer.MAX_VALUE;
			for (int i = 0; i < 8; i++) {
				arr[i] = sc.nextInt();
				min = Math.min(arr[i], min);
			}
			
			int res = 0;
			if(min%15==0) {
				res = min/15 -1;
			}else {
				res = min/15;
			}		
			  
			for (int i = 0; i < 8; i++) {
				arr[i] -= res*15;
			}
			
			int idx = 0;
			int minus = 0;
			while(true) {
				arr[idx%8] -= minus++%5 + 1;
				if(arr[idx%8] <= 0) {
					arr[idx%8] = 0;
					System.out.printf("#%d ",t);
					for (int i = 0; i < 8; i++) {
						System.out.printf("%d ",arr[++idx%8]);
					}
					break;
				}
				idx++;
			}
			System.out.println();
		}
		sc.close();
	}
}
