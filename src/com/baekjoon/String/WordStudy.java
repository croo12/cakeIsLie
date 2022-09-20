package com.baekjoon.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WordStudy {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] cnt = new int[27];
		int now;
		while(true) {
			now = br.read() - 'A';
			if(now >= 32) now -= 32;
			if(now < 0 || now > 26) break;
//			System.out.println(now);
			
			cnt[now]++;
		}
		br.readLine();
		
		int max = -1;
		int result = 0;
		boolean flag = false;
		for (int i = 0; i < 27; i++) {
			if(cnt[i] > max) {
				max = cnt[i];
				result = i + 'A';
				flag = false;
			}else if(cnt[i] == max) {
				flag = true;
			}
		}
		
		if(flag) System.out.println("?");
		else System.out.println((char)result);
		
	}
}
