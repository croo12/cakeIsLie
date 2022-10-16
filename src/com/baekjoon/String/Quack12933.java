package com.baekjoon.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Quack12933 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		int len = S.length();
		int[] quacks = new int[5];
		
		//quack을 카운트 배열로 세기
		//앞에 칸보다 숫자가 더 커지면 순서가 뭔가 잘못 된것
		//그리고 마지막칸 숫자 출력하면 됨 <- X
		
		//아니 오리가 다 말하면 또 울 수 있음
		//다 운 오리를 체크해야함
		//다 운 오리가 있는데 q가 나온다는건 그 오리가 말하는게 분명함!!
		
		//그리고 아마 quack이 온전해야할듯
		
		int duck = 0;
		int newbie = 0;

		int idx = 0;
		boolean flag = true;
		while(flag && idx < len) {
			int now = -1;
			
			switch(S.charAt(idx++)) {
			case 'q':
				now = 0;
				if(duck != 0)
					duck--;
				else 
					newbie++;
				break;
			case 'u':
				now = 1;
				break;
			case 'a':
				now = 2;
				break;
			case 'c':
				now = 3;
				break;
			case 'k':
				now = 4;
				break;
			}
			quacks[now]++;
			if(now != 0 && quacks[now] > quacks[now-1])
				flag = false;
			
			if(now == 4)
				duck++;
		}
		
		if(flag && quacks[0] == quacks[4])
			System.out.println(newbie);
		else
			System.out.println(-1);
	}
}
