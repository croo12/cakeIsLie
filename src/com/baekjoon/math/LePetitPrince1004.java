package com.baekjoon.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LePetitPrince1004 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			int n = Integer.parseInt(br.readLine());
			
			int cnt = 0;
			
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				int cx = Integer.parseInt(st.nextToken());
				int cy = Integer.parseInt(st.nextToken());
				int cr = Integer.parseInt(st.nextToken());
				
				boolean in1 = Math.pow(cx-x1, 2) + Math.pow(cy-y1, 2) < Math.pow(cr, 2);
				boolean in2 = Math.pow(cx-x2, 2) + Math.pow(cy-y2, 2) < Math.pow(cr, 2);
				
				if((in1 && in2) || (!in1 && !in2)) {
					continue;
				}else {
					cnt++;
				}
			}
			
			sb.append(cnt).append('\n');
		}
		
		System.out.print(sb);
	}
}
