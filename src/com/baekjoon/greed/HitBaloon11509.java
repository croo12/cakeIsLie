package com.baekjoon.greed;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class HitBaloon11509 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		//어차피 제일 왼쪽 풍선 떨어트리려면 그 높이로 한번 쏴야함
		//그니까 그냥 왼쪽부터 없애면 똑같은거 아님?
		
		int[] h = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			h[i] = Integer.parseInt(st.nextToken());
		
		int idx = 0;
		int height;
		int ans = 0;
		while(true) {
			
			while(idx < N && h[idx] == -1)
				idx++;
			
			if(idx == N)
				break;
			
			height = h[idx];
			
			for (int i = idx; i < N; i++) {
				if(h[i] == height) {
					height--;
					h[i] = -1;
				}
			}
			ans++;
		}
		
		System.out.println(ans);
	}
}
