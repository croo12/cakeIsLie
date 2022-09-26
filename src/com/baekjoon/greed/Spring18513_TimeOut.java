package com.baekjoon.greed;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Spring18513_TimeOut {
	// 틀린이유 
	// 1. 시간초과 당함 (자투리 계산 때문이 아닐까?)
	// 2. 틀렸습니다. 하단에 이유 서술
	// 3. 1번과 같은 63%에서 시간초과. -> 1. 애초에 방법이 잘못됐다. 2. 퀵소트 최악의 경우가 존재함 <- 일단 2번 테스트하자
	// 4. 63%에서 시간초과 : 결과적으로 로직을 변경하기로 함
	// 5. 컴파일에러 : 패키지 안없앰, 이름 Main으로 안바꿈
	// 6. 틀렸습니다. 전보다는 멀리감
	// 7. 컴파일 에러 Main
	// 8. 82%에서 Fail 이런 쉣
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		//N개의 샘터 K개의 집
		int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
		st =  new StringTokenizer(br.readLine());
		//N개의 샘터 위치
		int[] pos = new int[N];
		for (int i = 0; i < N; i++) {
			pos[i] = Integer.parseInt(st.nextToken()) + 1000000001;
		}
		
		Arrays.sort(pos);
		
		//부지 확인
		int sum = 0;
		int unhappy = 1;
		int idx = 0;
		boolean flag = false;
		
		while(K > 0) {
			flag = false;
			//가장 왼쪽 샘의 왼쪽 길이는 무한대임
			if(idx == 0) {
				K--;
				sum+= unhappy;
			}
			//가장 오른쪽 샘의 오른쪽 길이는 무한대임
			//오른쪽 끝 샘까지 다 조사함
			if(idx == N-1) {
				K--;
				sum+= unhappy;
				
				//제일 왼쪽 샘부터 다시
				idx = 0;
				//다음에는 길이가 +1 인 곳을 조사할 것임
				unhappy++;
				flag = true;
				continue;
			}
			
			//오른쪽 샘과 사의의 공간. 9와 0 사이의 공간은 8칸임
			int dis = pos[idx + 1] - pos[idx] - 1;

			if(dis/2 >= unhappy) {
				sum += unhappy*2;
				K-=2;
			}else if((dis+1)/2 >= unhappy) {
				sum += unhappy;
				K--;
			}
			
			//다음 샘
			idx++;
		}
		//집 다지었으면 나옴
		
		if(K < 0) { //너무 많이 지었나?
			if(flag) 
				unhappy--;
			sum -= (0-K) * unhappy;
		}

		System.out.println(sum);
	}
}
