package com.swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SangHosBattleField {
	
	static char[][] map;
	static int h;
	static int w;
	
	class Tank{
		int x;
		int y;
		char me;
		int[] dx = {0,0,1,-1};
		int[] dy = {-1,1,0,0};
		
		public Tank(int x, int y, char me) {
			this.x = x;
			this.y = y;
			this.me = me;
		}
		
//		public char showMe(){
//			return me;
//		}
		
		public void command(char dir) {
			switch(dir) {
				case 'U' :	
					me = '^';
					move(0);
					break;
				case 'D' :
					this.me = 'v';
					move(1);
					break;
					
				case 'R' :
					this.me = '>';
					move(2);
					break;
					
				case 'L' :
					this.me = '<';
					move(3);
					break;
					
				case 'S' :
					int now = myDirection();
					int nx = x+dx[now];
					int ny = y+dy[now];
					while(true) {
						if(nx < 0 || ny < 0 || nx >= w || ny >= h) break;
						if(map[ny][nx] == '*') {
							map[ny][nx] = '.';
							break;
						}
						if(map[ny][nx] == '#'){
							break;
						}
						nx = nx + dx[now];
						ny = ny + dy[now];
					}
			}
		}
		
		private boolean move(int dir) {
			int nx = x +dx[dir];
			int ny = y +dy[dir];
			
			if(nx < 0 || ny < 0 || nx >= w || ny >= h) return false;
			if(map[ny][nx] == '.') {
				x = nx;
				y = ny;
			}
			return true;
		}
		
		private int myDirection() {
			switch(me) {
				case '^' :
					return 0;
				case 'v' :
					return 1;
				case '>' :
					return 2;
				case '<' :
					return 3;
			}
			return -1;
		}
	}
	
	public static void main(String[] args) throws IOException {
		SangHosBattleField me = new SangHosBattleField();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			h = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			
			map = new char[h][w];
			Tank tank = null;
			
			for (int i = 0; i < h; i++) {
				char[] cs = br.readLine().toCharArray();
				for (int j = 0; j < w; j++) {
					map[i][j] = cs[j];
					if(cs[j] == '<' || cs[j] == '>' || cs[j] == '^' || cs[j] == 'v') {
						tank = me.new Tank(j,i,cs[j]);
						map[i][j] = '.';
					}
				}
			}
			
			int num = Integer.parseInt(br.readLine());
			
			int now;
			for (int i = 0; i < num; i++) {
				now = br.read();
				tank.command((char)now);
			}
			br.readLine();
			
			map[tank.y][tank.x] = tank.me;
			
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append(" ");
			for (char[] cs : map) {
				for(char c : cs) sb.append(c);
				sb.append("\n");
			}
			System.out.print(sb);
		}
	}
}
