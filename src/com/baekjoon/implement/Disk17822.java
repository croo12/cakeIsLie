package com.baekjoon.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Disk17822 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		
		Disk[] disks = new Disk[N+1];
		for (int i = 1; i <= N; i++) {
			int[] data = new int[M];
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int now = Integer.parseInt(st.nextToken());
				Disk.total += now;
				data[j] = now;
			}
			disks[i] = new Disk(M, data);
		}
		
		//이 문제 근본적으로는 톱니바퀴랑 유사한 듯
		//구현
		//1. 회전시키고 봄
		//2. 모든 수 주변 뒤져서 같은 수가 있는지 탐색. 같은 수가 있으면 현재 위치 저장
		//3-T. 저장된 위치가 있다 -> 0으로 만들기
		//3-F. 저장된 위치가 없다 -> 평균 기준으로 숫자 변환시키기
		
		ArrayList<Pair> zero = new ArrayList<>();
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
			for (int j = x; j <= N; j+= x)
				disks[j].top -= dir == 0 ? k : -k;
			
			for (int r = 1; r <= N; r++) {
				for (int c = 0; c < M; c++) {
					Disk now = disks[r];
					int num = now.data[(now.top + c)%M];
					
					if(num == 0)
						continue;
					
					boolean flag = false;
					
					if(num == now.data[(now.top + c + 1)%M] || num == now.data[(now.top + c - 1)%M])
						flag = true;
					
					if(r != 1 && num == disks[r-1].data[(disks[r-1].top + c)%M] )
						flag = true;
						
					if(r != N && num == disks[r+1].data[(disks[r+1].top + c)%M] )
						flag = true;
					
					if(flag) {
						zero.add(new Pair(r, (now.top + c)%M));
					}
				}
			}
			
			int size = zero.size();
			if(size == 0) {
				double av = Disk.total/(double)Disk.cnt;
				for (int r = 1; r <= N; r++) {
					for (int c = 0; c < M; c++) {
						Disk now = disks[r];
						int num = now.data[(now.top + c)%M];
						if(num == 0)
							continue;
						
						if(num > av) {
							now.data[(now.top + c)%M] -= 1;
							Disk.total--;
						}else if(num < av) {
							now.data[(now.top + c)%M] += 1;
							Disk.total++;
						}
					}
				}
			}else {
				for (int j = size-1; j >= 0; j--) {
					Pair now = zero.get(j);
					Disk.total -= disks[now.diskN].data[now.num];
					Disk.cnt--;
					disks[now.diskN].data[now.num] = 0;
				}
				zero.clear();
			}
			
		}
		
		System.out.println(Disk.total);
	}
	
	static class Pair{
		int diskN;
		int num;
		Pair(int diskN, int num){
			this.diskN = diskN;
			this.num = num;
		}
	}
	
	static class Disk{
		static int total;
		static int cnt;
		int[] data;
		int top;
		Disk(int m, int[] data) {
			this.data = data;
			this.top = 51*m;
			cnt += m;
			
		}
	}
}
