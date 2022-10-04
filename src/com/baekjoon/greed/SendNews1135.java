package com.baekjoon.greed;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SendNews1135 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] p = new int[N];
		
		//시간 저장용
		int[] times = new int[N];
		
		//자식노드들 저장용
		PriorityQueue<Integer>[] child = new PriorityQueue[N];
		
		// 밑에 연락을 돌린다.
		// 그런데 가장 시간이 오래걸리는 부하에게 제일 먼저 돌려야함
		// 결국 부하들의 시간을 구해야함 -> 부하의 부하의 시간을 구해야함... 리프노드에서 리턴
		// 말단은 걸리는 시간이 0임
		// 내가 말단에게 거는 시간 1
		
		// 거꾸로 돌린다면 무조건 자식노드부터 찾기 가능
		// 그래서 그걸 부모의 heap에 넣으면 크기별로 뽑을 수 있을것임
		// 그럼 그때부터 (1+젤 큰값), (2+두번째 큰 값) ... 이런식으로 max를 뽑아서 시간을 찾을 수 있다!!

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//부모 넣기
		for (int i = 0; i < N; i++) {
			//큰 순서대로 정렬할 예정
			child[i] = new PriorityQueue<>(Collections.reverseOrder());
			p[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = N-1; i >= 0; i--) {

			int max = 0;
			int size = child[i].size();
			for (int j = 1; j <= size; j++) {
				max = Math.max(j + child[i].poll(), max);
			}
			
			times[i] = max;
			if(p[i] != -1)
				child[p[i]].offer(max);
		}
		
		System.out.println(times[0]);
		
	}
}
