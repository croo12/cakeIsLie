package com.swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MemoryClear {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			boolean zeroCheck = true;
			//1이 들어오는지 0이 들어오는지
			
			int cnt = 0;
			int now;
			
			while(true) {
				now = br.read();
				if(now == '0' && !zeroCheck) {
						cnt++;
						zeroCheck = true;
				}else if(now == '1' && zeroCheck) {
						cnt++;
						zeroCheck = false;
				}else if(now == '\n' || now == -1){
					break;
				}
			}
			
			System.out.printf("#%d %d\n",tc,cnt);
		}
	}
}
