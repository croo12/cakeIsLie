package com.baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CabbageBug {
	
	static boolean[][] visited;
	static boolean[][] cabbages;
	
	static int x;
	static int y;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
			int cnt = 0;
			
			visited = new boolean[x][y];
			cabbages = new boolean[x][y];
			for(int i = 0; i<k; i++) {
				st= new StringTokenizer(br.readLine());
				cabbages[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = true;
			}
			
			for (int i = 0; i < x; i++) {
				for (int j = 0; j < y; j++) {
					if((!visited[i][j]) && cabbages[i][j]) {
						searchNear(i,j);
						cnt++;
					}
				}
			}
			
			System.out.println(cnt);
		}
	}
	
	private static void searchNear(int i, int j) {
		visited[i][j] = true;
		
		int[] dx = {0,0,1,-1};
		int[] dy = {1,-1,0,0};
		
		for(int k = 0; k < 4; k++) {
			if(i+dx[k] < 0 || i+dx[k] >= x || j+dy[k] <0 || j+dy[k] >= y 
					|| visited[i+dx[k]][j+dy[k]] || !cabbages[i+dx[k]][j+dy[k]]) {
				continue;
			}else {
				searchNear(i+dx[k], j+dy[k]);
			}
		}
		
	}
}
