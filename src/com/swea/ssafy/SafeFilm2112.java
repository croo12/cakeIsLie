package com.swea.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SafeFilm2112 {
	
	static int ans;
	static int D, W, K;
	static boolean[][] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st =new StringTokenizer(br.readLine());
			D=Integer.parseInt(st.nextToken()); 
			W=Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			arr = new boolean[D][W];
			for (int i = 0; i < D; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					arr[i][j] = st.nextToken().equals("1");
				}
			}
			
			ans = K;
			//검사해야하는 칸이 W칸임 <= 20 ,, 바꿀때 선택할 수 있는 칸이 D칸임 <= 13
			
			int[] cnt = new int[W];
			for (int i = 0; i < W; i++)
				cnt[i] = 1;
			boolean[] check = new boolean[W];
			if(K == 1) {
				for (int i = 0; i < W; i++) {
					check[i] = true;
				}
			}
			dfs(1,0,-1,cnt,check);
			dfs(1,1,0,cnt,check);
			dfs(1,1,1,cnt,check);
			
			sb.append("#"+tc+" "+ans+"\n");
		}
		System.out.print(sb);
	}
	
	//use -1 약 안씀, use 0 0으로, use 1 1으로
	static void dfs(int depth, int count, int use, int[] cnt, boolean[] check) {
		if(count == K) {
			return;
		}
		
		if(depth == D) {
			for(int i=0; i < W; i++) {
				if(!check[i]) {
					return;
				}
			}
			
			ans = Math.min(ans, count);
			
			return;
		}
		
		int[] nowCnt1 = cnt.clone();
		boolean[] nowCheck1 = check.clone();
		
		//이전 칸과 나 비교 //내가 순정인 버전
		for (int i = 0; i < W ; i++) {
			if((use == -1 && arr[depth-1][i] == arr[depth][i]) 
				|| (use == 0 && !arr[depth][i]) 
				|| (use == 1 && arr[depth][i])) 
			{
				if(++nowCnt1[i] == K)
					nowCheck1[i] = true;
			}else {
				nowCnt1[i] = 1;
			}
		}
		dfs(depth+1,count,-1,nowCnt1, nowCheck1);
		
		int[] nowCnt2 = cnt.clone();
		boolean[] nowCheck2 = check.clone();
		
		for (int i = 0; i < W ; i++) {
			if((use == -1 && !arr[depth-1][i]) || use == 0) 
			{
				if(++nowCnt2[i] == K)
					nowCheck2[i] = true;
			}else {
				nowCnt2[i] = 1;
			}
		}
		dfs(depth+1,count+1,0,nowCnt2, nowCheck2);
		
		int[] nowCnt3 = cnt.clone();
		boolean[] nowCheck3 = check.clone();
		
		for (int i = 0; i < W ; i++) {
			if((use == -1 && arr[depth-1][i]) || use == 1) 
			{
				if(++nowCnt3[i] == K)
					nowCheck3[i] = true;
			}else {
				nowCnt3[i] = 1;
			}
		}
		dfs(depth+1,count+1,1,nowCnt3, nowCheck3);
	}
}
