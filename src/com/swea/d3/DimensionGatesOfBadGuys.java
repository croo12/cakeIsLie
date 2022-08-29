package com.swea.d3;

import java.util.Scanner;

public class DimensionGatesOfBadGuys {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int citys = sc.nextInt();
			int range = sc.nextInt();
			int[] status = new int[citys+2];
			status[0] = 1;
			status[citys+1] = 1;
			for (int i = 1; i < citys+1; i++) {
				status[i] = sc.nextInt();
			}
			
			int cnt = 0;
			int i;
			for (i = 0; i < citys+2;) {
				boolean flag = false;
				if(status[i] == 1)
					for (int j = 1; j <= range; j++) {
						if(i+j < citys+2 && status[i+j] == 1) {
							i = i+j;
							flag = true;
						}
					}
				if(i == citys+1) break;
				else if(!flag){
					cnt++;
					i = i+range;
					status[i] = 1;
				}
			}
			System.out.printf("#%d %d\n",tc,cnt);
		}
		sc.close();
	}
}
