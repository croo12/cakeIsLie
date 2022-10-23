package com.baekjoon.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class DSLR9019 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		//무한 숨바꼭질
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		boolean[] vis;
		int start;
		int end;
		Pair now;
		Queue<Pair> q = new ArrayDeque<>();
		while(N-- > 0) {
			st = new StringTokenizer(br.readLine());
			start = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());
			
			vis = new boolean[10000];
			
			q.offer(new Pair(start, '\0', null));
			vis[start] = true;
			
			while(!q.isEmpty()) {
				now = q.poll();
				
				int tmp = now.num;
				if(tmp == end) {
					StringBuilder tmpSB = new StringBuilder();
					for (Pair i = now; i.data != '\0'; i = i.prev) {
						tmpSB.append(i.data);
					}
					sb.append(tmpSB.reverse()).append('\n');
					break;
				}
				//D
				if(!vis[(tmp*2 > 9999) ? tmp*2%10000 : tmp*2]) {
					vis[(tmp*2 > 9999) ? tmp*2%10000 : tmp*2] = true;
					q.offer(new Pair((tmp*2 > 9999) ? tmp*2%10000 : tmp*2, 'D', now));
				}
				//S
				if(!vis[(tmp-1) < 0 ? 9999 : (tmp-1)]) {
					vis[(tmp-1) < 0 ? 9999 : (tmp-1)] = true;
					q.offer(new Pair((tmp-1) < 0 ? 9999 : (tmp-1), 'S', now));
				}
				//L
				if(!vis[tmp*10%10000 + tmp/1000]) {
					vis[tmp*10%10000 + tmp/1000] = true;
					q.offer(new Pair(tmp*10%10000 + tmp/1000, 'L', now));
				}
				//R
				if(!vis[tmp/10 + tmp*1000%10000]) {
					vis[tmp/10 + tmp*1000%10000] = true;
					q.offer(new Pair(tmp/10 + tmp*1000%10000, 'R', now));
				}
			}
			q.clear();
		}
		System.out.print(sb);
	}
	
	static class Pair{
		int num;
		char data;
		Pair prev;
		public Pair(int num, char command, Pair prev) {
			this.num = num;
			this.data = command;
			this.prev = prev;
		}
	}
}
