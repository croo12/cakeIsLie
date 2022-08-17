package com.beakjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class NumberOfIslands4963 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
			while(true) {
				st = new StringTokenizer(br.readLine());
				int width = Integer.parseInt(st.nextToken());
				int height = Integer.parseInt(st.nextToken());
				
				if(width == 0 && height == 0) return;
				
				int[][] map = new int[height][width];
				boolean[][] visited = new boolean[height][width];
				for (int i = 0; i < height; i++) {
					String[] s = br.readLine().split(" ");
					for (int j = 0; j < width; j++) {
						map[i][j] = Integer.parseInt(s[j]);
					}
				}
				
				Queue<IslandPair> q = new LinkedList<>();
				int[] rx = {0,0,1,1,1,-1,-1,-1};
				int[] ry = {1,-1,0,1,-1,0,1,-1};
				
				int cnt = 0;
				
				for (int i = 0; i < height; i++) {
					for (int j = 0; j < width; j++) {
						if(map[i][j] == 1 && !visited[i][j]) {
							q.add(new IslandPair(j, i));
							visited[i][j] = true;
							cnt++;
							while(!q.isEmpty()) {
								IslandPair now = q.poll();
								
								for (int k = 0; k < 8; k++) {
									int nextX = now.x + rx[k];
									int nextY = now.y + ry[k];
									if(nextX < 0 || nextY < 0 || nextX >= width || nextY >= height) continue;
									else if(map[nextY][nextX] == 1 && !visited[nextY][nextX]) {
										q.add(new IslandPair(nextX, nextY));
										visited[nextY][nextX] = true;
									}
								}
							}
						}
					}
				}
				
				System.out.println(cnt);
			}
	}
}

class IslandPair{
	int x;
	int y;
	public IslandPair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}