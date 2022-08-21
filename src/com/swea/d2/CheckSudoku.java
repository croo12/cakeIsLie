package com.swea.d2;

import java.util.Scanner;

public class CheckSudoku { // 클래스 이름을 Solution으로 바꿔야 한다.

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			System.out.print("#"+test_case+" ");
			int[][] sudoku = new int[9][9];
			
			System.out.println(sudoku);
			
			System.out.println();
		}
		sc.close();
	}
	
	public static boolean check(int[] row) {
		return true;
	} 
}
