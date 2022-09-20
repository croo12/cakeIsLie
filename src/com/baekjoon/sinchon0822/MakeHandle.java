package com.baekjoon.sinchon0822;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class MakeHandle {//왜 안댐
	
	static ArrayList<String> results = new ArrayList<>();
	static int[] words;
	static boolean[] visited;
	static ArrayList<Integer>[] roots;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		words = new int[n];
		visited = new boolean[n];
		roots = new ArrayList[n];
		
		for (int i = 0; i < n; i++) {
			words[i] = br.read();
			roots[i] = new ArrayList<Integer>();
		}
		br.readLine();
		
//		for(int i : words) System.out.printf("%s ", (char)i);
		
		StringTokenizer st;
		
		int a;
		int b;
		for (int i = 0; i < n-1; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			
			roots[a-1].add(b-1);
			roots[b-1].add(a-1);
		}
		
		dfs(0,""+((char)words[0]));
		
		Collections.sort(results);
		
		System.out.println(results.get(results.size()-1));
	}
	
	private static void dfs(int now, String s) {
		boolean flag = false;
		visited[now] = true;
		ArrayList<Integer> list = roots[now]; 
		
		int max = 0;
		int tmp;
		for (int i = 0; i < list.size(); i++) {
			tmp = list.get(i);
			if(!visited[tmp])
				max = Math.max(words[tmp],max);
		}
		
		for (int i = 0; i < list.size(); i++) {
			tmp = list.get(i);
			if(!visited[tmp] && words[tmp] == max) {
				dfs(tmp, s + ((char)words[tmp]));
				flag = true;
			}
		}
		
		if(!flag) {
			results.add(s);
			return;
		}
	}
}
