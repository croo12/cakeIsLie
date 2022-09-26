package com.baekjoon.CNU;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class K {
	
	static int N;
	static int[] arr;
	
	static int max = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		go(1,1,arr[0]);
		
		//도미노 j번째가 쓰러지려면 그 전까지 도미노 무게의 합이 j번째 도미노보다 무겁거나 같아야함
		// -> 현재 못쓰러트리는 도미노를 쓰러트릴 방법은 존재하지 않음
		// -> 앞부터 진행해가다가 쓰러트릴 수 없는 도미노는 제거해야함 
		// 앞에 있는 도미노를 다 제거하는 경우가 더 적을 수도 있음
		// sum은 int 범위임
		
		System.out.println(max);
	}
	
	static void go(int idx, int cnt, int sum) {
		if(idx == N) {
			max = Math.max(cnt, max);
			return;
		}
		
		if(arr[idx] <= sum)
			go(idx+1, cnt+1 ,sum + arr[idx]); //무난히 다음칸
		else {
			go(idx+1, cnt, sum); //이 자리 제거
			go(idx+1, 1, arr[idx]); //이 전까지 모든 도미노 제거
		}
		
	}
}
	



