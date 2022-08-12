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
		box = new int[height][width];
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				box[i][j] = readInt();
			}
		}

//		for(int[] a : box) {
//			for(int i : a) System.out.print(i+" ");
//			System.out.println();
//		}
		
//========================입력부====================================
		
		
		
		int day = 0;
		
		
		while(freshT>0) {
			todayRotted = new boolean[height][width];
			day++;
			//썩은 사과를 찾는다
			//썩은 사과의 상하좌우를 찾는다.
			int rotten = search();
			freshT -= rotten;
			if(freshT == 0) {
				break;
			}
			if(rotten == 0) {
				day = -1;
				break;
			}
			
			
//			System.out.printf("남은 새 도마도 %d개\n",freshT);
			
			//몇개가 썩었는지 센다.
			
		}
		System.out.println(day);
	}
	
	private static int search() {
		
		int todayCnt = 0;
		
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				
//				System.out.printf(
//						"안녕하세요 도마도(%d,%d) %b, 상자의 도마도 = %d\n",j,i,todayRotted[i][j], box[i][j]);
				
				if(todayRotted[i][j]) continue;
				
				if(box[i][j] == 1) {
					for (int k = 0; k < 4; k++) {
						int nextX = j+dx[k];
						int nextY = i+dy[k];
						
						if(nextX < 0 || nextX >= width || nextY < 0 || nextY >= height) continue;
						else if((!todayRotted[nextY][nextX]) && box[nextY][nextX] == 0){
							todayRotted[nextY][nextX] = true;
							box[nextY][nextX] = 1;
							todayCnt++;
						}
					}
				}
			}
		}
//		System.out.printf("잘 끝났어요 todayCnt , %d\n",todayCnt);
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
