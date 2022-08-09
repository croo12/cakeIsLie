package com.swea.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class CompositionBoardNumbers { // 클래스 이름을 Solution으로 바꿔야 한다.
	
	static HashSet<String> set;
	static int N;
	
	static int[][] arr;
	static String[] str = new String[7];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		N = 4;
		for (int test_case = 1; test_case <= T; test_case++) { // testcase 시작
			arr = new int[N][N]; // 배열크기 (항상 4임)
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int now = br.read();
					if(now == ' ' || now == '\n' || now == '\r') {
						j--;
					}else {
						arr[i][j] = now - '0';
					}
				}
			}// 배열을 입력받는 부분
			
			br.readLine();
			
			set = new HashSet<>();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					bSearch(i,j,0);
				}
			}
			
			System.out.print("#"+test_case+" ");
			System.out.println(set.size());
		}
	}
	
	private static void bSearch(int i, int j, int x) {

		int[] dx = {1,-1,0,0};
		int[] dy = {0,0,1,-1};
		
		str[x] = ""+arr[i][j];
		
		if(x < 6) {
			for(int k = 0; k < 4; k++) {
				if((i+dx[k]) >=0 && (j+dy[k]) >=0 && (i+dx[k]) < N && (j+dy[k]) < N) {
					bSearch(i+dx[k],j+dy[k],x+1);
				}
			}
		}else {
			String result="";
			for(String s : str) result+=s;
			set.add(result);
			return;
		}
	}
}
