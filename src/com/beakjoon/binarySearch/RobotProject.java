package com.beakjoon.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class RobotProject {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			try {
				int x = Integer.parseInt(br.readLine())* 10000000;
				int n = Integer.parseInt(br.readLine());
				int[] arr = new int[n];
				for (int i = 0; i < n; i++) {
					arr[i] = Integer.parseInt(br.readLine());
				}
				Arrays.sort(arr);
				
				StringBuilder sb = new StringBuilder();
				boolean flag = false;
				int st = 0;
				int end = n-1;
				while(end > st) {
					int tc = arr[st] + arr[end];
					if(tc > x) {
						end -= 1;
					}else if(tc <x) {
						st += 1;
					}else {
						flag = true;
						break;
					}
				}
				if(flag) {
					sb.append("yes ");
					sb.append(arr[st]);
					sb.append(" ");
					sb.append(arr[end]);
				}else {
					sb.append("danger");
				}
				System.out.println(sb);
			}catch(Exception e) {
				return;
			}
		}	
	}
}
