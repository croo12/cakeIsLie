package com.baekjoon.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CroatiaAlphabet2941_fail {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int cnt = 0;
	
	public static void main(String[] args) throws IOException {//fail
		
		read();
		
		System.out.println(cnt);
	}
	
	private static void read() throws IOException {
		int now;
		while(true) {
			now = br.read();
			if(now == '\n' || now == ' ' || now == '\r') return;
			caseChecker(now);
		}
	}
	
	private static void caseChecker(int now) throws IOException {
		switch(now) {
			case 'c':
				c_case();
				break;
			case 'd':
				d_case();
				break;
			case 's':
				int _s = br.read();
				if(_s == '=') {
					cnt++;
//					System.out.printf("이거 예상 3 %d\n",cnt);
				}else {
					cnt++;
					caseChecker(_s);
				}
				break;
			case 'z':
				int _z = br.read();
				if(_z == '=') {
					cnt++;
				}else {
					cnt++;
					caseChecker(_z);
				}
				break;
			case 'l':
				int _l = br.read();
				if(_l == 'j') {
					cnt++;
//					System.out.printf("이거 예상 1 %d\n",cnt);
				}else {
					cnt++;
					caseChecker(_l);
				}
				break;
			case 'n':
				int _n = br.read();
				if(_n == 'j') {
					cnt++;
//					System.out.printf("이거 예상 4 %d\n",cnt);
				}else {
					cnt++;
					caseChecker(_n);
				}
				break;
			default : 
				cnt++;
//				System.out.printf("이거 예상 2, 5, 6 %d\n",cnt);
		}
	}
	
	private static void c_case() throws IOException {
		int now = br.read();
		if(now == '=' || now == '-')
			cnt++;
		else {
			cnt++;
			caseChecker(now);
		}
	}
	
	private static void d_case() throws IOException {
		int now = br.read();
		if(now == '-') {
			cnt++;
		}else if(now == 'z'){
			int tmp = br.read();
			if(tmp == '=') {
				cnt++;
			}else {
				cnt+=2;
				caseChecker(tmp);
			}
		}else {
			cnt++;
			caseChecker(now);
		}
	}
}
