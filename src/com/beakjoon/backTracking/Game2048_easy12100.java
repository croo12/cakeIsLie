package com.beakjoon.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Game2048_easy12100 {

	static int N;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		StringTokenizer st;
		int now;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				now = Integer.parseInt(st.nextToken());
				arr[i][j] = now;
			}
		}

		backT(0);

		System.out.println(max);
	}

	static int max = 0;
	static int[] dirs = new int[5];
	static int[][] proto;

	static void backT(int depth) {
		if (depth == 5) {
			proto = new int[N][];
			for (int i = 0; i < N; i++) {
				proto[i] = arr[i].clone();
			}

			for (int i = 0; i < 5; i++) {
				move(dirs[i]);
			}

			for (int[] is : proto)
				for (int i : is)
					max = Math.max(max, i);

			return;
		}

		for (int i = 0; i < 4; i++) {
			dirs[depth] = i;
			backT(depth + 1);
			dirs[depth] = 0;
		}
	}

	static Stack<Integer> stk = new Stack<>();
	static Stack<Integer> re = new Stack<>();

	static void move(int dir) {
		int now;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				switch(dir) {
				case 0:
					offerStk(j,i);
					break;
				case 1:
					offerStk(N-j-1,i);
					break;
				case 2:
					offerStk(i,j);
					break;
				case 3:
					offerStk(i,N-j-1);
					break;
				}
			}
			
			if(!stk.isEmpty())
				re.push(stk.pop());
			
			while(!stk.isEmpty()) {
				now = stk.pop();
				if(now == re.peek()) {
					re.push(re.pop() + now);
					if(!stk.isEmpty())
						re.push(stk.pop());
				}else {
					re.push(now);
				}
			}
			
			while(!re.isEmpty()) {
				int size = re.size();
				switch(dir) {
				case 0:
					proto[i][N-size] = re.pop();
					break;
				case 1:
					proto[i][size-1] = re.pop();
					break;
				case 2:
					proto[N-size][i] = re.pop();
					break;
				case 3:
					proto[size-1][i] = re.pop();
				}
			}
		}
	}

	static void offerStk(int x, int y) {
		int now;
			now = proto[y][x];
			if (now != 0) {
				proto[y][x] = 0;
				stk.push(now);
			}
	}
}
