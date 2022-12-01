package com.baekjoon.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NotBabyShark19236 {
	public static void main(String[] args) {
		try {
			new NotBabyShark19236().solution();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//1~ 16번의 물고기 -> 비트마스킹으로 가능
		//0,0 의 물고기는 바로 사망
		//이동가능한 칸이 없으면 바로 아웃
		
		StringTokenizer st;
		Fish[][] map = new Fish[4][4];
		
		for (int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 4; j++) {
				int num = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken()) - 1;
				
				map[i][j] = new Fish(num, dir);
			}
		}
		
		dfs(0,0, 1 << map[0][0].num);
		
	}
	
	private void dfs(int r, int c, int k) {
		// TODO Auto-generated method stub
		
	}

	//01234567
	int[] dr = {-1,-1,0,1,1,1,0,-1};
	int[] dc = {0,-1,-1,-1,0,1,1,1};
	
	private class Fish{
		int num, dir;

		public Fish(int num, int dir) {
			super();
			this.num = num;
			this.dir = dir;
		}
	}
}
