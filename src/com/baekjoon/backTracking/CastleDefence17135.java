package com.baekjoon.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CastleDefence17135 {
	//틀린 이유
	//1 : 틀렸습니다. ^ 모양으로 탐색하려고 만들었는데 v 모양으로 탐색하고 있었음
	//2 : 틀렸습니다(32%). --> 같은 적이 여러 궁수에게 공격받을 수 있음 문제를 잘 읽읍시다.
	static int[][] arr;
	static boolean[] archers;
	static int R, C, D;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		arr = new int[R][C];
		archers = new boolean[C];
		
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//R, C <= 15 // 선택지 3개 1초 //조합 + 계산하면 무난히 할듯
		//D <= 10 
		
		//먼저 조합으로 궁수의 위치 세개를 정한다.
		//그 다음 이 궁수배치가 몇명을 죽일지 알아낸다. -> 어떻게?
		//돌아봐야지 뭐
		
		comb(0,0);
		
		System.out.println(max);
	}
	
	static int max = 0;
	
	private static void comb(int depth, int idx) {
		if(depth == 3) {
			
			int[][] tmp = new int[R][C];
			for (int i = 0; i < R; i++) {
				tmp[i] = arr[i].clone();
			}
			
			int cnt = 0;
			
			int[][] orcs = {{-1,-1},{-1,-1},{-1,-1}};
			
			for(int start = R-1; start >= 0; start--) {
				int num = -1;
				for (int i = 0; i < C; i++) { //가로 조사
					if(archers[i]) {
						num++;
						Loop:for (int j = 1; j <= D; j++) { //길이만큼 범위를 조사할거임
							//시작 위치는 i번째 - j길이만큼 왼쪽 + 1
							//그 다음 위치가 j가 될때까지 row를 하강시키고, j가 되고 나면 다시 상승시킨다.
							for (int k = 0; k < (j-1)*2 + 1; k++) {
								int r = start - ((k >= j-1) ? ((j-1)*2 - k) : k);
								int c = i - j + 1 + k;
								
								if(c < 0 || c >= C || r < 0) 
									continue;
								
								if(tmp[r][c] == 1) {
									orcs[num][0] = r;
									orcs[num][1] = c;
									break Loop;
								}
							}
						}// Loop
					}
				}
				
				for (int i = 0; i < 3; i++) {
					if(orcs[i][0] != -1 && tmp[orcs[i][0]][orcs[i][1]] == 1) {
						tmp[orcs[i][0]][orcs[i][1]] = 0;
						cnt++;
					}
				}
			}//row
			
			max = Math.max(cnt, max);
			
			return;
		}
		
		if(idx == C) return;
		
		archers[idx] = true;
		comb(depth + 1, idx + 1);
		archers[idx] = false;
		comb(depth, idx + 1);
	}
	
}
