package com.beakjoon.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Tomato_fail {
	
	public static int end = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int[][] box = new int[x][y];
		
		for (int j = 0; j < y; j++) {
			StringTokenizer tb = new StringTokenizer(br.readLine());
			for (int i = 0; i < x; i++) {
				box[i][j] = Integer.parseInt(tb.nextToken()); //1은 익은 토마토 , 2는 안익은 토마토 
			}
		}
		int result = 0;
		
		if(!is_all_rotten(box)) {
			while(true) {
				result++;
				box = day_infection(box);
				if( box == null) {
					result=-1;
					break;
				}else if(end == 1) {
					break;
				}
			}
		}
		System.out.println(result);
	}
	
	public static int[][] today_rotten_tomato_checker(int[][] box) { //오늘 썩을 토마토는 어디에?
		int[] dx = {1, 0, 0, -1};
		int[] dy = {0, 1, -1, 0};

		int[][] tmp_box = new int[box.length][box[0].length];
		
		for (int i = 0; i < box.length; i++) {
			for (int j = 0; j < box[0].length; j++) {
				if(box[i][j] == 1)
					for (int m = 0; m < 4; m++) {
						int next_x = i+dx[m];
						int next_y = j+dy[m];
						if(next_x <0 || next_x >= box.length || next_y <0 || next_y >= box[0].length) {
							
						}else{
							tmp_box[next_x][next_y] = 1;
						}
					}
			}
		}
		return tmp_box;
	}
	
	public static int[][] day_infection(int[][] box){
		
		int[][] tmp_box = today_rotten_tomato_checker(box);
		
		int cnt =0; ////오늘 썩은 토마토의 갯수 계산용
		for (int i = 0; i < box.length; i++) { // 오늘 썩을 토마토 상자를 실제 토마토 상자에 반영함
			for (int j = 0; j < box[0].length; j++) {
				if(tmp_box[i][j] == 1 && box[i][j] == 0) {
					box[i][j] = 1;
					cnt++;
				}
			}
		}
		
		if(is_all_rotten(box)) {
			end = 1;
			return box;
		}
		
		if(cnt == 0) return null; //더이상 썩지 않음
		else return box;
	}
	
	public static boolean is_all_rotten(int[][] box) {
		for (int i = 0; i < box.length; i++) {
			for (int j = 0; j < box[0].length; j++) {
				if(box[i][j] == 0) return false;
			}
		}
		return true;
	}
}
