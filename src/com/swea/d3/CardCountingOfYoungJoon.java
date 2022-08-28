package com.swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CardCountingOfYoungJoon {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			boolean[][] cards = new boolean[4][13];
			char[] s = br.readLine().toCharArray();
			boolean isErr = false;
			Loop : for (int i = 0; i < s.length; i+=3) {
				int num = (s[i+1]-'0')*10+s[i+2]-'0'-1;
				switch(s[i+0]) {
				case 'S' :
					if(!cards[0][num])
						cards[0][num] = true;
					else {
						isErr = true;
						break Loop;
					}	
					break;
				case 'D' :
					if(!cards[1][num])
						cards[1][num] = true;
					else {
						isErr = true;
						break Loop;
					}
					break;
				case 'H' :
					if(!cards[2][num])
						cards[2][num] = true;
					else {
						isErr = true;
						break Loop;
					}
					break;
				case 'C' :
					if(!cards[3][num])
						cards[3][num] = true;
					else {
						isErr = true;
						break Loop;
					}
					break;
				}
			}//Loop
			
			if(isErr) System.out.println("#"+tc+" ERROR");
			else {
				StringBuilder sb = new StringBuilder();
				sb.append("#").append(tc);
				for (int i = 0; i < 4; i++) {
					int cnt = 0;
					for (int j = 0; j < 13; j++) {
						if(!cards[i][j]) {
							cnt++;
						}
					}
					sb.append(" ").append(cnt);
				}
				System.out.println(sb);
			}
		}
	}
}
