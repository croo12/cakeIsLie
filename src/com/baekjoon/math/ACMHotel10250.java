package com.baekjoon.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ACMHotel10250 {
	//틀린이유
    //1 : 모서리값 생각 안함
    //2 : 패키지 삭제 깜빡함
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int H = Integer.parseInt(st.nextToken());
			st.nextToken();
			int N = Integer.parseInt(st.nextToken());
			
			//고객이 있는 층 = N%H
			//고객이 있는 호 = N/H + 1
			
			int h = N%H;
			int w = N/H + 1;
			if(h == 0) {
				h = H;
				w -= 1;
			}
			
			sb.append(h);
			if(w < 10) {
				sb.append('0');
			}
			sb.append(w).append('\n');
		}
		System.out.print(sb);
	}
}
