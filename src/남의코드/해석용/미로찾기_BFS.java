package 남의코드.해석용;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 미로찾기_BFS {

	static class Pair {
		int x, y;

		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		boolean[][] arr = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			String s = bf.readLine();
			for (int j = 0; j < m; j++) {
				if (s.charAt(j) == '0')
					arr[i][j] = true;
			}
		}
		
		Queue<Pair> q = new LinkedList<>();
		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };
		q.offer(new Pair(0, 0));
		arr[0][0] = true;
		
		int cnt = 0;
		
		loop: while (!q.isEmpty()) {
			int qsize = q.size();//q사이즈를 찾음
			
			for (int j = 0; j < qsize; j++) { //그만큼 돈다 
				
				Pair p = q.poll();
				
				for (int i = 0; i < 4; i++) {
					
					if (p.x + dr[i] < n && p.x + dr[i] >= 0 && p.y + dc[i] < m && p.y + dc[i] >= 0
							&& !arr[p.x + dr[i]][p.y + dc[i]]) {
						
						q.offer(new Pair(p.x + dr[i], p.y + dc[i]));
						
						if (p.x + dr[i] == n - 1 && p.y + dc[i] == m - 1)
							break loop;
						
						arr[p.x + dr[i]][p.y + dc[i]] = true;
						
					}
				}
			}
			
			cnt++;
		}
		
		System.out.println(cnt + 2); //시작과 끝 추가
	}
}
