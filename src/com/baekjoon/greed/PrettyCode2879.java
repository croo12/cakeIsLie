package com.baekjoon.greed;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PrettyCode2879 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer wrong = new StringTokenizer(br.readLine()," ");
		StringTokenizer right = new StringTokenizer(br.readLine()," ");
		
		int[] diff = new int[N];
		
		for (int i = 0; i < N; i++) {
			diff[i] = Integer.parseInt(wrong.nextToken()) - Integer.parseInt(right.nextToken());
		}
		
		//연속된+ 와 연속된 -는 함께 움직이는 게 이득임.
		//0을 움직이면서 까지 크게 묶는 경우가 더 좋을 때는 없을 것 같다.
		//0을 묶어서 움직이면 두번에 나눠서 움직일 걸 한번 움직이는건데
		//어차피 0을 그만큼 되돌려놔야 하니까 똑같을 것
		
		//+묶음, -묶음이 모두 0이 되기위해 가장 작은 수 기준으로 빼고 더하기 하자
		//앞부터 하자
		
		//정답 출력용
		int ans = 0;
		//앞에 있는 0 거르기 용
		int idx = 0;
		//음수묶음인지 양수묶음인지 표시
		boolean isMinus;
		//묶음의 최소값 구하기(절댓값)
		int min;
		//묶음의 끝 표시용
		int ed;
		
		while(true) {
			while(idx < N && diff[idx] == 0)
				idx++;
			
			if(idx == N)
				break;
			
			isMinus = diff[idx] < 0;
			
			ed = N;
			min = 81;
			for (int i = idx; i < N; i++) {
				if((isMinus && diff[i] >= 0) || (!isMinus && diff[i] <= 0)) {
					ed = i;
					break;
				}
				min = Math.min(min, isMinus ? diff[i] * -1 : diff[i]);
			}
			
			for (int i = idx; i < ed; i++) {
				diff[i] -= isMinus ? min * -1 : min;
			}
			
			ans+= min;
		}
		
		System.out.println(ans);
	}
}
