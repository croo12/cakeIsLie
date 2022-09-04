package com.beakjoon.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ArtistMiMi20950 {
	
	static int min = 255 * 3;
	static ArrayList<Color> list = new ArrayList<Color>();
	static Color[] colors;
	static Color gomduri;
	static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		colors = new Color[N];
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			colors[i] = new Color(Integer.parseInt(st.nextToken()),
								  Integer.parseInt(st.nextToken()),
								  Integer.parseInt(st.nextToken()));
		}
		st = new StringTokenizer(br.readLine());
		gomduri = new Color(Integer.parseInt(st.nextToken()), 
								  Integer.parseInt(st.nextToken()), 
								  Integer.parseInt(st.nextToken()));
		
		run(0,0);
		System.out.println(min);
	}
	
	private static void run(int idx, int depth) {
		if(depth == 7 || idx >= N) {
			if(depth == 1 || depth == 0)
				return;
			
			int r = 0, g = 0, b = 0;
			int num = list.size();
			Color now;
			for (int i = 0; i < num; i++) {
				now = list.get(i);
				r += now.r;
				g += now.g;
				b += now.b;
			}
			int diff = Math.abs(r/num -gomduri.r) + Math.abs(g/num -gomduri.g) + Math.abs(b/num -gomduri.b);
			min = Math.min(min, diff);
			return;
		}
		
		list.add(colors[idx]);
		run(idx+1, depth+1);
		list.remove(list.size()-1);
		run(idx+1, depth);
	}
	
	static class Color{
		int r;
		int g;
		int b;
		public Color(int r, int g, int b) {
			this.r = r;
			this.g = g;
			this.b = b;
		}
	}
}
