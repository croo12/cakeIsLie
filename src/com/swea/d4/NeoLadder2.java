package com.swea.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class NeoLadder2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[][] ladder;
	static int y;
	
	public static void main(String[] args) throws IOException{
		
		for (int tc = 1; tc <= 10; tc++) {
			br.readLine();
			StringTokenizer st;
			ladder = new int[102][100];
			y= 99;
			
			ArrayList<Integer> list = new ArrayList<>();
			int result = -1;
			
			for (int j = 0; j < 100; j++) {
				st = new StringTokenizer(br.readLine());
				for (int i = 1; i < 101; i++) {
					ladder[i][j] = Integer.parseInt(st.nextToken());
					if(j==99 && ladder[i][j] != 0) {
						list.add(i);
						if(ladder[i][j] == 2)
							result = list.size()-1;
					}
				}
			}
			
			int idx = result;
			
			while(y != 0) {
				if(ladder[list.get(idx)-1][y] == 0 && ladder[list.get(idx)+1][y] == 0 )
					y--;
				else if(ladder[list.get(idx)-1][y] == 1) {
					idx -= 1;
					y--;
				}else if(ladder[list.get(idx)+1][y] == 1) {
					idx += 1;
					y--;
				}
			}
			System.out.printf("#%d %d\n",tc, list.get(idx)-1);
		}
	}
}
