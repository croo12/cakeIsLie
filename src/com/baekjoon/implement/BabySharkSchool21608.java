package com.baekjoon.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BabySharkSchool21608 {
	public static void main(String[] args) {
		try {
			new BabySharkSchool21608().solution();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	int N;
	int[][] map;

	private void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 교실길이
		N = Integer.parseInt(br.readLine());
		// 학생 명부
		Student[] sts = new Student[N * N + 1];
		// 교실
		map = new int[N][N];

		StringTokenizer st;

		// 자 간다
		for (int i = 0; i < N * N; i++) {
			st = new StringTokenizer(br.readLine());

			var num = Integer.parseInt(st.nextToken());

			int[] fav = { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };

			// 학생 생성하기
			sts[num] = new Student(fav);

			// 자리 찾아가기
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					// 빈자리임?
					if (map[j][k] == 0)
						// 자리찾기 기계에 넣어버림
						pq.offer(new Pair(j, k, sts[num]));
				}
			}

			// 최고의 자리
			Pair best = pq.poll();
			// 앉기
			map[best.r][best.c] = num;

			// 자리찾기 기계 청소
			pq.clear();
		}
		// 다 앉음

		// 점수계산
		var ans = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int[] fav = sts[ map[i][j] ].fav;
				
				//주변 자리에 좋아하는 애 몇명?
				int cnt = 0;
				
				for (int k = 0; k < 4; k++) {
					var rr = i + dr[k];
					var rc = j + dc[k];
					
					if(rr >= N || rc >= N || rr < 0 || rc < 0) continue;
					
					for(var favStudent : fav) {
						if(map[rr][rc] == favStudent) {
							cnt++;
						}
					}
				}
				
				switch(cnt) {
					case 1: ans += 1;
						break;
					case 2: ans += 10;
						break;
					case 3: ans += 100;
						break;
					case 4: ans += 1000;
						break;
					default:
				}
			}
		}

		System.out.println(ans);
	}

	private class Student {
		int[] fav;

		public Student(int[] fav) {
			super();
			this.fav = fav;
		}
	}

	int[] dr = { 0, 0, -1, 1 };
	int[] dc = { -1, 1, 0, 0 };

	// 자리 찾는 기계
	PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
		// 자리찾기 방법
		@Override
		public int compare(Pair o1, Pair o2) {
			int fav = Integer.compare(o2.fav, o1.fav);
			if (fav == 0) {
				int blank = Integer.compare(o2.blank, o1.blank);
				if (blank == 0) {
					int height = Integer.compare(o1.r, o2.r);
					if (height == 0) {
						return Integer.compare(o1.c, o2.c);
					}
					return height;
				}
				return blank;
			}
			return fav;
		}
	});

	private class Pair {
		// 가로 세로
		int r, c;
		// 빈자리 선호하는 자리
		int blank, fav;

		Pair(int r, int c, Student student) {
			this.r = r;
			this.c = c;
			this.fav = 0;
			this.blank = 0;

			// 4방 탐색해서 빈칸갯수와 좋아하는 학생 수 찾기
			for (int i = 0; i < 4; i++) {
				int rr = r + dr[i];
				int rc = c + dc[i];

				// 범위에서 나감?
				if (rr >= N || rc >= N || rr < 0 || rc < 0)
					continue;

				// 빈칸임?
				if (map[rr][rc] == 0) {
					this.blank++;

					// 누군가 앉아있네...
				} else {
					// 좋아하는 학생임?
					for (var fStudent : student.fav) {
						if (map[rr][rc] == fStudent) {
							this.fav++;
							break;
						}
					}
				}
			}
		}
	}
}
