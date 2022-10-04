package com.baekjoon.SMUPC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SMUPC_calculator21737 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int sum = 0;

		int[] saver = new int[2 * N];
		// 짝수칸에는 숫자 홀수칸에는 연산자(아스키 넘버로)가 들어가는 배열 
		// 연산자가 C였다면 그 뒤에는 0이 들어감
		// 마지막 연산자 뒤에는 숫자가 없다 실제로 없으니까
		// 넣는게 어렵지 그 뒤로는 그냥 계산하면 됨

		int idx = 0;
		int cnt = 0;
		
		//연산자 N개 받는 순간 탈출
		while (cnt != N) {
			int now = br.read();
			
			//연산자임?
			if (now == 'S' || now == 'M' || now == 'U' || now == 'P' || now == 'C') {
				cnt++;
				
				//일단 숫자를 넣고, 초기화함
				saver[idx] = sum;
				sum = 0;
				idx++;
				
				//다음칸에는 연산자를 넣음
				saver[idx] = now;
				idx++;

			} else {
				//숫자 저장용
				sum = sum * 10 + now - '0';
			}
		}

		//현재 값을 저장할 변수
		int calc = saver[0];
		//출력 저장용
		StringBuilder sb = new StringBuilder();
		//출력했는지 체크용
		boolean flag = false;
		
		//마지막 연산자 전까지
		for (int i = 1; i < 2 * N - 1; i += 2) {

			switch (saver[i]) {
			case 'S':
				calc = calc - saver[i + 1];
				break;
			case 'M':
				calc = calc * saver[i + 1];
				break;
			case 'U':
				calc = calc / saver[i + 1];
				break;
			case 'P':
				calc = calc + saver[i + 1];
				break;
			case 'C':
				sb.append(calc).append(' ');
				flag = true;
				break;
			}
		}
		//마지막 연산자가 C인 경우. (나머지는 모두 의미 없음)
		if (saver[2 * N - 1] == 'C') {
			sb.append(calc).append(' ');
			flag = true;
		}
		
		
		if (flag)
			System.out.println(sb);
		else
			System.out.println("NO OUTPUT");
	}
}
