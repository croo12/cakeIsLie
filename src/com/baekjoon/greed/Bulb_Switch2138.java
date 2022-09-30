package com.baekjoon.greed;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bulb_Switch2138 {
	
	static boolean[] bluePrint;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		String proto = br.readLine();
		String last = br.readLine();
		
		boolean[] protoType = new boolean[N];
		bluePrint = new boolean[N];
		for (int i = 0; i < N; i++) {
			protoType[i] = proto.charAt(i) == '1';
			bluePrint[i] = last.charAt(i) == '1';
		}
		
		//생각해보면 스위치를 어떤 순서로 누르는지는 상관 없다. 
		//순서와 상관없이 같은 스위치를 누르면 같은 결과를 얻게 된다.
		//왼쪽부터 오른쪽으로 하나씩 이 스위치를 누를지 말지 결정한다고 생각해보면 
		//현재 위치의 왼쪽이 최종 결과와 같을때는 스위치를 눌러서는 안되고
		//현재 위치의 왼쪽이 최종 결과와 다를때는 스위치를 반드시 눌러야한다는 것을 알 수 있다.
		//다만 0번 칸을 누를지 말지가 문제인데... 그냥 두번 해보자
		
		
		//0번칸 안누르고 해보기
		boolean[] case1 = protoType.clone();
		int cnt1 = 0;
		int idx = 1;
		while(idx < N) {
			if(case1[idx-1] != bluePrint[idx-1]) {
				
				cnt1++;
				
				case1[idx - 1] = !case1[idx - 1];
				case1[idx] = !case1[idx];
				if(idx != N-1)
					case1[idx + 1] = !case1[idx + 1];
			}
			idx++;
		}
		if(case1[N-1] != bluePrint[N-1]) {
			cnt1 = 100001 ;
		}
		
		//0번칸 누르고 해보기
		protoType[0] = !protoType[0];
		protoType[1] = !protoType[1];
		int cnt = 1;
		idx = 1;
		while(idx < N) {
			if(protoType[idx-1] != bluePrint[idx-1]) {
				
				cnt++;
				
				protoType[idx - 1] = !protoType[idx - 1];
				protoType[idx] = !protoType[idx];
				if(idx != N-1)
					protoType[idx + 1] = !protoType[idx + 1];
			}
			idx++;
		}
		if(protoType[N-1] != bluePrint[N-1]) {
			cnt = 100001;
		}
		
		if(cnt == cnt1 && cnt == 100001)
			System.out.println(-1);
		else
			System.out.println(cnt < cnt1 ? cnt : cnt1);
	}
}
