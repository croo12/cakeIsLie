package com.baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class FamilyNumberCalculator2644 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int visited[] = new int[n+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		Map<Integer, ArrayList<Integer>> map = new HashMap<>();
		
		
		int m = Integer.parseInt(br.readLine());
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int man1 = Integer.parseInt(st.nextToken());
			int man2 = Integer.parseInt(st.nextToken());
			
			ArrayList<Integer> tmp1 = map.get(man1);
			ArrayList<Integer> tmp2 = map.get(man2);
			if(tmp1 == null) tmp1 = new ArrayList<Integer>();
			if(tmp2 == null) tmp2 = new ArrayList<Integer>();
			tmp1.add(man2);
			tmp2.add(man1);
			map.put(man1, tmp1);
			map.put(man2, tmp2);
		}
		
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(start);
		visited[start] = 1;
		
		while(!q.isEmpty()) {
			int now = q.poll();
			
			ArrayList<Integer> tmp = map.get(now);
		
			for (int i = 0; i < tmp.size(); i++) {
				int man = tmp.get(i);
				if(visited[man] == 0) {
					q.add(man);
					visited[man] = visited[now]+1;
				}
			}
		}
		
		int cnt =visited[end] - 1;
		System.out.println(cnt);
		
//		System.out.println(map.get(2));
//		for (int i = 0; i < visited.length; i++) {
//			System.out.printf("%d : %d || ",i,visited[i]);
//		}
	}
}
