package com.beakjoon.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class WeightLimit {
	
	static HashMap<Integer,ArrayList<Bridge>> map;
	static boolean[] visited;
	static int des;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		map = new HashMap<>();
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int starting = Integer.parseInt(st.nextToken());
			int destination = Integer.parseInt(st.nextToken());
			int limit = Integer.parseInt(st.nextToken());
			if(map.get(starting) == null) 	map.put(starting, new ArrayList<Bridge>());
			map.get(starting).add(new Bridge(starting, destination, limit));
			if(map.get(destination) == null) 	map.put(destination, new ArrayList<Bridge>());
			map.get(destination).add(new Bridge(destination, starting, limit));
		}
		
		st = new StringTokenizer(br.readLine());
		int go = Integer.parseInt(st.nextToken());
		des = Integer.parseInt(st.nextToken());
		
		long start = 1;
		long end = 1000000000;
		long mid;
		
		while(end >= start) {
			visited = new boolean[n+1];
			mid = (start + end)/2;
			if(check(mid,go)) {
				start = mid + 1;
			}else {
				end = mid -1;
			}
		}
		
		System.out.println(end);
		
	}
	
	private static boolean check(long mid, int now) {
		ArrayList<Bridge> list = map.get(now);
		visited[now] = true;
		
		for (int i = 0; i < list.size(); i++) {
			Bridge b = list.get(i);
			if(b.limit >= mid && !visited[b.destination]) {
				check(mid, b.destination);
			}
		}
		
		if(visited[des]) return true;
		else return false;
	}
}

class Bridge{
	int starting;
	int destination;
	int limit;
	public Bridge(int starting, int destination, int limit) {
		super();
		this.starting = starting;
		this.destination = destination;
		this.limit = limit;
	}
}