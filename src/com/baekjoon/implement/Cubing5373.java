package com.baekjoon.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Cubing5373 {
	//윗면은 흰색, 아랫면 노란색, 앞면 빨강, 뒷면 오렌지, 왼쪽면 초록, 오른쪽 파랑
	//위 아래 앞 뒤 왼 오;
	//0 1 2 3 4 5
	static Pannel[] cube;
	static char[] colors = {'w','y','r','o','g','b'};
	
	public static void main(String[] args) throws IOException {
		cube = new Pannel[54];
		for (int i = 0; i < 54; i++) {
			cube[i] = new Pannel(i);
		} // 큐브는 54개의 면을 갖고 있음
		
		Side[] sides = new Side[6];
		for (int i = 0; i < 6; i++) {
			sides[i] = new Side(i);
		} // 6개의 면에 각각 21개 조각이 연결되어 있다.
		
		linkSides(sides);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		//입력 받고 회전하기
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 6; i++) {
			Pannel[][] pennels = sides[i].side;
			sb.append("===================================================================\n");
			for (int j = 0; j < 5; j++) {
				for (int k = 0; k < 5; k++) {
					sb.append(pennels[j][k] == null ? 0 : pennels[j][k].color).append(' ');
				}
				sb.append('\n');
			}
			sb.append("===================================================================\n");
		}
		
		System.out.print(sb);
	}
	
	private static void linkSides(Side[] sides) {
		int cnt = 3;
		
		while(cnt > 0) {
			//윗변과 나머지 변들....
			sides[0].side[0][4-cnt] = sides[3].side[1][cnt];
			sides[3].side[0][cnt] = sides[0].side[1][4-cnt];
			
			sides[0].side[4-cnt][4] = sides[5].side[1][cnt];
			sides[5].side[0][cnt] = sides[0].side[4-cnt][3];
			
			sides[0].side[4][4-cnt] = sides[2].side[1][4-cnt];
			sides[2].side[0][4-cnt] = sides[0].side[3][4-cnt];
			
			sides[0].side[4-cnt][0] = sides[4].side[1][4-cnt];
			sides[4].side[0][4-cnt] = sides[0].side[4-cnt][1];
			
			//아랫변과 나머지 변들...
			sides[1].side[0][4-cnt] = sides[3].side[3][4-cnt];
			sides[3].side[4][4-cnt] = sides[1].side[1][4-cnt];
			
			sides[1].side[4-cnt][4] = sides[4].side[3][4-cnt];
			sides[4].side[4][4-cnt] = sides[3].side[4-cnt][3];
			
			sides[1].side[4][4-cnt] = sides[2].side[3][cnt];
			sides[2].side[4][cnt] = sides[1].side[3][4-cnt];
			
			sides[1].side[4-cnt][0] = sides[5].side[3][cnt];
			sides[5].side[4][cnt] = sides[1].side[4-cnt][1];
			
			//옆변들끼리....
			sides[5].side[4-cnt][4] = sides[3].side[4-cnt][1];
			sides[3].side[4-cnt][0] = sides[5].side[4-cnt][3];
			
			sides[3].side[4-cnt][4] = sides[4].side[4-cnt][1];
			sides[4].side[4-cnt][0] = sides[3].side[4-cnt][3];
			
			sides[4].side[4-cnt][4] = sides[2].side[4-cnt][1];
			sides[2].side[4-cnt][0] = sides[4].side[4-cnt][3];
			
			sides[2].side[4-cnt][4] = sides[5].side[4-cnt][1];
			sides[5].side[4-cnt][0] = sides[2].side[4-cnt][3];
			cnt--;
		}
	}
	
	static class Pannel{
		int r,c;
		int idx;
		char color;
		Pannel(int i){
			idx = i;
		}
	}
	
	static class Side{
		Pannel[][] side;
		
		Side(int now){
			side = new Pannel[5][5];
			int start = now*9;
			for (int i = 1; i <= 3; i++) {
				for (int j = 1; j <= 3; j++) {
					cube[start].color = colors[now];
					side[i][j] = cube[start++];
				}
			}
		}
	}
}
