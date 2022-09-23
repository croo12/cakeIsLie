package com.baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AddressNaming2667 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] map = new int[n][n];
		boolean[][] visited = new boolean[n][n];
		
		for (int i = 0; i < n; i++) {
			String[] s = br.readLine().split("");
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(s[j]);
			}
		}
		
		Queue<AddressPair> q = new LinkedList<>();
		List<Integer> result = new ArrayList<>();
		int[] rx = {0,0,1,-1};
		int[] ry = {1,-1,0,0};
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(map[i][j] == 1 && !visited[i][j]) {
					q.offer(new AddressPair(j, i));
					visited[i][j] = true;
					int cnt = 1;
					
					while(!q.isEmpty()) {
						AddressPair now = q.poll(); 
						
						for (int k = 0; k < 4; k++) {
							int nX = now.x + rx[k];
							int nY = now.y + ry[k];
							
							if(nX >= n || nY >= n || nX<0 || nY <0) continue;
							if(map[nY][nX] == 1 && !visited[nY][nX]) {
								visited[nY][nX] = true;
								q.offer(new AddressPair(nX, nY));
								cnt++;
							}
						}
					}
					result.add(cnt);
				}
			}
		}//for문
		
		Collections.sort(result);
		StringBuilder sb = new StringBuilder();
		sb.append(result.size()).append("\n");
		for (int i = 0; i < result.size(); i++) {
			sb.append(result.get(i)).append("\n");
		}
		System.out.print(sb);
	}
	static class AddressPair{
		int x;
		int y;
		public AddressPair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
