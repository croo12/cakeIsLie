package com.baekjoon.CNU;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class I {
	public static void main(String[] args) throws IOException {
		boolean[] pn = new boolean[1001];
		pn[0] = true;
		pn[1] = true;
		for (int i = 2; i < 100; i++) {
			if(!pn[i])
				for (int j = i*2; j <= 1000; j+=i) {
					pn[j] = true;
				}
		}
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a1 = Integer.parseInt(st.nextToken()), a2 = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int b1 = Integer.parseInt(st.nextToken()), b2 = Integer.parseInt(st.nextToken());
		
		int c1 = 0, c2 = 0;
		if(a1 <= b1 && a2 >= b1) {
			c1 = b1; c2 = a2;
		}else if(a1 <= b2 && a2 >= b2) {
			c1 = a1; c2 = b2;
		}else if(a1<= b1 &&  b2 <= a2) {
			c1 = b1; c2 = b2;
		}else if(b1<= a2 && a2 <= b2) {
			c1 = a1; c2 = a2;
		}
		
		int mid_cnt = 0;
		int yt_cnt = 0;
		int yj_cnt = 0;
		
		for (int i = c1; i <= c2; i++) {
			if(!pn[i]) mid_cnt++;
		}
		for (int i = a1; i <= a2; i++) {
			if(!pn[i]) yt_cnt++;
		}
		for (int i = b1; i <= b2; i++) {
			if(!pn[i]) yj_cnt++;
		}
		
		if(mid_cnt%2 != 0)
			yj_cnt--;
		
		if(yt_cnt - yj_cnt <= 0) {
			System.out.println("yj");
		}else {
			System.out.println("yt");
		}
	}
}
