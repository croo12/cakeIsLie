package com.baekjoon.sinchon0822;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Skill {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br.readLine();
		
		int now;
		int cnt = 0;
		int lFlag = 0;
		int sFlag = 0;
		while(true) {
			now = br.read();
			
			if(now >= '1' && now <= '9') 
				cnt++;
			else if(now == 'L')
				lFlag++;
			else if(now == 'S')
				sFlag++;
			else if(now == 'R')
				if(lFlag > 0) {
					cnt++;
					lFlag--;
				}else
					break;
			else if(now == 'K')
				if(sFlag > 0) {
					cnt++;
					sFlag--;
				}else
					break;
			else if(now == '\n')
				break;
		}
		System.out.println(cnt);
	}
}
