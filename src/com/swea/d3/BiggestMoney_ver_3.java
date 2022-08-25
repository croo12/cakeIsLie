package com.swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BiggestMoney_ver_3 {
	
	static int limit;
	static int max;
	static char[] pannels;
	static char[] newPannels;
	static int[] count;
	static boolean isDistinct;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			pannels = st.nextToken().toCharArray();
			isDistinct = true;
			
			if(pannels.length == 1) {
				System.out.printf("#%d %d\n",tc,pannels[0]);
				continue;
			}
				
			newPannels = pannels.clone();
			Arrays.sort(newPannels);
			
			limit = Integer.parseInt(st.nextToken());
			
			count = new int[10];
			for (int i = 0; i < pannels.length; i++) {
				count[pannels[i]-'0']++;
				if(count[pannels[i]-'0'] > 1) {
					isDistinct = false;
				}
			}
			
			
			
			max = 0;
			
			exchange(0,0);
			
			System.out.printf("#%d %d\n",tc,max);
			
		}
	}
	
	private static void exchange(int idx, int n) {
		
		char tmp;

		if(n == limit || idx == pannels.length) {
			
			if(idx == pannels.length && (limit-n)%2 == 1 && isDistinct) {
				tmp = pannels[pannels.length - 1];
				pannels[pannels.length - 1] = pannels[pannels.length - 2];
				pannels[pannels.length - 2] = tmp;
			}
			
			int sum = 0;
			for (int i = 0; i < pannels.length; i++) {
				sum = sum*10 + pannels[i] - '0';
			}
			max = Math.max(sum, max);
			return;
		}
		
//		for(char i : pannels) System.out.printf("%s ->\n",i);
//		System.out.printf("현재 바꾸기 사용 횟수 : %d\n",n);
		
		
		if(pannels[idx] != newPannels[pannels.length - 1 - idx ]) {
			if(count[(newPannels[pannels.length - 1 - idx]-'0')] == 1) {
				for (int i = idx+1; i < pannels.length; i++) {
					if(pannels[i] == newPannels[pannels.length - 1 - idx]) {
						tmp = pannels[idx];
						pannels[idx] = pannels[i];
						pannels[i] = tmp;
					}
				}
				
				exchange(idx+1,n+1);
			}else {
				//같은 숫자가 여러개면 분기를 쪼개야함
				for (int i = idx+1; i < pannels.length; i++) {
					if(pannels[i] == newPannels[pannels.length - 1 - idx]) {
						tmp = pannels[idx];
						pannels[idx] = pannels[i];
						pannels[i] = tmp;
						
						exchange(idx+1,n+1);
						
						pannels[i] = pannels[idx];
						pannels[idx] = tmp;
					}
				}
			}
		}else {
			//지금 자리가 최대값이면 비교하지 말아야함
			exchange(idx+1,n);
		}
	}
}
