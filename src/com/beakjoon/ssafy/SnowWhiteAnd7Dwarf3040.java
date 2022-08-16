package com.beakjoon.ssafy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SnowWhiteAnd7Dwarf3040 {
	static List<Integer> list;
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		list = new ArrayList<>();
		
		int sum=0;
		for (int i = 0; i < 9; i++) {
			int now = sc.nextInt();
			list.add(now);
			sum+=now;
		}
		
		sum = sum - 100;
		
		searchSpy(sum);
		
		for (int i = 0; i < 7; i++) {
			System.out.println(list.get(i));
		}
	}
	
	private static void searchSpy(int sum) {
		for (int i = 0; i < 8; i++) {
			for (int j = i+1; j < 9; j++) {
				if(list.get(i) + list.get(j) == sum) {
					list.remove(j);
					list.remove(i);
					return;
				}
			}
		}
	}
}
