package com.baekjoon.greed;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Ramp1034 {
	public static void main(String[] args) {
		try {
			new Ramp1034().solution();
		}catch (Exception e){
			e.printStackTrace();
		}
	}

	int max = 0;
	int R,C,K;
	Map<Long, Integer> map = new HashMap<>();
	private void solution() throws IOException {
		var br = new BufferedReader(new InputStreamReader(System.in));
		var st = new StringTokenizer(br.readLine(), " ");

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		boolean[][] ramps = new boolean[R][C];

		String s;
		for (int i = 0; i < R; i++){
			s = br.readLine();

			for (int j = 0; j < C; j++){
				ramps[i][j] = s.charAt(j) == '0';
			}
		}

		K = Integer.parseInt(br.readLine());

		//전체 회전
		long sum;
		int select;
		for (int i = 0; i < R; i++) {
			sum = 0L;
			select = 0;

			for (int j = 0; j < C; j++) {
				sum *= 2;
				if(ramps[i][j]){
					sum += 1;
					select++;
				}
			}

			if(select <= K && (K - select)%2 == 0){
				Integer res = map.get(sum);
				if(res != null){
					map.put(sum, res+1);
					max = Math.max(res+1, max);
				}else {
					map.put(sum, 1);
					max = Math.max(1, max);
				}
			}
		}

		System.out.println(max);
	}
}
