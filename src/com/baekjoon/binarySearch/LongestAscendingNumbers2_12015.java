package com.baekjoon.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LongestAscendingNumbers2_12015 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] snake = new int [T];
		for (int i = 1; i < T; i++) {
			snake[i] = 1000001;
		}
		snake[0] = Integer.parseInt(st.nextToken());
		int length = 1;
		
		//바꿔치기 술로 만들기.
		//snake 배열에 받는 숫자를 저장하기
		//그런데 내가 본래 가지고 있던 수보다 큰 수가 나오면
		//본래 가지고 있던 수 중 지금 나온 수보다 작으면서 가장 큰 수 자리랑 바꾸기
		
		//그럼 이 때 이진탐색을 사용할 수 있을다
		
		//지금 숫자
		int now;
		//시작점
		int left;
		//끝점
		int right;
		//가운데
		int mid;
		for (int i = 1; i < T; i++) {
			now = Integer.parseInt(st.nextToken());
			left = 0;
			right = length;
			
			while(left <= right) {
				mid = (left + right)/2;
				if(snake[mid] < now) {
					left = mid + 1;
				}else {
					right = mid - 1;
				}
			}
			
			snake[left] = now;
			if(left == length)
				length++;
		}
		
		System.out.println(length);
	}
}
