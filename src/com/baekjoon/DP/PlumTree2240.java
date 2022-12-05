package com.baekjoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PlumTree2240 {
	public static void main(String[] args) {
		try {
			new PlumTree2240().solution();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	int T;
	int W;
	
	boolean[][] dropPlum;
	int[][] cache;
	
	int total;
	
	private void solution() throws IOException {
		var br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split(" ");
		T = Integer.parseInt(tmp[0]);
		W = Integer.parseInt(tmp[1]);
		
		dropPlum = new boolean[T+1][2];
		cache = new int[T+1][W+1];
		
		//0번 나무에 떨어지는 자두의 수
		total = 0;
		
		for (int i = 1; i <= T; i++) {
			dropPlum[i][Integer.parseInt(br.readLine()) - 1] = true;
			
			if(dropPlum[i][0])
				total++;
			
			cache[i][0] = total;
		}
		
		// 일정시점 t1에서 w1만큼의 기회를 가지고 있다면
		// 앞의 선택과 관계없이 구간의 최댓값은 동일하다
		
		//ans = 정답
		//1에서 출발하기 vs 2에서 출발하기
		int ans = Math.max(calc(1, W, 0) , calc(1, W - 1, 1));
		
		System.out.println(ans);
	}

	private int calc(int t, int w, int position) {
		//기저조건
		if(t == T+1) {
			return 0;
		}
		
		if(w == 0) {
			int max;
			if( position == 0 ) {
				max = total - cache[t-1][0];
			}else
				max = (T - total) - ((t-1) - cache[t-1][0]);
			
			return max;
		}
		
		//다른 곳에 자두 떨어지기 전에는
		//바꿀지 말지 고민할 필요 없음
		
		int time = t;
		int sum = 0;
		
		//나랑 같은 위치 자두 떨어지는거 아니면 다 털기
		while( time != T + 1 && !dropPlum[time][position] ) {
			time++;
		}
		
		while( time != T + 1 && dropPlum[time][position] ) {
			time++;
			sum++;
		}
		
		//모든 자두 다 떨어짐
		if(time == T + 1) {
			return cache[t][w] = sum;
		}
		
		//모든 자두 다 안떨어졌는데 다른 곳에 자두가 떨어짐
		//바꿀까?
		int change = 0;
		
		if(w != 1)
			change = cache[time][w-1] == 0 ? calc(time, w-1, (position + 1)%2 ) : cache[time][w-1];
		else
			change = calc(time, w-1, (position + 1)%2 );
		
		//바꾸지 말까?
		int stop = cache[time][w] == 0 ? calc(time, w, position) : cache[time][w];
		
		//더 큰거 저장 후 리턴
		return cache[t][w] = sum + Math.max(change, stop);
	}
}
