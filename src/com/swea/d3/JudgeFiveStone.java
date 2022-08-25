package com.swea.d3;

import java.util.Scanner;

public class JudgeFiveStone {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		int[] dx = {1,0,-1,1};
		int[] dy = {0,1,1,1};
		
		for (int tc = 0; tc < T; tc++) {
			int n = sc.nextInt();
			char[][] arr = new char[n][n];
			
			for (int i = 0; i < n; i++) {
				char[] s = sc.next().toCharArray();
				arr[i] = s;
			}
			
			boolean flag = false;
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if(arr[i][j] == 'o') {
						
						for(int k = 0; k < 4; k++) {
							int cnt = 0;
							int nx = j;
							int ny = i;
							while(true) {
								cnt++;
								if(cnt == 5) 
									flag = true;
								nx = nx + dx[k];
								ny = ny + dy[k];
								
								if(nx >= n || ny >= n || nx < 0 || ny < 0)
									break;
								if(arr[ny][nx] != 'o') 
									break;
							}		
						}
					}
				}
			}
			
			if(flag) System.out.printf("#%d YES\n",tc+1);
			else System.out.printf("#%d NO\n",tc+1);
			
		}
		
		sc.close();
	}
}
