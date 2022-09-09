package com.beakjoon.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class CrazyRobot1405 {
	static int N;
	static double e;
	static double w;
	static double s;
	static double n;
	static double result;
	static List<Pair> list = new ArrayList<Pair>();
	static int[] cnt = new int[4];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken())/100.0;
		w = Integer.parseInt(st.nextToken())/100.0;
		s = Integer.parseInt(st.nextToken())/100.0;
		n = Integer.parseInt(st.nextToken())/100.0;
		
		list.add(new Pair(0,0));
		dfs(0);
		System.out.println(result);
	}
	
	private static void dfs(int depth) {
		if(depth == N) {
			result += Math.pow(e, cnt[0])
					* Math.pow(w, cnt[1])
					* Math.pow(s, cnt[2])
					* Math.pow(n, cnt[3]);
			return;
		}
		
		Pair now = list.get(list.size()-1);
		Pair neo; 
		
		neo = new Pair(now.x+1,now.y);
		if(!list.contains(neo) && e != 0) {
			cnt[0]++;
			list.add(neo);
			dfs(depth+1);
			cnt[0]--;
			list.remove(neo);
		}
		
		neo = new Pair(now.x-1,now.y);
		if(!list.contains(neo) && w != 0) {
			cnt[1]++;
			list.add(neo);
			dfs(depth+1);
			cnt[1]--;
			list.remove(neo);
		}
		
		neo = new Pair(now.x,now.y+1);
		if(!list.contains(neo) && s != 0) {
			cnt[2]++;
			list.add(neo);
			dfs(depth+1);
			cnt[2]--;
			list.remove(neo);
		}
		
		neo = new Pair(now.x,now.y-1);
		if(!list.contains(neo) && n != 0) {
			cnt[3]++;
			list.add(neo);
			dfs(depth+1);
			cnt[3]--;
			list.remove(neo);
		}
	}
	
	static class Pair{
		int x;
		int y;
		Pair(int x, int y){
			this.x = x;
			this.y = y;
		}
		
		@Override
		public int hashCode() {
			return this.x*33 + this.y*71;
		}
		
		@Override
		public boolean equals(Object obj) {
			return this.hashCode() == obj.hashCode();
		}
	}
}
