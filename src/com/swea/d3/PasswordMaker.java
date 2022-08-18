package com.swea.d3;

import java.util.Scanner;

public class PasswordMaker {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			int t = 0;
			
			try{t = sc.nextInt();}
			catch(Exception e) {sc.close();return;}
			
			int arr[] = new int[8];
			for (int i = 0; i < 8; i++) {
				arr[i] = sc.nextInt();
			}
			
			int cnt = 0;
			int minus = 0;
			while(true) {
				arr[cnt%8] -= minus++%5 +1;
				if(arr[cnt%8] <= 0) {
					arr[cnt%8] = 0;
					
					System.out.printf("#%d ",t);
					for (int i = 0; i < 8; i++) {
						System.out.printf("%d ",arr[++cnt%8]);
					}
					
					break;
				}
				cnt++;
			}
			
			System.out.println();
		}
	}
}
