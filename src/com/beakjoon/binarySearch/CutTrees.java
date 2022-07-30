package com.beakjoon.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CutTrees {
	
	static int[] heights;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int treeNum = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		heights = Arrays.stream(br.readLine().split(" ")).mapToInt(s -> Integer.parseInt(s)).toArray() ;
		Arrays.sort(heights);
//		System.out.println(Arrays.toString(heights));
		
		long start = 0;
		long end = heights[treeNum-1];
		long mid = (start+end)/2;
		
		while(end - start >= 0) {
			if(lengthOfTree(mid) >= m) {
				if(lengthOfTree(mid+1) < m){				
					System.out.println(mid);
					break;
				}else {
					start = mid+1;
//					System.out.println(mid+"는 너무 길어");
				}
			}else {
				end = mid -1;
//				System.out.println(mid+"는 너무 짧아");
			}
			mid = (start+end)/2;
		}
	}
	
	public static long lengthOfTree(long set) {
		long sum = 0;
		for (int i : heights) {
			long tree = i - set;
			if(tree > 0) {
				sum+= tree;
			}
		}
		return sum;
	}
}
