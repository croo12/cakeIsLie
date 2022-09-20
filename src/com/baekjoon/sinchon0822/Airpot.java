package com.baekjoon.sinchon0822;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Airpot {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int airpot = 0;
		int back = 0;
		int last = 0;
		int now;
		
		while(n-- > 0) {
			now = Integer.parseInt(st.nextToken());
			
			if(now == back) {
				last = last*2;
				airpot+= last;
			}else {
				airpot+= 2;
				back = now;
				last = 2;
			}
			
			if(airpot >= 100) {
				airpot = 0;
				back = 0;
				last = 0;
			}
		}
		System.out.println(airpot);
	}
}
