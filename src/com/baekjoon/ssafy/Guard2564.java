package com.baekjoon.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Guard2564 {
	
	static int WIDTH;
	static int HEIGHT;
	
	public static void main(String[] args) throws IOException {
		//북남서동
		//좌상
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		WIDTH = Integer.parseInt(st.nextToken());
		HEIGHT = Integer.parseInt(st.nextToken());
		
		int n = Integer.parseInt(br.readLine());
		
		Position[] ms = new Position[n];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			
			ms[i] = new Position(Integer.parseInt(st.nextToken())
					,Integer.parseInt(st.nextToken()));
			
//			System.out.println(ms[i]);
		}
		
		st = new StringTokenizer(br.readLine());
		Position me = new Position(Integer.parseInt(st.nextToken())
				,Integer.parseInt(st.nextToken()));
		
		int sum = 0;
		for(int i=0; i<n; i++) {
			int distance = check(me,ms[i]);
			sum+=distance;
//			System.out.println(distance);
		}
		
		System.out.println(sum);
	}
	
	private static int check(Position me, Position you) {
		int distance = 0;
		
		if(Math.abs(me.height - you.height) == Guard2564.HEIGHT ) {
			
			int now = Guard2564.HEIGHT + (Guard2564.WIDTH - me.width) + (Guard2564.WIDTH - you.width);
			distance = Math.min(now, Guard2564.HEIGHT*2 + Guard2564.WIDTH*2 - now);
			
		}else if(Math.abs(me.width - you.width) == Guard2564.WIDTH) {
			
			int now = Guard2564.WIDTH + (Guard2564.HEIGHT - me.height) + (Guard2564.HEIGHT - you.height);
			distance += Math.min(now, Guard2564.HEIGHT*2 + Guard2564.WIDTH*2 - now);
			
		}else {
			
			distance = Math.abs(me.height - you.height) + Math.abs(me.width - you.width); 
		
		}
		return distance;
	}
}

class Position{
	
	int height;
	int width;
	
	public Position(int position, int length) {
		super();
		switch(position) {
			case 1 :
				this.height = 0;
				this.width = length;
				break;
			case 2 :
				this.height = Guard2564.HEIGHT;
				this.width = length;
				break;
			case 3 :
				this.height = length;
				this.width = 0;
				break;
			case 4 :
				this.height = length;
				this.width = Guard2564.WIDTH;
		}
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "세로 : " + this.height + " 가로 : "+this.width;
	}
}
