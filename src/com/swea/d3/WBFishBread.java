package com.swea.d3;

import java.util.Arrays;
import java.util.Scanner;

public class WBFishBread {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int k = sc.nextInt();
			int[] times = new int[n]; 
			
			for (int i = 0; i < n; i++) {
				times[i] = sc.nextInt();
			}
			Arrays.sort(times);
			
			int cnt = 0; //방문한 사람 수
			boolean flag = false;
			for (int i = 0; i < n; i++) {
				cnt++;
				if(times[i]/m * k < cnt) {
					flag = true;
					break;
				}
			}
			
			if(flag) System.out.printf("#%d Impossible\n",tc);
			else System.out.printf("#%d Possible\n",tc);
		}
		sc.close();
	}
}
