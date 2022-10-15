package com.baekjoon.daq;

import java.util.Scanner;

public class Z1074_DAndC {
	static int r;
	static int c;
	public static void main(String[] args) {
		//틀린이유
		//시간초과남
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		r = sc.nextInt() + 1;
		c = sc.nextInt() + 1;
		
		//분할 정복 문제가 아닐까
		//계속 4분의 1 상자로 쪼개기
		//2x2 가 되면 내가 여기 있는지 찾기
		//없으면 횟수 +4
		//있으면 내가 이 안에서 몇번째인지 찾아서 리턴
		
		//이분탐색으로도 풀 수 있을듯
		
		cnt = 0;
		ans = 0;
		int ed = (int)Math.pow(2, N);

		divide(1, ed, 1, ed);
		
		System.out.println(ans);
		sc.close();
	}
	
	static int cnt;
	static int ans;
	static void divide(int stR, int edR, int stC, int edC) {
		if(edR == stR) {
			if(r == stR &&c == stC) {
				ans = cnt;
			}else {
				cnt++;
			}
			return;
		}
		
		int midR = (stR+edR)/2;
		int midC = (stC+edC)/2;
		
		divide(stR, midR, stC, midC);
		divide(stR, midR, midC+1, edC);
		divide(midR+1 , edR, stC, midC);
		divide(midR+1 , edR, midC+1, edC);
	}
}
