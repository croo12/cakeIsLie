package 남의코드.해석용;

import java.io.*;
import java.util.*;

public class 빙산 {

	/*
	 * 빙산 1.빙산이 있는 부분 bfs 돌면서 level단위로 관리 해줘야하는데... 2.녹으면 바로 녹혀버리지말고 q에 넣어줘. 그리고
	 * 빼낸다음에 녹여줘. 3.분리된 타이밍을 언제 찾아내지? 3차원 visited..?
	 */
	static int n, m;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int[][] land;
	static boolean[][] visited;
	static List<Integer> list = new ArrayList<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		land = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				land[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		boolean flag = true;
		while (flag) {
			visited = new boolean[n][m];
			flag = false;
			int cnt = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (!visited[i][j] && land[i][j] > 0) {
						cnt++;
						flag = true;
						bfs(i, j);
					}
				}
			}
			list.add(cnt);
		}
		flag = false;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) > 1) {
				System.out.println(i);
				flag = true;
				break;
			}
		}
		if (!flag)
			System.out.println(0);

	}

	private static void bfs(int sr, int sc) {
		Queue<Integer> q = new ArrayDeque<>();
		Queue<Integer> q2 = new ArrayDeque<>();
		q.offer(sr); // r
		q.offer(sc); // c
		visited[sr][sc] = true;
		while (!q.isEmpty()) {
			int r = q.poll();
			int c = q.poll();
			int tmp = check(r, c);
			if (land[r][c] > tmp) {
				land[r][c] -= tmp;
			} else {// 나중에 녹이게 만들어주기.
				q2.offer(r);
				q2.offer(c);
			}
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if (nr < 0 || nc < 0 || nr >= n || nc >= m)
					continue;
				if (!visited[nr][nc] && land[nr][nc] > 0) {
					q.offer(nr);
					q.offer(nc);
					visited[nr][nc] = true;
				}
			}
		}
		while (!q2.isEmpty()) {
			int r = q2.poll();
			int c = q2.poll();
			land[r][c] = 0;
		}
	}

	private static int check(int r, int c) {
		int cnt = 0;
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if (nr < 0 || nc < 0 || nr >= n || nc >= m)
				continue;
			if (land[nr][nc] == 0) {
				cnt++;
			}
		}
		return cnt;
	}

}
