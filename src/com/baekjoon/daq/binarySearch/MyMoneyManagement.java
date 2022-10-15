package com.baekjoon.daq.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MyMoneyManagement {

	static int n;
	static int m;
	static int[] budget;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		budget = new int[n];
		
		for (int i = 0; i < n; i++) {
			budget[i] = Integer.parseInt(br.readLine());
		}
		
		long start = 1; 
		long end = 10000*n +1;
		long mid = (start + end)/2;
		
		while(end >= start) {
			if(make(mid)) {
				end = mid-1;
			}else {
				start = mid+1;
			}
			mid = (end+start)/2;
		}
		System.out.println(start);
	}
	
	private static boolean make(long mid) { // 다 들어감?
		long money = m; //인출횟수
		long now = mid; //돈의 양
		
		money--; //인출 한번 한다.
		
		for (int i = 0; i < budget.length; i++) {
			if(now < budget[i]) { // 남은 돈이 다음 예산 보다 적다면
				money--; //새 돈꺼내기
				now = mid; //예산 다시 풀충전 하기
				if(now < budget[i]) { //풀충전한 돈도 작니?
					return false; // 그럼 이건 실패임
				}else {
					now -= budget[i]; //풀충전 하니까 괜찮으면 돈 쓰기
				}
			}else {
				now -= budget[i];
			}	
		}
		
		if(money < 0) return false; //인출 횟수부족
		else return true; //성공
	}
}
