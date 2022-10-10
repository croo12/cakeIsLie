package com.baekjoon.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Gear14891 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Gear[] gears = new Gear[5];
		for (int i = 1; i <= 4; i++) {
			gears[i] = new Gear(br.readLine());
		}
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		//n번 톱니가 움직이려면 현재 톱니에 맞춰 왼쪽과 오른쪽 톱니가 먼저 움직여야함
		//왼쪽과 오른쪽 톱니가 움직여야 한다면 그 왼쪽과 오른쪽 톱니가 먼저 움직여야함
		//왼쪽 체크를 하려면 왼쪽 체크 true -> 그 왼쪽 체크 ...
		//             왼쪽 체크 false -> 나 회전... 이런 식이다
		
		//왼쪽과 오른쪽을 체크할 것. -> 체크가 성공하면 한칸 더가서 체크하기
		//true인건 회전시키기
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			//1 = top-- //-1 = top++;
			int dir = Integer.parseInt(st.nextToken());
			boolean[] check = new boolean[5];
			check[num] = true;
		
			
			
			//왼쪽 체크
			int tmp = num;
			while(tmp != 1) {
				Gear now = gears[tmp];
				Gear left = gears[tmp - 1];
				if(now.ns[(now.top-2)%8] != left.ns[(left.top+2)%8]) {
					check[tmp-1] = true;
					tmp--;
				}else {
					break;
				}
			}
			
			for (int j = 1; j < 4; j++) {
				if(num - j > 0 && check[num - j]) {
					if(j%2 == 0) {
						gears[num-j].top -= dir;
					}else {
						gears[num-j].top += dir;
					}
				}else
					break;
			}
			
			//오른쪽 체크
			tmp = num;
			while(tmp != 4) {
				Gear now = gears[tmp];
				Gear right = gears[tmp + 1];
				if(now.ns[(now.top+2)%8] != right.ns[(right.top-2)%8]) {
					check[tmp+1] = true;
					tmp++;
				}else {
					break;
				}
			}
			
			for (int j = 0; j < 4; j++) {
				if(num + j < 5 && check[num + j]) {
					if(j%2 == 0) {
						gears[num+j].top -= dir;
					}else {
						gears[num+j].top += dir;
					}
				}else
					break;
			}
		}
		
		int sum = 0;
		for (int i = 1; i <= 4; i++) {
//			System.out.println(gears[i].top);
			if(gears[i].ns[gears[i].top%8]) {
				sum += 1 << (i-1);
			}
		}
		System.out.println(sum);
	}
	
	static class Gear{
		boolean[] ns;
		int top;
		Gear(String s){
			ns = new boolean[8];
			top = 160;
			for (int i = 0; i < 8; i++) {
				ns[i] = s.charAt(i) == '1';
			}
		}
	}
}