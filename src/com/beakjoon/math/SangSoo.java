package com.beakjoon.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SangSoo {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] a = new int[3];
		int[] b = new int[3];
		int now;
		int cnt = 0;
		while(true) {
			now = br.read()-'0';
			if(now > 10 || now < 0) {
				continue;
			}
			
			if(cnt/3 == 0) {
				a[2-cnt] = now;
			}else {
				b[2-cnt%3] = now;
			}
			
			cnt++;
			if(cnt == 6) break;
		}
		int sum1=0;
		int sum2=0;
		for (int i = 0; i < 3; i++) {
			sum1 = sum1*10 + a[i];
			sum2 = sum2*10 + b[i];
		}
		if(sum1 > sum2) {
			System.out.println(sum1);
		}else {
			System.out.println(sum2);
		}
	}
}
