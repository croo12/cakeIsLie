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
		int N = NMK[0];
		int M = NMK[1];
		int K = NMK[2];
		
		//N개의 a와 M개의 z를 배치하는 경우의 수 =
		//N+M개의 공들 중 M개를 선택하는 경우의 수와 같다.
		//즉 (N+M)! / (N! * M!) 임 200!은 딱 봐도 계산이 안될것 같다
		
		//az는 사실 aaaa만 있는 문자열에 z를 끼워넣는 방법의 가짓수임
		//a가 다섯개라면 z를 배치할 수 있는 공간은 6개임
		//그럼 z를 배치할 수 있는 공간 배열 = (M+1)진수처럼 움직임
		
		int[] zSpace = new int[N];
		int last = M;
		
		var idx = N-1;
		
		K--;
		while(K != 0) {
			int now = K % (last+1);
			
			zSpace[idx] = now;
			last -= now;
			
			idx--;
			K /= last+1;
		}
		
		System.out.println(last);
		
		if(last < 0)
			System.out.println(-1);
		else {
			var ans = new StringBuilder();
			for(int i = 0; i < N; i++) {
				while(zSpace[i] != 0) {
					zSpace[i]--;
					ans.append('z');
				}
				
				ans.append('a');
			}
			
			while(last != 0) {
				last--;
				ans.append('z');
			}
			
			System.out.println(ans);
		}
	}
}
