package com.baekjoon.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Bishop1799 {
	
	static ArrayList<Pair> blacks;
	static ArrayList<Pair> whites;
	static boolean[][] blackRoot;
	static boolean[][] whiteRoot;
	static boolean[] failed;
	static int bLength;
	static int wLength;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		blacks = new ArrayList<Pair>();
		whites = new ArrayList<Pair>();
		String now;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				now = st.nextToken();
				if(now.equals("1") && (i+j)%2 == 0)
					whites.add(new Pair(j,i));
				else if(now.equals("1") && (i+j)%2 == 1)
					blacks.add(new Pair(j,i));
			}
		}
		
//		System.out.println(blacks);
//		System.out.println(whites);
		
		bLength = blacks.size();
		blackRoot = new boolean[bLength][bLength];
		failed = new boolean[bLength];
		
		for (int i = 0; i < bLength; i++) {
			for (int j = 0; j < bLength; j++) {
				if(Math.abs(blacks.get(i).x - blacks.get(j).x) == Math.abs(blacks.get(i).y - blacks.get(j).y)) {
					blackRoot[i][j] = true;
					blackRoot[j][i] = true;
				}
			}
		}
		
		bdfs(0);
		
		cnt = 0;
		
		wLength = whites.size();
		whiteRoot = new boolean[wLength][wLength];
		failed = new boolean[wLength];
		
		for (int i = 0; i < wLength; i++) {
			for (int j = 0; j < wLength; j++) {
				if(Math.abs(whites.get(i).x - whites.get(j).x) == Math.abs(whites.get(i).y - whites.get(j).y)) {
					whiteRoot[i][j] = true;
					whiteRoot[j][i] = true;
				}
			}
		}
		
		wdfs(0);
		
//		System.out.println(bmax);
//		System.out.println(wmax);
		System.out.println(bmax + wmax);
	}
	
	static int bmax;
	static int wmax;
	static int cnt;
	
	private static void bdfs(int depth) {
		if(depth == bLength) {
			bmax = Math.max(bmax, cnt);
			return;
		}
		
		if(failed[depth]) { 
			bdfs(depth+1);
			return;
		}
		
		failed[depth] = true;
		cnt++;
		ArrayList<Integer> change = new ArrayList<>();
		
		for (int i = 0; i < bLength; i++) {
			if(blackRoot[i][depth] && !failed[i]) {
				failed[i] = true;
				change.add(i);
			}
		}
		bdfs(depth+1);
		cnt--;
		for (int i = 0; i < change.size(); i++) {
			failed[change.get(i)] = false;
		}
		bdfs(depth+1);
		failed[depth] = false;
	}
	
	private static void wdfs(int depth) {
		if(depth == wLength) {
			wmax = Math.max(wmax, cnt);
			return;
		}
		
		if(failed[depth]) { 
			wdfs(depth+1);
			return;
		}
		
		failed[depth] = true;
		cnt++;
		ArrayList<Integer> change = new ArrayList<>();
		
		for (int i = 0; i < wLength; i++) {
			if(whiteRoot[i][depth] && !failed[i]) {
				failed[i] = true;
				change.add(i);
			}
		}
		wdfs(depth+1);
		cnt--;
		for (int i = 0; i < change.size(); i++) {
			failed[change.get(i)] = false;
		}
		wdfs(depth+1);
		failed[depth] = false;
	}
	
	static class Pair{
		int x;
		int y;
		Pair(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
}
