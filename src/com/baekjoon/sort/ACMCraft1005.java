package com.baekjoon.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ACMCraft1005 {
	public static void main(String[] args) {
		try {
			new ACMCraft1005().solution();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	BufferedReader br;

	private void solution() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		var sb = new StringBuilder();

		int N, K;
		while(T-- > 0){
			var st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			sb.append(getAns(N, K)).append('\n');
		}

		System.out.print(sb);
	}

	private int getAns(int N, int K) throws IOException {
		int[] arr = new int[N+1];
		var stz = new StringTokenizer(br.readLine());

		for (int i = 1; i <= N; i++){
			arr[i] = Integer.parseInt(stz.nextToken());
		}

		ArrayList<Integer>[] build = new ArrayList[N+1];
		int[] bef = new int[N+1];

		for (int i = 1; i <= N; i++)
			build[i] = new ArrayList<Integer>();

		int st, ed;
		for (int i = 0; i < K; i++){
			stz = new StringTokenizer(br.readLine());
			st = Integer.parseInt(stz.nextToken());
			ed = Integer.parseInt(stz.nextToken());

			build[st].add(ed);
			bef[ed]++;
		}

		int last = Integer.parseInt(br.readLine());

		var now = new ArrayList<Integer>();

		for (int i = 1; i <= N; i++){
			if(bef[i] == 0){
				now.add(i);
			}
		}

		int time = 0;
		while(true){
			//건설중인 건물 돌기
			for(int i = 0; i < now.size(); i++){
				//건설시간이 0임?
				if(arr[now.get(i)] == 0){
					if(now.get(i) == last)
						return time;

					//그러면 다음 테크 건물 찾아보기
					for (var num : build[now.get(i)]){

						if( num != 0){

							//-- 하기
							bef[num]--;

							//0이 됐나요?
							if(bef[num] == 0){
								if(num == last)
									return time + arr[num];

								now.add(num);
							}
						}
					}
					now.remove(i);
					i--;
				}
			}

			for(var num : now){
//				System.out.println("짜잔 숫자 : " + num);
				arr[num]--;
			}

			time++;
		}
	}
}

