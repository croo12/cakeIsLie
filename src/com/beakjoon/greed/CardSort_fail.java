package com.beakjoon.greed;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CardSort_fail {
	
	static int sum;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] cards = new int[n];
		
		for (int i = 0; i < n; i++) {
			cards[i] = Integer.parseInt(br.readLine()); 
		}
		
		SumDude(cards, n);
		
		System.out.println(sum);
	}
	
	private static void SumDude(int[] cards, int n) {
		
		int card = 0;
		for(int t =0; t < 2; t++) {
			int min = 100000001;
			int cnt = 0;
			for (int i = 0; i < n; i++) {
				if(cards[i] < 100000001 && cards[i] < min) {
					min = cards[i];
					cnt = i;
				}
			}
			
			card += min;
			if(min == 1001)
				return;
			else if(t == 0)
				cards[cnt] = 100000001;
			else {
				sum += card;
				cards[cnt] = card;
				SumDude(cards, n);
			}	
		}
	}
}
