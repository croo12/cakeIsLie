package com.swea.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ladder {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[][] ladder;
	
	public static void main(String[] args) throws IOException{
		
		for (int tc = 1; tc <= 10; tc++) {
			br.readLine();
			StringTokenizer st;
			ladder = new int[100][100];
			
			for (int j = 0; j < 100; j++) {
				st = new StringTokenizer(br.readLine());
				for (int i = 0; i < 100; i++) {
					ladder[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int j = 0; j < 100; j++) {
				for (int i = 0; i < 100; i++) {
					System.out.print(ladder[i][j]+" ");
				}
				System.out.println();
			}
			
			int result = -1;
			
			for (int i = 0; i < 100; i++) {
				if(ladder[i][0] == 1) {
					System.out.println(i+"번 입구로 진입합니다");
					if(goDown(i, 0)) {
						result = i;
						break;
					}
				}	
			}
			System.out.printf("#%d %d\n",tc, result);
		}
	}
	
	private static boolean goDown(int x, int y) {
//		System.out.println("현재 좌표 ("+x+","+y+")");
		
		int[] dx = {1,-1};
		
		for (int i = 0; i < 2; i++) {
			int side = x+dx[i];
			if(side >= 0 && side < 100)
				if(ladder[side][y] == 1) {
					return i == 0 ? goRight(side, y) : goLeft(side, y);
				}
		}
		
		if(y != 99) return goDown(x,y+1);
		else if(x == 99) return true;
		else return false;
	}
	
	private static boolean goRight(int x, int y) {
		
		if(x+1 >= 0 && x+1 < 100) {
			if(ladder[x+1][y]==1)
				return goRight(x+1,y);
		}
		if(y != 99) return goDown(x,y+1);
		else if(x == 99) return true;
		else return false;
	}
	
	private static boolean goLeft(int x, int y) {
		
		if(x-1 >= 0 && x-1 < 100) {
			if(ladder[x-1][y]==1)
				return goLeft(x-1,y);
		}
		if(y != 99) return goDown(x,y+1);
		else if(x == 99) return true;
		else return false;
		
	}
}
