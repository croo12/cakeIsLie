package com.baekjoon.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BabyShark16236 {
	public static void main(String[] args) {
		try {
			new BabyShark16236().solution();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	int N;
	int[][] map;
	
	//위아래왼우로 움직이장
	int[] dr = {-1,1,0,0};
	int[] dc = {0,0,-1,1};

	private void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//맵 사이즈와 맵
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		Shark baby = null;
		
		//맵 만들기
		String[] tmp;
		for (int i = 0; i < N; i++) {
			tmp = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				if(tmp[j].equals("0")) continue;
				
				if(tmp[j].equals("9")) { 
					baby = new Shark(i, j);				
					continue;
				}
				
				map[i][j] = Integer.parseInt(tmp[j]);				
			}
		}
		
		int ans = 0;
		int now;
		
		//사냥하기
		while(true) {
			now = baby.hunting();
			
			//물고기 없으면 끝
			if(now == -1) {
				System.out.println(ans);
				return;
			}
			
			ans+= now;
		}
	}
	
	private class Shark {
		//상어 좌표
		int r,c;
		
		//상어 크기
		int size;
		
		//상어 뱃속에 있는 물고기 수
		int eated;
		
		//bfs용 pq
		PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
			@Override
			public int compare(Pair o1, Pair o2) {
				int cnt = Integer.compare(o1.cnt, o2.cnt);
				if(cnt == 0) {
					int height = Integer.compare(o1.r, o2.r);
					if(height == 0) {
						return Integer.compare(o1.c, o2.c);
					}
					return height;
				}
				return cnt;
			}
		});

		public Shark(int r, int c) {
			super();
			this.r = r;
			this.c = c;
			
			this.size = 2;
		}
		
		//물고기 사냥하기
		//사냥 가능한 물고기가 없으면 -1
		int hunting(){
			pq.clear();
			
			boolean[][] vis = new boolean[N][N];
			
			pq.offer(new Pair(this.r, this.c, 0));
			vis[this.r][this.c] = true;
			
			Pair now;
			while(!pq.isEmpty()) {
				now = pq.poll();
				
//				System.out.println(now);
				//내 자리가 나보다 작은 물고기임
				if(map[now.r][now.c] != 0 && map[now.r][now.c] < this.size) {
					
					//물고기 먹고 배채움
					this.r = now.r;
					this.c = now.c;
					map[now.r][now.c] = 0;
					this.eated++;
					
					//진화 가능?
					if(this.eated == this.size) {
						this.size++;
						this.eated = 0;
					}
					
					//몇초걸림?
					return now.cnt;
				}
				
				for(int k=0; k < 4; k++) {
					int nr = now.r + dr[k];
					int nc = now.c + dc[k];
					
					if(nr >= N || nr < 0 || nc >= N || nc < 0 || vis[nr][nc] || map[nr][nc] > this.size) continue;
					
					vis[nr][nc] = true;
					pq.offer(new Pair(nr, nc, now.cnt + 1));
				}
				
				
			}
			
			return -1;
		}
	}
	
	class Pair{
		int r,c,cnt;

		public Pair(int r, int c, int count) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = count;
		}

		@Override
		public String toString() {
			return "Pair [r=" + r + ", c=" + c + ", cnt=" + cnt + "]";
		}
	}
}
