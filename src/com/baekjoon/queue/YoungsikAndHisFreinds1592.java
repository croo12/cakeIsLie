package com.baekjoon.queue;

import java.util.Arrays;
import java.util.Scanner;

public class YoungsikAndHisFreinds1592 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int m = sc.nextInt();
		int l = sc.nextInt();
		
		int[] arr = new int[N];
		int cnt = 0;
		int now = 100*N + 1;
		while(Arrays.stream(arr).max().getAsInt() != m) {
			cnt++;
			arr[now%N]++;
			if(arr[now%N]%2 == 0) {
				now = now - l;
			}else {
				now = now + l;
			}
		}
		if(cnt!= 0)
			System.out.println(cnt-1);
		else 
			System.out.println(0);
		
		sc.close();
	}
}
