package com.baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class Tetromino14500 {
	public static void main(String[] args) {
		try {
			new Tetromino14500().solution();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	int[] RC;
	Pair[][] map;
	boolean[][] vis;

	private void solution() throws IOException {
		var br = new BufferedReader(new InputStreamReader(System.in));
		
		//입력
		//0 세로, 1 가로
		RC = Stream.of(br.readLine().split(" ")).mapToInt(string -> Integer.parseInt(string)).toArray();
		
		map = new Pair[RC[0]][RC[1]];
		
		String[] tmp;
		for (int i = 0; i < RC[0]; i++) {
			tmp = br.readLine().split(" ");
			for (int j = 0; j < RC[1]; j++) {
				map[i][j] = new Pair(i,j, Integer.parseInt(tmp[j]));
			}
		}
		
		vis = new boolean[RC[0]][RC[1]];
		
		//만들어지는 도형은 4번 확장해서 형성할 수 있는 모든 경우의 수임
		//ㄱㄱ
		for (int i = 0; i < RC[0]; i++) {
			for (int j = 0; j < RC[1]; j++) {
				vis[i][j] = true;
				myList[0] = map[i][j];
				
				dfs(i, j, 1);
			}
		}
		
		System.out.println(ans);
	}
	
	//답
	int ans = 0;
	
	int[] dr = {1,-1,0,0};
	int[] dc = {0,0,-1,1};
	
	//들어갈 수 있는 예비 리스트
	Pair[] adjList = new Pair[8];
	int size = 0;
	
	//현재 색칠한 부분
	Pair[] myList = new Pair[4];
	
	private void dfs(int row, int col, int num) {
		if(num == 4) {
			int sum = 0;
			for (int i = 0; i < 4; i++) {
				sum += myList[i].value;
			}
			ans = Math.max(ans, sum);
			return;
		}
		
		//인접리스트의 시작 사이즈
		int nowSize = size;
		
		//adjList에 추가하기
		for (int i = 0; i < 4; i++) {
			int rr = row + dr[i];
			int rc = col + dc[i];
			
			if(rr < 0 || rc < 0 || rr >= RC[0] || rc >= RC[1] || vis[rr][rc] || 
					isContain(map[rr][rc], num, true) || isContain(map[rr][rc], size, false)) 
				continue;
			
//			System.out.println(Arrays.toString(myList));
//			System.out.println(Arrays.toString(adjList));
			
			adjList[size] = map[rr][rc];
			size++;
		}
		
		int entireSize = size;
		
		//어디로 가실
		for (int i = 0; i < entireSize; i++) {
			myList[num] = adjList[i];
			adjList[i] = adjList[entireSize-1];
			size--;
			
			dfs(myList[num].r, myList[num].c, num + 1);
			
			size = entireSize;
			adjList[entireSize-1] = adjList[i];
			adjList[i] = myList[num];
		}
		
		//사이즈 되돌리고 빠꾸
		size = nowSize;
	}
	
	private boolean isContain(Pair now, int num, boolean flag) {
		
		for (int i = 0; i < num; i++) {
			if( flag && myList[i].equals(now) ) {
				return true;
			}
			if( !flag && adjList[i].equals(now)) {
				return true;
			}
		}
		return false;
	}

	private class Pair {
		int r, c, value;

		public Pair(int r, int c, int value) {
			super();
			this.r = r;
			this.c = c;
			this.value = value;
		}

		@Override
		public String toString() {
			return "Pair [r=" + r + ", c=" + c + ", value=" + value + "]";
		}
	}
}
