package com.beakjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class AreaSearch {
	public static void main(String[] args) throws IOException {
		AreaSearch me = new AreaSearch();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		boolean[][] area = new boolean[m][n];
		
		for (int num = 0; num < k; num++) {
			st = new StringTokenizer(br.readLine());
			int lx = Integer.parseInt(st.nextToken());
			int dy = Integer.parseInt(st.nextToken());
			int rx = Integer.parseInt(st.nextToken());
			int uy = Integer.parseInt(st.nextToken());
			
			for (int i = dy; i <= uy-1; i++) {
				for (int j = lx; j <= rx-1; j++) {
					area[i][j] = true;
				}
			}
		}
		
		Queue<P> q = new LinkedList<>();
		ArrayList<Integer> list = new ArrayList<>();
		
		int[] dx = {1,-1,0,0};
		int[] dy = {0,0,-1,1};
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if(!area[i][j]) {
					q.offer(me.new P(j,i));
					area[i][j] = true;
					int cnt = 0;
					
					while(!q.isEmpty()) {
						P now = q.poll();
						cnt++;
						
						for (int l = 0; l < 4; l++) {
							int nX = now.x + dx[l];
							int nY = now.y + dy[l];
							if(nX < 0 || nY < 0 || nX >= n || nY >= m) continue;
							if(!area[nY][nX]){
								q.offer(me.new P(nX,nY));
								area[nY][nX] = true;
							}
						}
					}//while
					list.add(cnt);
				}
			}
		}
		Collections.sort(list);
		StringBuilder sb = new StringBuilder();
		sb.append(list.size()).append("\n");
		for (int i = 0; i < list.size(); i++) {
			sb.append(list.get(i)).append(" ");
		}
		
		System.out.println(sb);
	}
	
	class P {
		int x;
		int y;
		public P(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
