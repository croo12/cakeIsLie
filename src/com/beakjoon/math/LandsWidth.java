package com.beakjoon.math;

import java.util.Scanner;

public class LandsWidth {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] cnt = new int[5];
		int k = sc.nextInt();
		int w = 0;
		int h = 0;
		
		int l1 = 0;
		int l2 = 0;
		
		int last = 0;
		
		Line[] square = new Line[6];
		
		int start = -1;
		
		for (int i = 0; i < 6; i++) {
			int dir = sc.nextInt();
			int num = sc.nextInt();

			if (dir <= 2) {
				if(num > h) {
					h = num;
					start = i;
				}	
			}else
				w = Math.max(num, w);

			square[i] = new Line(dir, num);
			
		}
	
//		for (int i = 0; i < 6; i++) {
//			System.out.print("[ "+square[i].dir + " ");
//			System.out.println(square[i].num+" ]");
//		}
//		
//		System.out.println("최대값 : " + start);
		
		for (int i = start; i < start+6; i++) {
			int num = square[i%6].num;
			int dir = square[i%6].dir;
			
			cnt[dir]++;
			
			if (cnt[dir] == 2) {
				l1 = num;
				l2 = last;
				break;
			}
			
			last = num;
		}

		System.out.println(k * (w * h - l1 * l2));
		sc.close();
	}
	
	static class Line{
		int dir;
		int num;
		public Line(int dir, int num) {
			this.dir = dir;
			this.num = num;
		}
	}
}
