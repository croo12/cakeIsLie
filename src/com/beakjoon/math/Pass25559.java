package com.beakjoon.math;

import java.util.Scanner;

public class Pass25559 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
        if(N == 1)
            System.out.println(1);
		else if(N%2 == 1) {
			System.out.println(-1);
		}else {
			StringBuilder sb = new StringBuilder();
			for (int i = N; i > 0; i--) {
				if(i%2 == 0)
					sb.append(i).append(' ');
				else {
					sb.append(N-i).append(' ');
				}
			}
			System.out.println(sb);
		}
		sc.close();
	}
	
}