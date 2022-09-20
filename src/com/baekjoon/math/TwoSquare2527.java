package com.baekjoon.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TwoSquare2527 {

	static Square sq1, sq2;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		for (int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine());
			sq1 = new Square(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			sq2 = new Square(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

			int x = xIsMeet();
			int y = yIsMeet();

			if (x * y == 0)
				sb.append("d");
			else if (x * y == 1)
				sb.append("c");
			else if (x == 1 || y == 1)
				sb.append("b");
			else
				sb.append("a");
			sb.append("\n");
		}
		System.out.print(sb);
	}

	// 0 : 안만남 // 1 : 딱 만남 // 2: 겹침
	private static int xIsMeet() {
		if (sq1.minX > sq2.maxX || sq2.minX > sq1.maxX)
			return 0;
		else if (sq1.minX == sq2.maxX || sq2.minX == sq1.maxX)
			return 1;
		else
			return 2;
	}

	private static int yIsMeet() {
		if (sq1.minY > sq2.maxY || sq2.minY > sq1.maxY)
			return 0;
		else if (sq1.minY == sq2.maxY || sq2.minY == sq1.maxY)
			return 1;
		else
			return 2;
	}

	static class Square {
		int maxY;
		int maxX;
		int minY;
		int minX;

		public Square(int minX, int minY, int maxX, int maxY) {
			this.minX = minX;
			this.minY = minY;
			this.maxX = maxX;
			this.maxY = maxY;
		}
	}
}
