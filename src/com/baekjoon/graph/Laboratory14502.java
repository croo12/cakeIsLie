package com.baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Laboratory14502 {
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int y = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int[][] lab = new int[y][x];
		
		for (int i = 0; i < y; i++) {
			st= new StringTokenizer(br.readLine());
			for (int j = 0; j < x; j++) {
				lab[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int result= 0;
		
		Queue<VirusPair> q = new LinkedList<>();
		int[] rx = {0,0,1,-1};
		int[] ry = {1,-1,0,0};
		
		for (int first = 1; first < x*y-1; first++) {
			
			if(lab[(first-1)/x][(first-1)%x] != 0) continue;
			else lab[(first-1)/x][(first-1)%x] = 1;
			
			for (int second = first+1; second < x*y; second++) {
				
				if(lab[(second-1)/x][(second-1)%x] != 0) continue;
				else lab[(second-1)/x][(second-1)%x] = 1;
				
				for (int tries = second+1; tries <= x*y; tries++) {
					
					if(lab[(tries-1)/x][(tries-1)%x] != 0) continue;
					else lab[(tries-1)/x][(tries-1)%x] = 1;
					
//                  System.out.println("================");
//					for(int[] is : lab) {
//						for(int i : is) System.out.print(i+" ");
//						System.out.println();
//					}
//					System.out.println("================");
					
					for (int i = 0; i < y; i++) { //시도하기
						for (int j = 0; j < x; j++) {
							if(lab[i][j] == 2) {
								q.offer(new VirusPair(j, i));
								
								while(!q.isEmpty()) {
									VirusPair now = q.poll();
									
									for (int k = 0; k < 4; k++) {
										int nextX = now.x + rx[k];
										int nextY = now.y + ry[k];
										
										if(nextX < 0 || nextX >= x || nextY < 0 || nextY >= y) continue;
										if(lab[nextY][nextX] == 0) {
											lab[nextY][nextX] = 3;
											q.offer(new VirusPair(nextX, nextY));
										}
									}
								}
							} 
						}
					}
					
					int cnt = 0;
					for (int i = 0; i < y; i++) {
						for (int j = 0; j < x; j++) {
							if(lab[i][j] == 0) cnt++;
							else if(lab[i][j] == 3) lab[i][j] = 0;
						}
					}
					
					result = Math.max(result, cnt);
					lab[(tries-1)/x][(tries-1)%x] = 0;
				}//벽 세개 세운 for문
				lab[(second-1)/x][(second-1)%x] = 0;
			}
			lab[(first-1)/x][(first-1)%x] = 0;
		}
		
		System.out.println(result);
	}
}

class VirusPair {
	int x;
	int y;
	VirusPair(int x, int y){
		this.x = x;
		this.y = y;
	}
}