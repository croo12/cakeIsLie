package com.baekjoon.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GoodByeLittleDust17144 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());

		// 구현문제겠지

		// 공기청정기의 R
		int[] cleanerR = new int[R];
		
		//지도와 임시 변동치 저장용
		int[][] map = new int[R][C];
		int[][] tmp = new int[R][C];

		// 먼지 세기
		int dust = 0;

		// 지도 등록
		int now;
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				now = Integer.parseInt(st.nextToken());
				map[i][j] = now;
				if (now == -1 && cleanerR[0] == 0) {
					cleanerR[0] = i;
					cleanerR[1] = i + 1;
				}
				if (now > 0) {
					dust += now;
				}
			}
		}
		
		//우좌상하
		int[] dr = {0,0,-1,1};
		int[] dc = {1,-1,0,0};
		
		//상우하좌
		int[] upper = {2,0,3,1};
		//하우상좌
		int[] lower = {3,0,2,1};
		
		int rr,rc,div;
		while (T-- > 0) {
			//미세먼지 퍼트리기
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if(map[i][j] <= 4) continue;
					
					div = map[i][j]/5;
					
					for (int k = 0; k < 4; k++) {
						rr = i + dr[k];
						rc = j + dc[k];
						
						if(rr >= R || rr < 0 || rc >= C || rc < 0 || map[rr][rc] == -1)
							continue;
						
						tmp[rr][rc] += div;
						tmp[i][j] -= div;
					}
				}
			}
			
			//변경된 미세먼지 반영 && tmp 초기화
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					map[i][j] += tmp[i][j];
					tmp[i][j] = 0;
				}
			}
			
			//공기 청정기 가동(위쪽)
			rr = cleanerR[0]-1;
			rc = 0;
			dust -= map[rr][rc];
			for (int k = 0; k < 4; k++) {
				while(rr + dr[upper[k]] < cleanerR[1] && rr + dr[upper[k]] >= 0 
						&& rc + dc[upper[k]] < C && rc + dc[upper[k]] >= 0 
						&& map[rr+dr[upper[k]]][rc+dc[upper[k]]] != -1) {
					
					map[rr][rc] = map[rr+dr[upper[k]]][rc+dc[upper[k]]];
					rr += dr[upper[k]];
					rc += dc[upper[k]];
				}
			}
			map[rr][rc] = 0;
				
			//아래쪽
			rr = cleanerR[1]+1;
			rc = 0;
			dust -= map[rr][rc];
			for (int k = 0; k < 4; k++) {
				while(rr + dr[lower[k]] < R && rr + dr[lower[k]] >= cleanerR[1] 
						&& rc + dc[lower[k]] < C && rc + dc[lower[k]] >= 0 
						&& map[rr+dr[lower[k]]][rc+dc[lower[k]]] != -1) {
					
					map[rr][rc] = map[rr+dr[lower[k]]][rc+dc[lower[k]]];
					rr += dr[lower[k]];
					rc += dc[lower[k]];
				}
			}
			map[rr][rc] = 0;
		}
		
		System.out.println(dust);
	}
}
