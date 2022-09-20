package com.baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ant10158 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int width = Integer.parseInt(st.nextToken());
		int height = Integer.parseInt(st.nextToken());
		
		st= new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		
		int t = Integer.parseInt(br.readLine());
		
		if((t/width)%2 == 0) {
			x += t%width;
			if(x > width) {
				x = width-(x-width);
			}
		}else {
			x = (width-x) - t%width;
			if(x < 0) {
				x = Math.abs(x);
			}
		}
		
		if((t/height)%2 == 0) {
			y += t%height;
			if(y > height) {
				y = height-(y-height);
			}
		}else {
			y = (height-y) - t%height;
			if(y < 0) {
				y = Math.abs(y);
			}
		}
		
		System.out.printf("%d %d",x,y);
	}
}
