package com.baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SavePrincess17836 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int height = Integer.parseInt(st.nextToken());
		int width = Integer.parseInt(st.nextToken());
		int time = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[height][width];
		boolean[][] vis = new boolean[height][width];
		
		for (int i = 0; i < height; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < width; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		Queue<Pair>	q = new LinkedList<>();
		q.offer(new Pair(0,0));
		vis[0][0] = true;
		arr[0][0] = 3;
		
		int[] dx = {1,-1,0,0};
		int[] dy = {0,0,1,-1};
		
		int min = 10000;
		
		while(!q.isEmpty()) {
			Pair now = q.poll();
			
			for (int k = 0; k < 4; k++) {
				int rx = now.x + dx[k];
				int ry = now.y + dy[k];
				if(rx < 0 || ry < 0 || rx >= width || ry >= height) continue;
				if(!vis[ry][rx] && arr[ry][rx] != 1) {
					if(arr[ry][rx] == 2) {
						min = Math.min(min, (width - rx - 1) + (height - ry - 1) + arr[now.y][now.x] - 2);
					}
					
					vis[ry][rx] = true;
					q.offer(new Pair(rx,ry));
					arr[ry][rx] = arr[now.y][now.x] + 1;
				}
			}
		}
		
		if(arr[height-1][width-1] != 0) {
			min = Math.min(min, arr[height-1][width-1] - 3);
		}
		
		if(min <= time) {
			System.out.println(min);
		}else {
			System.out.println("Fail");
		}
		
		for (int[] is : arr) {
			for(int i : is) System.out.print(i+ " ");
			System.out.println();
		}
	}
	
	static class Pair{
		int x;
		int y;
		public Pair(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
}
