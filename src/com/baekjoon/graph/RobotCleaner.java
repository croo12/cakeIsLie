package com.baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RobotCleaner {
	
	public static void main(String[] args) {
		try {
			new RobotCleaner().solution();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void solution() throws IOException {

		var br = new BufferedReader(new InputStreamReader(System.in));
		var st =new StringTokenizer(br.readLine());

		var row = Integer.parseInt(st.nextToken());
		var col = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		var r = Integer.parseInt(st.nextToken());
		var c = Integer.parseInt(st.nextToken());
		var dir = Integer.parseInt(st.nextToken());
		
		var robot = new Robot(r, c, dir);
		
		int[][] map = new int[row][col];
		boolean[][] vis = new boolean[row][col];
		
		for (int i = 0; i < row; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < col; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int ans = 0;
		
		while(true) {
//			System.out.println(robot);
			
			if(!vis[robot.r][robot.c] && map[robot.r][robot.c] != 1) {
				vis[robot.r][robot.c] = true;
				ans++;
			}
			
			boolean flag = true;
			
			for (int k = 0; k < 4; k++) {
				
				//왼쪽으로 회전한 방향
				int rd = dd[robot.dir];
				
				int rr = robot.r + dr[rd];
				int rc = robot.c + dc[rd];
				
				if(vis[rr][rc] || map[rr][rc] == 1) {
					robot.dir = rd;
					continue;
				}
				
				robot.dir = rd;
				robot.r = rr;
				robot.c = rc;
				
				flag = false;
				break;
			}
			
			//후진
			if(flag) {
				
				int rr = robot.r - dr[robot.dir];
				int rc = robot.c - dc[robot.dir];
				
				//뒤에 갈 곳 없음
				if(map[rr][rc] == 1)
					break;
				else {
					robot.r = rr;
					robot.c = rc;
				}
			}
		}
		
		System.out.println(ans);
	}
	
	//0123 북동남서
	int[] dr = {-1,0,1,0};
	int[] dc = {0,1,0,-1};
	
	//다음 방향
	int[] dd = {3,0,1,2};
	
	private class Robot{
		int r,c,dir;

		public Robot(int r, int c, int dir) {
			super();
			this.r = r;
			this.c = c;
			this.dir = dir;
		}

		@Override
		public String toString() {
			return "Robot [r=" + r + ", c=" + c + ", dir=" + dir + "]";
		}
	}
}
