package com.swea.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NeoLadder {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[][] ladder;
	static int y;
	
	public static void main(String[] args) throws IOException{
		
		for (int tc = 1; tc <= 10; tc++) {
			br.readLine();
			StringTokenizer st;
			ladder = new int[100][100];
			y= 99;
			
			for (int j = 0; j < 100; j++) {
				st = new StringTokenizer(br.readLine());
				for (int i = 0; i < 100; i++) {
					ladder[i][j] = Integer.parseInt(st.nextToken());
				}
			}

//			for (int j = 0; j < 100; j++) {
//				for (int i = 0; i < 100; i++) {
//					System.out.print(ladder[i][j]+" ");
//				}
//				System.out.println();
//			}
			
//======================== 입력부 =========================================			
			
			int result = -1;
			
			for (int i = 0; i < 100; i++) {
				if(ladder[i][99] == 2) {
					result = go(i, 0);
				}	
			}
			System.out.printf("#%d %d\n",tc, result);
		}
	}
	
	private static int go(int x, int dir) { // 0 == up, 1 == right, -1 == left
		if(y == 0) return x;
		if(dir == 0) {
			y--;
			if(x < 99) {
				if(ladder[x+1][y] == 1) {
					return go(x+1,1);
				}
			}
			if(x > 0) {
				if(ladder[x-1][y] == 1) {
					return go(x-1,-1);
				}
			}
		}
		else if(dir == 1) {
			if(x < 99) {
				if(ladder[x+1][y] == 1) {
					return go(x+1,1);
				}
			}
		}
		else if(dir == -1) {
			if(x > 0) {
				if(ladder[x-1][y] == 1) {
					return go(x-1,-1);
				}
			}
		}
		
		return go(x,0);
		
	}
}
