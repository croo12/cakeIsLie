package com.baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Tomato7576 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int freshT = 0;
	
	static Queue<PairXY> q = new LinkedList<>();
	
	static int[][] box;
	
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
				if(box[i][j] == 1) {
					q.add(new PairXY(j, i));
				}
			}
		}
		
		int[] dx = {1,-1,0,0};
		int[] dy = {0,0,1,-1};
		if (freshT == 0) {
			System.out.println(0);
		}else {
			while(!q.isEmpty()) {
				PairXY now = q.poll();
				
				for (int k = 0; k < 4; k++) {
					int nextX = now.x + dx[k];
					int nextY = now.y + dy[k];
					if(nextX >= width || nextY >= height || nextX < 0 || nextY <0) {
						continue;
					}
					if( box[nextY][nextX] == 0) {
						box[nextY][nextX] = box[now.y][now.x] + 1;
						q.add(new PairXY(nextX, nextY));
						freshT--;
					}
				}
			}
			if(freshT > 0) {
				System.out.println(-1);
			}else {
				last();
			}
		}
	}
	
	private static void last() {
		int max = 0;
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				if(box[i][j] > max) {
					max = box[i][j];
				}
			}
		}
		System.out.println(max-1);
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
	static class PairXY {
		int x;
		int y;
		public PairXY(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
