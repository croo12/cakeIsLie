package com.swea.d2;

import java.util.Scanner;

public class Snail { //PASS
	
	static int flag =0; // 0:우 // 1:하// 2:좌// 3:상
	static int num = 1;
	static int last_num = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++) {
			System.out.println("#"+test_case);
			int N = sc.nextInt();
			num = 1;
			last_num = N*N;
			int[][] snail = new int[N][N];
			snail[0][0] = 1;
			snail = fill_snail(snail,N,0);
			
			if(N%2==1)
				snail[N/2][N/2] = last_num;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(snail[i][j]+" ");
				}
				System.out.println();
			}
			
		}
		sc.close();
	}
	
	private static int[][] fill_snail(int[][] snail, int N,int start) {
//		int width = N;
//		int height = N;
		
		int row = start;
		int col = start;
		
		if(start <= N) {
			do{
				for(int i=start; i<N; i++) {
					switch(flag%4) {
						case 0:
							if(i != N-1&&num <= last_num)
								snail[row][col] = num++;
							if(i != N-1)
								col++;
							break;
						case 1:
							if(i != N-1&&num <= last_num)
								snail[row][col] = num++;
							if(i != N-1)
								row++;
							break;
						case 2:
							if(i != N-1&&num <= last_num)
								snail[row][col] = num++;
							if(i != N-1)
								col--;
							break;
						case 3:
							if(i != N-1 && num <= last_num)
								snail[row][col] = num++;
							if(i != N-1)
								row--;
							break;
					}
				}
				flag++;
			}while(flag%4 !=0);
			return fill_snail(snail, N-1, start+1);
		}else {
			return snail;
		}
	}
}
