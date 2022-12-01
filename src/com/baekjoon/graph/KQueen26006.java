package com.baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.stream.Stream;

public class KQueen26006 {
	public static void main(String[] args) {
		try {
			new KQueen26006().solution();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//9방향 (나 포함)
	int[] dr = {0,1,1,1,0,0,-1,-1,-1};
	int[] dc = {0,1,0,-1,1,-1,1,0,-1};
	
	private void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//체스판 길이, 퀸 수
		Stream<String> stream = Stream.of(br.readLine().split(" "));
		int[] NK = stream.mapToInt(s -> Integer.parseInt(s) ).toArray();
		
		//킹의 rc
		stream = Stream.of(br.readLine().split(" "));
		int[] kingRC = stream.mapToInt(s -> Integer.parseInt(s) - 1 ).toArray();
		boolean[] vis = new boolean[9];
		
		var queens = new ArrayList<Queen>();
		
		int[] tmp;
		for (int i = 0; i < NK[1]; i++) {
			stream = Stream.of(br.readLine().split(" "));
			tmp = stream.mapToInt(s -> Integer.parseInt(s) - 1 ).toArray();
			
			queens.add(new Queen(tmp[0], tmp[1]));
		}
		
		//퀸한테 위협받고 있는가?
		int rr;
		int rc;
		for (int i = 0; i < 9; i++) {
			rr = kingRC[0] + dr[i];
			rc = kingRC[1] + dc[i];
			
			if(rr >= NK[0] || rc >= NK[0] || rr < 0 || rc < 0) {
				vis[i] = true;
				continue;
			}
			
			//퀸 검사
			for(var queen : queens) {
				if( queen.r == rr ) {
					vis[i] = true;
					break;
				}
				
				if( queen.c == rc ) {
					vis[i] = true;
					break;
				}
				
				if( Math.abs(queen.r - rr) == Math.abs(queen.c - rc) ) {
					vis[i] = true;
					break;
				}
			}
		}
		
		//킹이 움직일 곳이 있니?
		var flag = false;
		
		for (int i = 1; i < 9; i++) {
			if(!vis[i]) {
				flag = true;
				break;
			}
		}
		
		if( !flag && vis[0] )
			System.out.println("CHECKMATE");
		else if( flag && vis[0] )
			System.out.println("CHECK");
		else if( !flag && !vis[0])
			System.out.println("STALEMATE");
		else
			System.out.println("NONE");
		
	}
	
	private class Queen {
		int r,c;

		public Queen(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
}

