package com.baekjoon.greed;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Spring18513 {
	// 틀린이유 
	// 1. 시간초과 당함 (자투리 계산 때문이 아닐까?)
	// 2. 틀렸습니다. 하단에 이유 서술
	// 3. 1번과 같은 63%에서 시간초과. -> 1. 애초에 방법이 잘못됐다. 2. 퀵소트 최악의 경우가 존재함 <- 일단 2번 테스트하자
	// 4. 63%에서 시간초과 : 결과적으로 로직을 변경하기로 함
	// 5. 컴파일에러 : 패키지 안없앰, 이름 Main으로 안바꿈
	// 6. 틀렸습니다. 전보다는 멀리감
	// 7. 컴파일 에러 Main
	// 8. 82%에서 Fail : 나는 2500050000이 2^31.2193... 이라서 초과 안될줄 알았는데
	// int 는 32비트를 온전히 다 쓰는게 아니라 1bit는 부호에 써서 int는 2^31 -1까지인데
	// 멍청했다
	
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
		PriorityQueue<Spring> heap = new PriorityQueue<>();
		
		int left = 100001;
		for (int i = 0; i < N-1; i++) {
			int dis = pos[i + 1] - pos[i] - 1;
			//홀수면 왼쪽에 있는 녀석이 1 더 갖기
			heap.offer(
					new Spring(left, dis%2==0 ? dis/2 : (dis/2 + 1)
							));
			left = dis/2;
		}
		heap.offer(new Spring(left, 100001));
		
		long sum = 0;
		while(K-- > 0) {
			Spring now = heap.poll();
			sum += now.getMin();
			now.build();
			heap.offer(now);
			
//			System.out.println(heap);
		}
		
		System.out.println(sum);
		//샘터의 위치 -1억 ~ 1억 -> 2억  //시간 1초
		//집과 샘터의 수 최대 100000
		
		//그냥 샘터 암거나 찾아서 다닥다닥 붙으면 되는거 아님?
		//샘터 위치 좌우에 집을 짓는다. -> 다 차있으면 한칸 널찍이 짓는다.
		
		//샘터가 하나인 경우 1 두개 2두개 ... n두개 이렇게 집을 지어나갈 수 있다.
		
		//근데 이 문제는 샘터가 여러개라면 왼쪽이나 오른쪽에서 다른 샘터와 부딫히게 됨.
		//즉 그 방향으로는 (양쪽 샘터 사이의 공간)/2 ? 0과 9에 있다치면 1 2 3 4 / 5 6 7 8  4개씩 맞음;  
		
		// 100000개의 샘을 퀵소트로 정렬하면 최악의 경우 n^2 이니까 10000000000으로 1초에 1억번 기준 100초걸림
		// 1초에 10억번 기준이어도 10초임 
		// nlogn의 경우에는 100000 * log(100000) = 1660964
		// 정렬이 끝나면 샘의 왼쪽 오른쪽 길이를 이용할 수 있다
		// 일단 퀵소트 해보고 시간 초과나면 mergeSort로 바꾸지 뭐
		// 답이 long범위로 나갈까? 100000개의 집 샘 1 -> (50000 + 1)*50000
		// 2500050000 = 31.2193.... 2의 32승보다는 작긴함
		
		// 시간초과남, 자투리 계산이 너무 많았거나 정렬때문일듯
		// 일단 자투리 계산을 최대한 줄여보자
		
		// 틀렸습니다. 
		// 반복문을 수정하면서 while문이 끝나는 
		// 순간에 항상 unhappy++이 이뤄지지 않는다.
		// 체크용 flag 제작
		
		// 퀵소트와 머지소트 둘다 시간초과임.
		// 생각해보니 while문은 최악의 경우 샘 100000개가 붙어있으면 100000번 돌때마다 K를 2씩 감소시킬것이다.
		// 사실 위의 경우 99998개의 샘은 거리가 좌우 공간이 0 이므로 조사할 필요가 없다.
		
		// 그럼 각각의 샘을 클래스로 만들고 최소거리를 뽑는 Priority q를 이용해야 할까?
		// 왜 틀렸을까....
	}
		
	static class Spring implements Comparable<Spring>{
		final int LEFT_MAX;
		final int RIGHT_MAX;
		
		int left;
		int right;
		
		Spring(int left, int right){
			this.LEFT_MAX = left;
			this.RIGHT_MAX = right;
			
			if(left == 0)
				this.left = 100001;
			else
				this.left = 1;
			
			if(right == 0)
				this.right = 100001;
			else
				this.right = 1;
		}
		
		int getMin() {
			return left > right ? right : left;
		}
		
		void build() {
			if(left > right) {
				right++;
				if(right > RIGHT_MAX) {
					right = 100001;
				}
			}else {
				left++;
				if(left > LEFT_MAX) {
					left = 100001;
				}
			}
		}
		
		@Override
		public int compareTo(Spring o) {
			return getMin() - o.getMin();
		}
		
		@Override
		public String toString() {
			return "최소값 : " + getMin();
		}
	}
}
