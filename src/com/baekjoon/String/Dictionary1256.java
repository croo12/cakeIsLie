package com.baekjoon.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class Dictionary1256 {
	public static void main(String[] args) {
		try {
			new Dictionary1256().solution();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void solution() throws IOException {
		var br = new BufferedReader(new InputStreamReader(System.in));
		var stream = Stream.of(br.readLine().split(" "));
		int[] NMK = stream.mapToInt(s -> Integer.parseInt(s)).toArray();
		
		//N개의 a와 M개의 z를 배치하는 경우의 수 =
		//N+M개의 공들 중 M개를 선택하는 경우의 수와 같다.
		
		//즉 (N+M)! / (N! * M!) 임 200!은 딱 봐도 계산이 안될것 같다
		
		
		
	}
}
