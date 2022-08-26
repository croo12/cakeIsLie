package com.swea.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CheckSudoku { // 클래스 이름을 Solution으로 바꿔야 한다.

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			
			int[][] sudoku = new int[9][9];
			
			boolean flag = false;
			
			for (int i = 0; i < 9; i++) {
				String[] line = br.readLine().split(" ");
				for (int j = 0; j < 9; j++) {
					sudoku[i][j] = Integer.parseInt(line[j]);
				}
			}
			
			Loop1 : for (int i = 0; i < 9; i++) {
				boolean[] checker = new boolean[10];
				for (int j = 0; j < 9; j++) {
					if(!checker[sudoku[i][j]])
						checker[sudoku[i][j]] = true;
					else {
						flag = true;
						break Loop1;
					}	
				}
			}
			
			if(!flag)
				Loop2 : for (int i = 0; i < 9; i++) {
					boolean[] checker = new boolean[10];
					for (int j = 0; j < 9; j++) {
						if(!checker[sudoku[j][i]])
							checker[sudoku[j][i]] = true;
						else {
							flag = true;
							break Loop2;
						}
					}
				}
			
			if(!flag)
				Loop3 : for (int i = 0; i < 9; i+=3) {
					for (int j = 0; j < 9; j+=3) {
						boolean[] checker = new boolean[10];
						for (int k = i; k < i+3; k++) {
							for (int l = j; l < j+3; l++) {
								if(!checker[sudoku[k][l]]) 
									checker[sudoku[k][l]] = true;
								else {
									flag = true;
									break Loop3;
								}
							}
						}
					}
				}
			
			System.out.print("#"+test_case+" ");
			if(flag) System.out.println(0);
			else System.out.println(1);
		}
	}
}
