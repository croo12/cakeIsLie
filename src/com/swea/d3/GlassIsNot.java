package com.swea.d3;

import java.util.Scanner;

public class GlassIsNot {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			char[] word1 = sc.next().toCharArray();
			char[] word2 = sc.next().toCharArray();
			
			boolean flag = true;
			
			if(word1.length != word2.length)
				flag = false;
			
			if(flag)
				for (int i = 0; i < word1.length; i++) {
					if(KKsEye(word1[i])!=KKsEye(word2[i]))
						flag = false;
				}
			
			if(flag) System.out.printf("#%d SAME\n",tc);
			else System.out.printf("#%d DIFF\n",tc);
		}
		sc.close();
	}
	
	private static int KKsEye(char c) {
		if (c == 'B')
			return 2;
		if (c == 'A'||c == 'O'||c == 'P'||c == 'D'||c == 'Q'||c == 'R')
			return 1;
		return 3;
	}
}
