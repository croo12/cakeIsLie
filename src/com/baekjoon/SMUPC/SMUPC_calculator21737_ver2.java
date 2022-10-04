package com.baekjoon.SMUPC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SMUPC_calculator21737_ver2 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());

		int[] numbers = new int[N];
		char[] operators = new char[N];

		// 연산자 배열과 숫자배열 idx
//		int oIdx = 0;
		int nIdx = 0;
		int idx = 0;

		// 연산자 N개 받으면 while문 탈출
		int cnt = 0;

		// 숫자 저장용
		int sum = 0;

		// 이제 입력 받는다
		while (cnt != N) {
			// 이제부터 하나씩 읽는다
			int now = br.read();

			if (now == 'S' || now == 'M' || now == 'U' || now == 'P' || now == 'C') {
				// 연산자인 경우

				// 탈출조건 조절
				cnt++;

				// 여태까지 들어온 숫자를 저장
				numbers[idx] = sum;
				// 연산자도 저장
				operators[idx] = (char) now;

				idx++;
				sum = 0;
			} else {
				// 연산자 아닌 경우 (숫자임)
				sum = sum * 10 + now - '0';
			}
		}

		// System.out.println(Arrays.toString(saver));

		StringBuilder sb = new StringBuilder();
		int calc = numbers[0];
		
//		int nIdx = 1;
		boolean flag = false;
		cnt = 0;
		for (int i = 0; i < N-1; i++) {
			switch (operators[i]) {
			case 'S':
				calc = calc - numbers[nIdx++];
				break;
			case 'M':
				calc = calc * numbers[nIdx++];
				break;
			case 'U':
				calc = calc / numbers[nIdx++];
				break;
			case 'P':
				calc = calc + numbers[nIdx++];
				break;
			case 'C':
				sb.append(calc).append(' ');
				flag = true;
				break;
			}
		}
		if(operators[N-1] == 'C') {
			sb.append(calc).append(' ');
			flag = true;
		}
		
		if(flag)
			System.out.println(sb);
		else
			System.out.println("NO OUTPUT");
	}

}
