package com.swea.d3;

import java.util.Scanner;

public class PerfectShuffle {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int n = sc.nextInt();
			String[] ss = new String[n];
			int cnt = n;
			int idx = -2;
			while(cnt-- > 0) {
				idx+=2;
				if(idx%2 == 0) {
					ss[idx] = sc.next();
					if(idx+2 >= n)
						idx = -1;
				}else
					ss[idx] = sc.next();
			}
			sb.append("#").append(tc);
			while(++cnt < n) {
				sb.append(" ").append(ss[cnt]);
			}
			System.out.println(sb);
			sb.setLength(0);
		}
		sc.close();
	}
}
