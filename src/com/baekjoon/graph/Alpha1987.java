package com.baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Alpha1987 {
	public static void main(String[] args) {
		try {
			new Alpha1987().solution();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	int R;
	int C;
	char[][] arr; 
	
	int[] dr = {0,1,0,-1};
	int[] dc = {1,0,-1,0};
	
	int ans;
	
	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new char[R][C];
		
		String s;
		for (int i = 0; i < R; i++) {
			s = br.readLine();
			for (int j = 0; j < C; j++) {
				arr[i][j] = s.charAt(j);
			}
		}
		
		ans = 1;
		
		dfs(0, 0, 1 << (arr[0][0] - 'A') , 1);
		
		System.out.println(ans);
	}
	
	public void dfs(int r, int c, int vis, int cnt) {
		ans = Math.max(ans, cnt);
		
		int rr, rc, chk;
		for (int i = 0; i < 4; i++) {
			rr = r + dr[i];
			rc = c + dc[i];
			
			if(rr < 0 || rc < 0 || rr >= R || rc >= C)
				continue;
			
			chk = 1 << (arr[rr][rc] - 'A');
			
			if( (vis & chk) != 0)
				continue;
			
			dfs(rr, rc, vis + chk, cnt + 1);
		}
	}
}
