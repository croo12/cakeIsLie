package com.swea.ssafy;

import java.util.Scanner;

public class WantScore { // 클래스 이름을 Solution으로 바꿔야 한다.

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			System.out.print("#"+test_case+" ");
			int N = sc.nextInt();
			int K = sc.nextInt();
			double[] scores = new double[N];
			double KsScore = 0;
			for(int i=0; i<N; i++) {
				double d1 = sc.nextInt()*0.35;
				double d2 = sc.nextInt()*0.45;
				double d3 = sc.nextInt()*0.2;
				scores[i] = d1+d2+d3;
				if(i == K) {
					KsScore = scores[i];
				}
			}
			//배열을 큰 순서대로 정렬함
			//k번의 숫자와 같은 순서를 뽑고 성적 출력;
			double tmp = 0;
			for (int i = 0; i < scores.length; i++) {
				for (int j = i+1; j < scores.length; j++) {
					if(scores[i] < scores[j]) {
						tmp = scores[i];
						scores[i] = scores[j];
						scores[j] = tmp;
					}
				}
			}
			int rank = 0;
			for (int i = 0; i < scores.length; i++) {
				if(KsScore == scores[i]) {
					rank = i+1;
				}
			}
			//K는 rank등임
			int pakit = N/10;
			if(rank <= pakit)
				System.out.println("D0");
			else if(rank <= 2*pakit)
				System.out.println("C-");
			else if(rank <= 3*pakit)
				System.out.println("C-");
			else if(rank <= 4*pakit)
				System.out.println("C-");
			
		}
		sc.close();
	}
}
