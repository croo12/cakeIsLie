package com.baekjoon.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RollCake3985 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int L = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		
		boolean[] cakes = new boolean[L+1];
		
		StringTokenizer st;
		
		int biggestDreamer = -1;
		int dream = 0;
		
		int biggestEater = -1;
		int max = 0;
		
		int start, end;
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			
			start = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());
			
			if(end - start +1 > dream) {
				dream = end - start +1;
				biggestDreamer = i;
			}
			
			int tmp = 0;
			for (int j = start; j <= end; j++) {
				if(!cakes[j]) {
					cakes[j] = true;
					tmp++;
				}
			}
			
			if(tmp > max) {
				max = tmp;
				biggestEater = i;
			}
		}
		
		System.out.printf("%d\n%d\n",biggestDreamer,biggestEater);
	}
}
