package com.baekjoon.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class ComebackHome1189 {
	public static void main(String[] args) {
		try {
			new ComebackHome1189().solution();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	int R, C, K;
	
	private void solution() throws IOException {
		var br = new BufferedReader(new InputStreamReader(System.in));
		var st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		boolean[][] map = new boolean[R][C];
		String tmp;
		for (int i = 0; i < R; i++) {
			tmp = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = tmp.charAt(j) == 'T';
			}
		}
		
		int[] dr = {0,0,1,-1};
		int[] dc = {1,-1,0,0};
		
		var q = new ArrayDeque<Pair>();
		
		q.offer(new Pair(R-1, 0, 1, (1 << convert(R-1, 0)) ));
		
		int ans = 0;
		Pair now;
		while(!q.isEmpty()) {
			now = q.poll();
			
			if(now.length == K) {
				if(now.r == 0 && now.c == C-1)
					ans++;
				continue;
			}
			
			if(now.r == 0 && now.c == C-1)
				continue;
			
			for (int i = 0; i < 4; i++) {
				
				int rr = now.r + dr[i];
				int rc = now.c + dc[i];
				
				int checker = 1 << convert(rr,rc);
				if(rr >= R || rc >= C || rr < 0 || rc < 0 || map[rr][rc] || ( now.vis & checker ) != 0 ) continue;
				
				q.offer(new Pair( rr, rc, now.length + 1 , now.vis + checker ));
				
			}
		}
		
		System.out.println(ans);
	}
	
	int convert(int r, int c) {
		return r * C + c; 
	}
	
	class Pair{
		int r, c, length, vis;

		public Pair(int r, int c, int length, int vis) {
			super();
			this.r = r;
			this.c = c;
			this.length = length;
			this.vis = vis;
		}
	}
}
