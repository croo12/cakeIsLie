package com.baekjoon.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ramp14890 {
	//틀린 이유
	//13% : 아마 경사 길이가 1이고 바로 내리막 만난다음 끊기면 false로 나왔을 것임
	static int N;
	static int L;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][N];
		
		for (int i = 0; i < arr.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < arr.length; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//지난 칸 수를 기억하며 가기
		//지난 칸과 같으면 cnt++;
		//만약 1 차이가 난다 
		//나보다 높다 -> cnt와 L의 길이를 비교함
		//나보다 낮다 -> cnt를 1로 초기화한 후 
		//-> 다시 바뀔때까지의 cnt를 세서 숫자를 세서 
		//-> cnt와 L의 길이를 비교한 뒤, return해야함
		//-> cnt가 L만큼 갔으면 다시 cnt를 0으로 만들고 비교해야함
		//지난 칸과 2 차이가 나면 return false;
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			int[] hori = new int[N];
			int[] vert = new int[N];
			for (int j = 0; j < N; j++) {
				hori[j] = arr[i][j];
				vert[j] = arr[j][i];
			}
			if(check(hori)) {
//				System.out.println("위 : " + i);
				cnt++;
			}if(check(vert)) {
//				System.out.println("왼 : " + i);
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}
	
	private static boolean check(int[] road) {
		int last = road[0];
		int cnt = 1;
		boolean flag = false;
		for (int i = 1; i < N; i++) {
			if(road[i] == last) {
				cnt++;
			} else {
				//2 이상 차이남
				if(Math.abs(road[i] - last) > 1)
						return false;
				
				//나보다 1 큼
				if(road[i] > last) {
					if(cnt < L)
						return false;
				//나보다 1 작음
				}else {
					if(flag)
						return false;
					else
						flag = true;
				}
					
				cnt = 1;
				last = road[i];
			}
			
			if(flag && cnt >= L) {
				cnt -= L;
				flag = false;
			}
		}
		if(flag)
			return false;
		else
			return true;
	}
}
