package com.baekjoon.greed;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class HitBaloon11509__ver2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		//어차피 제일 왼쪽 풍선 떨어트리려면 그 높이로 한번 쏴야함
		//그니까 그냥 왼쪽부터 없애면 똑같은거 아님?
		
		//확장해서 어차피 왼쪽에 있는 놈이 이전 화살에 터지지 않는다면, 
		//어차피 새로 화살을 쏴야하니 반복문을 돌 필요없이 즉시 해결 가능
		
		int[] h = new int[1000001];
		int height;
		int ans = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			height = Integer.parseInt(st.nextToken());
			if(h[height] == 0) {
				ans++;
				h[height-1]++;
			}else {
				h[height]--;
				h[height-1]++;
			}
		}
		
		System.out.println(ans);
	}
}
