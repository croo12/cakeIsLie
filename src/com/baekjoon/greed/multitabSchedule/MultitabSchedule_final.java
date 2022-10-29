package com.baekjoon.greed.multitabSchedule;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MultitabSchedule_final {
	public static void main(String[] args) {
		try {
			new MultitabSchedule_final().solution();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		//멀티탭을 꽂다가 -> 어느날 멀티탭 구멍이 없다
		//헉 어떡하지... -> 현재 꽂혀있는 것 중 
		//자기 차례가 가장 멀리있는 걸 뽑아야한다.
		
		//내 생각엔 이것보다 좋은 방법은 없음
		
		//어떻게 자기 차례가 가장 멀다는건 알 것인가?
		//그냥 뒤에 뒤져보죠?
		
		st = new StringTokenizer(br.readLine());
		int[] order = new int[K];
		boolean[] vis = new boolean[K + 1];
		int[] leftCount = new int[K + 1];
		
		for (int i = 0; i < K; i++) {
			order[i] = Integer.parseInt(st.nextToken());
			leftCount[order[i]]++;
		}
		
		int ans = 0;
		int idx = 0;
		
		//지금 멀티탭에 꽃혀있는 전자기기 수
		int cnt = 0;
		
		int now;
		while(idx < K) {
			now = order[idx];
			leftCount[now]--;
			//멀티탭에 안꽂혀있는 전자기기임
			if(!vis[now]) {
				//멀티탭에 자리있다
				if(cnt < N) {
					vis[now] = true;
					cnt++;
				}
				//멀티탭에 자리 없다
				else {
					//현재 꽂혀있는 놈들중 제일 먼 순서에 있는 놈 찾기
					int max = 0;
					int num = -1;
					
					for (int i = 1; i <= K; i++) {
						if(vis[i])
							if(leftCount[i] == 0) {
								num = i;
								break;
							}
							else if(leftCount[i] > 0) {
								for (int j = idx + 1; j < K; j++) {
									if(order[j] == i) {
										if(j > max) {
											max = j;
											num = i;
										}
										break;
									}
								}
							}
					}
					
					//그놈 제거
					vis[num] = false;
					ans++;
					//새놈 추가
					vis[now] = true;
				}
			}
			
			idx++;
		}
		
		System.out.println(ans);
	}
}
