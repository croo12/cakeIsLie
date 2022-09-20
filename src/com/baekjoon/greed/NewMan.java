package com.baekjoon.greed;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class NewMan {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < T; tc++) {
			int n = Integer.parseInt(br.readLine());
			
			int[][] men = new int[n][2];
			
			for (int i = 0; i < n; i++) {
				String s = br.readLine();
				StringTokenizer st = new StringTokenizer(s);
				men[i][0] = Integer.parseInt(st.nextToken());
				men[i][1] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(men, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					return o1[0] - o2[0];
				}
			});
			
			int min = men[0][1];
			int getIn = 1;
			for (int i = 1; i < n; i++) {
				if(min > men[i][1]) {
					getIn++;
					min = men[i][1];
				}
			}
			System.out.println(getIn);
		}
	}
}
