package com.beakjoon.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class GuitarBluerayLesson {
	
	static long times[];
	static long lectureNum;
	static long cdNum;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long lectureNum = Integer.parseInt(st.nextToken());
		long cdNum = Integer.parseInt(st.nextToken());
		
		times = Arrays.stream(br.readLine().split(" ")).mapToLong(s -> Integer.parseInt(s)).toArray() ;
		
		long start = Arrays.stream(times).sum();
		long end = 10000 * 100000;
	}
}
