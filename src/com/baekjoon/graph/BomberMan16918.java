package com.baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BomberMan16918 {
	//틀린이유
	//1. O를 0이라고 씀
	//2. 처음 주어진 모양으로 다시 돌아오지 않는 경우가 있다는 것을 간과함
	//3. 구현과정을 대충해서 4n - 1의 경우 모양이 제대로 형성되지 않음
	//4. 복붙하고 조건문 안바꿈
	public static void main(String[] args) throws IOException{
//		String ss = input();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(
				System.in
//				new ByteArrayInputStream(ss.getBytes())
				));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken()),C = Integer.parseInt(st.nextToken()),N = Integer.parseInt(st.nextToken());
		
		// r * c 격차판의 초기상태에서 n초가 지난 후 상태 출력
		// r, c, n <= 200 ; 2초
		// 4000칸짜리 2차원 배열을 200번 순회하면 800000번, 200번 정도?
		// 그냥 계속 순회해서 풀 수 있을 듯
		
		// 하지만 예시를 보자
		// 0. 일부 칸에 폭탄 설치
		// 1. 작동 X -----------1 초
		// 2. 빈칸에 폭탄 설치-----2 초
		// 3. 폭탄 터짐----------3 초
		// 2. 빈칸에 폭탄 설치-----4 초
		// 3. 폭탄 터짐----------5 초
		// 2. 빈칸에 폭탄 설치-----6 초
		// 3. 폭탄 터짐----------7 초
		
		// 이렇게 감
		// 즉 짝수일때는 항상 꽉차있음
		
		// 홀수 일떄는 ? 
		// 1 -> 초기상태
		// 3 -> 1의 상태 + 4방은 비어있는 상태, 나머지는 폭탄 -> 꽉찬상태 - (초기상태 + 4방)
		// 5 -> 3의 상태 + 4방은 비어있는 상태, 나머지는 폭탄 -> 꽉찬상태 - (3의 상태 + 4방)
		// 7 -> 5의 상태 + 4방은 비어있는 상태, 나머지는 폭탄 -> 꽉찬상태 - (초기상태 + 4방)
		// . . . 
		
		// 즉 초기상태의 4방은 홀수인 경우 언제나 빈칸임
		// 나머지는 반전을 반복함
		
		// 틀렸다. 위의 가정이 틀렸음
		// 3부터는 같은 모양 두개가 반복되지만 1은 특이한 형태일 수 있음.
		
		StringBuilder sb = new StringBuilder();
		
		if(N%2 == 0)
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					sb.append('O');
				}
				sb.append('\n');
			}
		else if (N == 1)
			for (int i = 0; i < R; i++) {
				sb.append(br.readLine()).append('\n');
			}
		else {
			//여기까지 오면 결국 변환해보는 수밖에 없다
			//아마도...
			
			int[][] arr = new int[R][C];
			int[][] dxy = {{1,0},{-1,0},{0,1},{0,-1}};
			
			for (int i = 0; i < R; i++) {
				String s = br.readLine();
				for (int j = 0; j < C; j++) {
					char c = s.charAt(j);
					if(c == 'O') {
						arr[i][j] = 1;
						for (int k = 0; k < 4; k++) {
							int rr = i + dxy[k][0];
							int rc = j + dxy[k][1];
							if(rr < R && rc < C && rr >= 0 && rc >=0 && arr[rr][rc] == 0)
								arr[rr][rc] = 1;
						}
					}
				}
			}
			//여기 남은 0이 4n - 1의 모습이다
			
			if((N-1)%4 == 0) {
				for (int i = 0; i < R; i++) {
					for (int j = 0; j < C; j++) {
						if(arr[i][j] == 0) {
							for (int k = 0; k < 4; k++) {
								int rr = i + dxy[k][0];
								int rc = j + dxy[k][1];
								if(rr < R && rc < C && rr >= 0 && rc >=0 && arr[rr][rc] == 1)
									arr[rr][rc] = 2;
							}
						}
					}
				}
				//여기서 남은 1들이 4n + 1임
				
				for (int i = 0; i < R; i++) {
					for (int j = 0; j < C; j++) {
						if(arr[i][j] != 1)
							sb.append('.');
						else
							sb.append('O');
					}
					sb.append('\n');
				}
			}
			else 
				for (int i = 0; i < R; i++) {
					for (int j = 0; j < C; j++) {
						if(arr[i][j] != 0)
							sb.append('.');
						else
							sb.append('O');
					}
					sb.append('\n');
				}
			
		}
		
		System.out.print(sb);
	}
	
//	static String input() {
//		StringBuilder sb = new StringBuilder();
//		int r = (int)(Math.random() * 30) + 1;
//		int c = (int)(Math.random() * 30) + 1;
//		int n = (int)(Math.random() * 199) + 1;
//		
//		sb.append(r).append(' ').append(c).append(' ').append(n).append('\n');
//		
//		for (int i = 0; i < r; i++) {
//			for (int j = 0; j < c; j++) {
//				sb.append(Math.round(Math.random()) == 1 ? 'O' : '.');
//			}
//			sb.append('\n');
//		}
//		return sb.toString();
//	}
}
