package com.beakjoon.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MarbleEscape2_13460 { // 38%
	
	static char[][] arr;
	
	static Marble b;
	static Marble r;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int height = Integer.parseInt(st.nextToken());
		int width = Integer.parseInt(st.nextToken());
		
		arr = new char[height][width]; 
		
		for (int i = 0; i < height; i++) {
			String s = br.readLine();
			for (int j = 0; j < width; j++) {
				arr[i][j] = s.charAt(j);
				
				if(arr[i][j] == 'B') {
					b = new Marble(j,i,false);
					arr[i][j] = '.';
				}else if(arr[i][j] == 'R') {
					r = new Marble(j,i,true);
					arr[i][j] = '.';
				}
			}
		}
		
		backT(-1,1);
		
		if(cnt == 11) System.out.println(-1);
		else System.out.println(cnt);
	}
	
	static int cnt = 11;
	
	private static void backT(int dir, int depth) {
		
//		System.out.println("-----------------------------------------------");
//		for (int i=0; i < arr.length; i++) {
//			for(int j=0; j < arr[0].length; j++) {
//				if(b.x == j && b.y == i)
//					System.out.print('B');
//				else if(r.x == j && r.y == i)
//					System.out.print('R');
//				else
//					System.out.print(arr[i][j]);
//			}
//			System.out.println();
//		}
//		System.out.println("-----------------------------------------------");
		
		if(depth == 11) {
			return;
		}
		
		boolean rf = false;
		boolean bf = false;
		
		int rx = r.x;
		int bx = b.x;
		int ry = r.y;
		int by = b.y;
		
		for(int k=0; k < 4; k++) {
			if(dir != k/2 * 2 && dir != k/2 * 2 + 1) {
				switch(k) {
				case 0 : 
					if(rx > bx) {
						rf = r.move(k);
						bf = b.move(k);
					}else {
						bf = b.move(k);
						rf = r.move(k);
					}
					break;
					
				case 1 :
					if(rx > bx) {
						bf = b.move(k);
						rf = r.move(k);
					}else {
						rf = r.move(k);
						bf = b.move(k);
					}
					break;
					
				case 2 :
					if(ry > by) {
						rf = r.move(k);
						bf = b.move(k);
					}else {
						bf = b.move(k);
						rf = r.move(k);
					}
					break;
					
				case 3 :
					if(ry > by) {
						bf = b.move(k);
						rf = r.move(k);
					}else {
						rf = r.move(k);
						bf = b.move(k);
					}
				}
				
				if( bf || rf){
					if(rf && !bf)
						cnt = Math.min(depth,cnt);
					
					b.x = bx;
					r.x = rx;
					b.y = by;
					r.y = ry;
					
					continue;
				}
				
				backT(k,depth+1);
				
				b.x = bx;
				r.x = rx;
				b.y = by;
				r.y = ry;
			}
		}
	}
	
	static class Marble {
		int x;
		int y;
		boolean isRed;
		Marble(int x, int y, boolean isRed){
			this.x = x;
			this.y = y;
			this.isRed = isRed;
		}
		
		public boolean move(int dir) {
			int anotherX = isRed ? b.x : r.x;
			int anotherY = isRed ? b.y : r.y;
			int rx = x + dx[dir];
			int ry = y + dy[dir];
			while(arr[ry][rx] != '#' && arr[ry][rx] != 'O' && (rx != anotherX || ry != anotherY)) {
				rx = rx + dx[dir];
				ry = ry + dy[dir];
			}

			x = rx - dx[dir];
			y = ry - dy[dir];
			
			if(arr[ry][rx] == 'O') {
				x = -1;
				y = -1;
				return true;
			}
			
			return false;
		}
	}
}
