package com.baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ABCDE13023 {
	static ArrayList<Integer>[] roots;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		//사람 수 그리고 친구관계의 수
		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
		boolean[] check;
		roots = new ArrayList[N];
		
		while(M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int left = Integer.parseInt(st.nextToken());
			int right = Integer.parseInt(st.nextToken());
			
			if(roots[left] == null) 
				roots[left] = new ArrayList<>();
			roots[left].add(right);
			
			if(roots[right] == null) 
				roots[right] = new ArrayList<>();
			roots[right].add(left);
		}
		
		// A - B - C - D - E -> 즉
		// 어떤 점에서 깊이가 5인 탐색이 가능한지?
		// 제한시간 2초
		// N <= 2000 , M <= 2000; 
		// DFS 는 인접리스트로 구현할경우 간단히 가능할 것 같다.
		// 같은 칸에 또 들어가면 안되니까 boolean 배열 체크 필요함
		
		// 안된다.
		// 왜냐!!! 내가 체크하고 싶은건 ArrayList의 값인데 나는 ArrayList의 Index 잡고 끙끙대고 있었으니까
		// 또 안됨 ( NullPointer Exception )
		// 경로가 하나도 없는 원소가 있을 수도 있다. 거기에 들어게 된다면 ArrayList는 null일테고 
		// 당연히 NullPointer Exception이 나올 것이다.
		
		// 역시 통과
		
		for (int i = 0; i < N; i++) {
			check = new boolean[N];
			check[i] = true;
			dfs(i, 0, check);
		}
		
		if(flag) System.out.println(1);
		else System.out.println(0);
	}
	
	static boolean flag;
	
	static void dfs(int now, int depth, boolean[] check) {
		if(depth == 4) {
			flag = true;
			return;
		}
		
		ArrayList<Integer> next = roots[now];
		if(next == null) return;
		
		int len = next.size();
		for (int i = 0; i < len; i++) {
			if(flag) 
				return;
			
			int data = next.get(i);
			if(!check[data]) {
				check[data] = true;
				dfs(data, depth + 1, check);
				check[data] = false;
			}
		}
	}
}
