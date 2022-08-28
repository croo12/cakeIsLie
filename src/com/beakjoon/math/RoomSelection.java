package com.beakjoon.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RoomSelection {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[][] count = new int [2][7];
		
		while(n-- > 0) {
			st= new StringTokenizer(br.readLine());
			count[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())]++;
		}
		int sum = 0;
		int now;
		for (int i = 0; i < 2; i++) {
			for (int j = 1; j <= 6; j++) {
				
				if((now = count[i][j]) != 0)
					if(now % k == 0) {
						sum += now/k;
					}else {
						sum += now/k+1;
					}
			}
		}
		System.out.println(sum);
	}
}
