package com.baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class NumberOfIslands4964WithBitMask {
	public static void main(String[] args) throws IOException {
		String input = randomInputMaker(1);
		System.out.print(input);
		BufferedReader br = new BufferedReader(
				new InputStreamReader(
				System.in
//				new ByteArrayInputStream(input.getBytes())
				)
		);
		StringTokenizer st;
		int[] rx = { 0, 0, 1, 1, 1, -1, -1, -1 };
		int[] ry = { 1, -1, 0, 1, -1, 0, 1, -1 };
		
		StringBuilder sb = new StringBuilder();
		
		while (true) {
			st = new StringTokenizer(br.readLine());
			int width = Integer.parseInt(st.nextToken());
			int height = Integer.parseInt(st.nextToken());

			if (width == 0 && height == 0)
				break;
			
			long[] map = new long[height]; // 1 << (width - 1)
			
			for (int i = 0; i < height; i++) {
				String[] s = br.readLine().split(" ");
				for (int j = 0; j < width; j++) {
					map[i] = map[i] * 2 + Integer.parseInt(s[j]);
				}
			}
			
//			for (int i = 0; i < height; i++) {
//				System.out.println(Long.toBinaryString(visited[i]));
//			}
			
			long widthZero = 1L << (width - 1);

			Queue<IslandPair> q = new LinkedList<>();
			
			int cnt = 0;

			for (int i = 0; i < height; i++) {
				for (int j = 0; j < width; j++) {
					
					long checker = widthZero >> j;
				
					if ((map[i] & checker) != 0){
						q.add(new IslandPair(j, i));
						map[i] -= checker;
						cnt++;
						while (!q.isEmpty()) {
							IslandPair now = q.poll();

							for (int k = 0; k < 8; k++) {
								int nextX = now.x + rx[k];
								int nextY = now.y + ry[k];
								
								if (nextX < 0 || nextY < 0 || nextX >= width || nextY >= height)
									continue;
								
								long moveChecker = widthZero >> nextX;
							
								if ((map[nextY] & moveChecker) != 0) {
									q.add(new IslandPair(nextX, nextY));
									map[nextY] -= moveChecker;
								}
							}
						}
					}
				}
			}
			
//			for (int i = 0; i < height; i++) {
//				System.out.println(Long.toBinaryString(map[i]));
//			}

			sb.append(cnt).append('\n');
		}
		
		System.out.print(sb);
	}

	static class IslandPair {
		int x;
		int y;

		public IslandPair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static String randomInputMaker(int n) {
		StringBuilder sb = new StringBuilder();
		while(n-- > 0) {
			int height = (int)( Math.random() * 49 + 1);
			int width = (int)( Math.random() * 49 + 1);
			sb.append(width).append(' ').append(height).append('\n');
			
			for (int i = 0; i < height; i++) {
				for (int j = 0; j < width; j++) {
					sb.append(Math.round(Math.random())).append(' ');
				}
				sb.append('\n');
			}
		}
		sb.append("0 0\n");
		return sb.toString();
	}
}
