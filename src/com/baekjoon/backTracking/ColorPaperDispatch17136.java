package com.baekjoon.backTracking;

import java.util.Scanner;

public class ColorPaperDispatch17136 {
	
	static int[] stock = {5,5,5,5,5};
	static int[][] paper;
	static int cnt;
	static int ans;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		paper = new int[10][10];
		cnt = 0;
		ans = 26;
		
		int in;
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				in = sc.nextInt();
				if(in == 1) {
					paper[i][j] = in;
					cnt++;
				}
			}
		}
		
		search(0,0,0);
		
		System.out.println(ans != 26 ? ans : -1);
		sc.close();
	}

	private static void search(int r, int c, int min) {
		
		if(ans <= min)
			return;
		
		if(cnt == 0) {
			ans = min;
			return;
		}
		
		if(paper[r][c] != 1)
			if(c != 9)
				search(r,c+1,min);
			else
				search(r+1,0,min);
		
		//1이라면
		for (int i = 0; 
						i < 5 && r != 10-i && c != 10-i && check(r,c,i); 
																		i++) {
			if(stock[i] != 0) {
				stock[i]--;
				change(r,c,i,true);
				cnt -= (i+1)*(i+1);
				
				if(c != 9)
					search(r,c+1,min+1);
				else
					search(r+1,0,min+1);
				
				stock[i]++;
				change(r,c,i,false);
				cnt += (i+1)*(i+1);
			}
		}
	}
	
	private static boolean check(int r, int c, int k) {

		for (int i = r; i <= r+k; i++) {
			for (int j = c; j <= c+k; j++) {
				if(paper[i][j] != 1)
					return false;
			}
		}
		return true;
	}
	
	private static void change(int r, int c, int k, boolean flag) {
	
		for (int i = r; i <= r+k; i++) {
			for (int j = c; j <= c+k; j++) {
				paper[i][j] = flag ? 2 : 1;
			}
		}
	}
}
