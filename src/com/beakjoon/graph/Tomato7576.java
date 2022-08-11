package com.beakjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Tomato7576 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int freshT = 0;
	
	static boolean[][] todayRotted;
	static int[][] box;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	
	static int width;
	static int height;
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		width = Integer.parseInt(st.nextToken());
		height = Integer.parseInt(st.nextToken());
		box = new int[width][height];
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				box[i][j] = readInt();
			}
		}

//		for(int[] a : box) {
//			for(int i : a) System.out.print(i+" ");
//			System.out.println();
//		}
		
//========================입력부====================================
		
		int day = 0;
		while(true) {
			todayRotted = new boolean[width][height];
			day++;
			//썩은 사과를 찾는다
			//썩은 사과의 상하좌우를 찾는다.
			int rotten = search();
			if(rotten == 0) {
				day = -1;
				break;
			}
			freshT -= rotten;
			if(freshT < 0) {
				break;
			}
			
			
			//몇개가 썩었는지 센다.
			
		}
		System.out.println(day);
	}
	
	private static int search() {
		
		int todayCnt = 0;
		
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				
				System.out.println(todayRotted[i][j]);
				
				if(todayRotted[i][j]) continue;
				
				if(box[i][j] == 1) {
					for (int k = 0; k < 4; k++) {
						int nextX = i+dx[k];
						int nextY = j+dy[k];
						
						if(nextX < 0 || nextX >= width || nextY < 0 || nextY >= height) {}
						else if((!todayRotted[nextX][nextY]) && box[nextX][nextY] == 0){
							todayRotted[nextX][nextY] = true;
							box[nextX][nextY] = 1;
							todayCnt++;
						}
					}
				}
			}
		}
		
		return todayCnt;
	}
	
	private static int readInt() throws IOException {
		while(true) {
			int now = br.read();
			if(now == '-') {
				br.read();
				return -1;
			}else if(now == '0') {
				freshT++;
				return 0;
			}else if(now == '1')
				return 1;
		}
	}
}
