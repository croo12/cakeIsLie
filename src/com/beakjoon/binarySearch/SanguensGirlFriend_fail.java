package com.beakjoon.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SanguensGirlFriend_fail { //틀렸다. 나중에 빌어먹을 소수점을 long으로 바꿔서 해보자
	//보이어무어
	//kmp
	//카프라빈
	
	static double a;
	static double b;
	static double c;
	static double d;
	static double m;
	static double t;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		while(true) {
			try {
				st = new StringTokenizer(br.readLine());
				a = Double.parseDouble(st.nextToken());
				b = Double.parseDouble(st.nextToken());
				c = Double.parseDouble(st.nextToken());
				d = Double.parseDouble(st.nextToken());
				m = Double.parseDouble(st.nextToken());
				t = Double.parseDouble(st.nextToken());
				
				double start = 0;
				double end = 200000000000L;
				double mid;
				while(end >= start) {
					mid = (start+end)/2;
					if(check(mid)) {
						start = mid + 0.001;
					}else {
						end = mid - 0.001;
					}
				}
				long result = (long)(end*100);
				System.out.println((double)result/100);
			}catch(Exception e) {
				return;
			}
		}
	}
	
	private static boolean check(double mid) {
		double oilPerHour = a*mid*mid*mid*mid
		+
		b*mid*mid*mid
		+
		c*mid*mid
		+
		d*mid;
		
		double time = m/mid;
		
		if(oilPerHour*time > t) {
			return false;
		}else {
			return true;
		}
	}
}
