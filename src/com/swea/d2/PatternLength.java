package com.swea.d2;

import java.util.Scanner;

public class PatternLength {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++) {
			System.out.print("#"+test_case+" ");
			
			String s = sc.next();
			String[] ss = s.split("");
			
			int result = search_first(ss);
			if(result > 0) {
				System.out.println(result);
			}else {
				System.out.println("패턴을 찾는데 실패했습니다");
			}
			
		}
		sc.close();
	}
	
	public static int search_first(String[] ss) {
		boolean flag = false;
		for (int i = 1; i < ss.length; i++) {
			if(ss[0].equals(ss[i])) {
				flag = check(ss,i);
				if(flag) {
					return i;
				}
			}
		}
		return 0;
	}
	
	public static boolean check(String[] ss, int n) {
		for (int j = 0; j < n; j++) {
			if(!ss[j].equals(ss[j+n])) {
				return false;
			}
		}
		return true;
	}
}
