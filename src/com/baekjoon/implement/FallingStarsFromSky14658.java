package com.baekjoon.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FallingStarsFromSky14658 {
	public static void main(String[] args) {
		try {
			new FallingStarsFromSky14658().solution();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Star[] stars = new Star[K];
		
		
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			stars[i] = new Star();
			stars[i].c = Integer.parseInt(st.nextToken());
			stars[i].r = Integer.parseInt(st.nextToken());
		}
		
		Star now;
		int max = 0;
		
		for (int i = 0; i < K; i++) {
			now = stars[i];
			
			int minR;
			int maxR;
			int minC;
			int maxC;
			
			for (int j = 0; j < 4; j++) {
				int cnt = 0;
				
				switch(j) {
				
				case 0 :
					minR = now.r - L;
					maxR = now.r;
					minC = now.c - L;
					maxC = now.c;
					break;
					
				case 1:
					minR = now.r;
					maxR = now.r + L;
					minC = now.c;
					maxC = now.c + L;
					break;
					
				case 2:
					minR = now.r - L;
					maxR = now.r;
					minC = now.c;
					maxC = now.c + L;
					break;
					
				default:
					minR = now.r;
					maxR = now.r + L;
					minC = now.c - L;
					maxC = now.c;
				}
				
				for (int k = 0; k < K; k++) {
					Star tmp = stars[k];
					if(minR > tmp.r || maxR < tmp.r || minC > tmp.c || maxC < tmp.c)
						continue;
					cnt++;
				}
				System.out.println(now.r + ", " + now.c);
				System.out.println(minR + ", " + maxR);
				System.out.println(minC + ", " + maxC);
				System.out.println(cnt);
				max = Math.max(max, cnt);
			}
			
		}
		
		System.out.println(max);
		
	}
	
	class Star{
		int r,c;
	}
}
