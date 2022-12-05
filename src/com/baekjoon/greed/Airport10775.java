package com.baekjoon.greed;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
	틀린 이유
	
	1. 시간 초과
	->  10^5가 10^5번 입력으로 주어진다면
		시간은 1 2 3 4 5 .. 10^5가 될것이다
	
	-> (1 + 10^5) * 10^5 / 2


*/
public class Airport10775 {
	public static void main(String[] args) {
		try {
			new Airport10775().solution();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void solution() throws IOException {
		var br = new BufferedReader(new InputStreamReader(System.in));
		var G = Integer.parseInt(br.readLine());
		var P = Integer.parseInt(br.readLine());
		
		int[] gate = new int[G + 1];
		for (int i = 0; i <= G; i++) {
			gate[i] = i;
		}
		
		//1~ g1 사이에 놓을 수 있으니까 아마 제일 g1에 가깝게 놓는게
		//최대한 많은 비행기를 넣는 방법이 아닐까
		int g1;
		var cnt = 0;
		while(P-- > 0) {
			g1 = Integer.parseInt(br.readLine());
			
			while(gate[gate[g1]] != gate[g1]) {
				gate[g1]--;
			}
			
			if(gate[gate[g1]] == 0)
				break;
			else {
				gate[gate[g1]]--;
			}
			
			cnt++;
		}
		
		System.out.println(cnt);
	}
}
