package com.beakjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class DFSandBFS1260 {
	
	static HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
	static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		
		int m = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			
			HashSet<Integer> tmp1 = map.get(num1);
			HashSet<Integer> tmp2 = map.get(num2);
			
			if(tmp1 == null) tmp1 = new HashSet<>();
			if(tmp2 == null) tmp2 = new HashSet<>();
			
			tmp1.add(num2);
			tmp2.add(num1);
			
			map.put(num1, tmp1);
			map.put(num2, tmp2);
		}
		
		doDFS(start);
		System.out.println();
		doBFS(start);
		System.out.println();
	}
	
	private static void doDFS(int start) { //dfs의 출력에 문제가 있다 호호호
		boolean[] visited = new boolean[N+1];
		visited[start] = true;
		
		Stack<Integer> stk = new Stack<>();
		stk.push(start);
		System.out.printf("%d ",start);
		
		
		while(!stk.isEmpty()) {
			int now = stk.peek();
			HashSet<Integer> tmp = map.get(now);
			
			boolean newChallenger = false;
			
			if(tmp == null) {
				break;
			}
			
			Iterator<Integer> iter = tmp.iterator();
			while(iter.hasNext()) {
				int next = iter.next();
				if(!visited[next]) {
					stk.push(next);
					visited[next] = true;
					newChallenger = true;
					System.out.printf("%d ",next);
					break;
				}
			}
			
			if(!newChallenger) {
				stk.pop();
				
			}
		}
	}
	
	private static void doBFS(int start) {
		boolean[] visited = new boolean[N+1];
		visited[start] = true;
		
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(start);
		System.out.printf("%d ",start);
		while(!q.isEmpty()) {
			int now = q.poll();
			HashSet<Integer> tmp = map.get(now);
			
			if(tmp == null) {
				break;
			}
			
			Iterator<Integer> iter = tmp.iterator();
			while(iter.hasNext()) {
				int next = iter.next();
				if(!visited[next]) {
					q.add(next);
					visited[next] = true;
					System.out.printf("%d ",next);
				}
			}
		}
	}
}
