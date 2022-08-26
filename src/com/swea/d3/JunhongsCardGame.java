package com.swea.d3;

import java.util.Scanner;

public class JunhongsCardGame {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			int start;
			int end;
			if(x > y) {
				start = y+1;
				end = x+1;
			}else {
				start = x+1;
				end = y+1;
			}
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append(" ");
			for (int i = start; i <= end; i++) {
				sb.append(i).append(" ");
			}
			System.out.println(sb);
		}
		sc.close();
	}
}
