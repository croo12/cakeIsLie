package com.swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RightSquare {
	
	static int n;
	
	static boolean[][] arr;
	static int firstX;
	static int firstY;
	static int lastX;
	static int lastY;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) { //testCaseOn
			
			n = Integer.parseInt(br.readLine());
			arr = new boolean[n][n];
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					int now = br.read();
					if(now == '.')arr[i][j] = false; 
					else if(now == '#')arr[i][j] = true;
					else j--;
				}
			}
			br.readLine();
			
			boolean flag = false;
			boolean result = true;
			
			for (int i = 0; i < n; i++) {
				if(result) {
					if(flag) 
						for (int j = 0; j < n; j++) {
							if(arr[i][j] && i < firstX) {
								result = false;
								break;
							}else if(arr[i][j]){
								lastX = i;
								lastY = j;
							}
						}
					else
						for (int j = 0; j < n; j++) {
							if(arr[i][j]) {
								firstX = i;
								firstY = j;
								flag = true;
								i--;
								break;
							}
						}
				}//if -- result	
			}
			
			if(lastX-firstX+1 != lastY-firstY+1) result = false;
			
			if(result) {
//				boolean[][] square = new boolean[lastX-firstX+1][lastY-firstY+1];
				for (int x = firstX; x <= lastX; x++) {
					for (int y = firstY; y <= lastY; y++) {
						if(!arr[x][y]) result = false;
					}
				}
			}
			
			if(result) {
				for (int x = lastX+1; x < n; x++) {
					for (int y = firstY; y <= lastY; y++) {
						if(arr[x][y]) result = false;
					}
				}
			}
			
//			int length = getWidth();
//			boolean result = true;
//			
//			for (int i = 0; i < length; i++) {
//				if(!result) break;
//				for (int j = 0; j < length; j++) {
//					
//					if(firstX+i < 0 || firstX+i >= n || firstY+j <0 || firstY+j >= n ) {
//						result = false;
//					}else if(!arr[firstX+i][firstY+j]) {
//						result = false;
//					}
//				}
//			}
//			
			if(result) System.out.println("#"+tc + " yes");
			else System.out.println("#"+tc + " no");
		}
	}
	
//	private static int getWidth() {
//		int cnt = 0;
//		for (int i = 0; i < n; i++) {
//			int nowX = firstX + i;
//			if(nowX >= 0 && nowX < n && arr[nowX][firstY] == true) {
//				cnt++;
//			}else {
//				break;
//			}
//		}
//		
//		return cnt;
//	}
}
