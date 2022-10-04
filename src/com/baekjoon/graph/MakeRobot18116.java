package com.baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MakeRobot18116 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] p = new int[1000001];
		int[] c = new int[1000001];
		for (int i = 1; i < 1000001; i++) {
			p[i] = i;
			c[i] = 1;
		}
		
		//이거 그냥 크루스칼인듯
		//근데 값 셀때마다 일일히 10^6을 체크하는 건 느릴 것 같으니 값도 저장하기
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			//true : 출력, false : union;
			boolean flag = st.nextToken().equals("Q");
			
			if(flag) {
				int num = Integer.parseInt(st.nextToken());
				sb.append(c[findSet(num,p)]).append('\n');
			}else {
				int left = Integer.parseInt(st.nextToken());
				int right = Integer.parseInt(st.nextToken());
				
				int L = findSet(left, p);
				int R = findSet(right, p);
				
				if(L == R) continue;
				
				p[R] = L;
				c[L] += c[R];
			}
		}
		
		System.out.print(sb);
	}
	
	static private int findSet(int x, int[] p) {
		if(p[x] == x) return x;
		return p[x] = findSet(p[x], p);
	}
}
