package com.baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Serveil15683 {
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };
	// 아래, 위, 오른쪽, 왼쪽

	static Room[][] room;
	static int height;
	static int width;

	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		height = Integer.parseInt(st.nextToken());
		width = Integer.parseInt(st.nextToken());
		room = new Room[height][width];
		for (int i = 0; i < height; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < width; j++) {
				room[i][j] = new Room(Integer.parseInt(st.nextToken()));
			}
		}
		doSurveil(0, 0);
		System.out.println(min);
	}

	static boolean[][] checker;
	
	private static void doSurveil(int x, int y) {
		if (x == width && y == height - 1) {
			checker = new boolean[height][width];
			int cnt = 0;
			Room tmp;
			for (int i = 0; i < height; i++) {
				for (int j = 0; j < width; j++) {
					tmp = room[i][j];
					switch(tmp.type) {
					case 1:
						cnt+= goLight(j,i,tmp.mod - 1);
						break;
					case 2:
						if(tmp.mod == 1) {
							cnt+=goLight(j, i, 0);
							cnt+=goLight(j, i, 1);
						}else {
							cnt+=goLight(j, i, 2);
							cnt+=goLight(j, i, 3);
						}
						break;
					case 3:
						if(tmp.mod == 1) {
							cnt+=goLight(j, i, 0);
							cnt+=goLight(j, i, 2);
						}else if(tmp.mod == 2) {
							cnt+=goLight(j, i, 0);
							cnt+=goLight(j, i, 3);
						}else if(tmp.mod == 3) {
							cnt+=goLight(j, i, 1);
							cnt+=goLight(j, i, 2);
						}else {
							cnt+=goLight(j, i, 1);
							cnt+=goLight(j, i, 3);
						}
						break;
					case 4:
						if(tmp.mod == 1) {
							cnt+=goLight(j, i, 0);
							cnt+=goLight(j, i, 1);
							cnt+=goLight(j, i, 2);
						}else if(tmp.mod == 2) {
							cnt+=goLight(j, i, 0);
							cnt+=goLight(j, i, 1);
							cnt+=goLight(j, i, 3);
						}else if(tmp.mod == 3) {
							cnt+=goLight(j, i, 0);
							cnt+=goLight(j, i, 2);
							cnt+=goLight(j, i, 3);
						}else {
							cnt+=goLight(j, i, 1);
							cnt+=goLight(j, i, 2);
							cnt+=goLight(j, i, 3);
						}
						break;
					case 5:
						cnt+=goLight(j, i, 0);
						cnt+=goLight(j, i, 1);
						cnt+=goLight(j, i, 2);
						cnt+=goLight(j, i, 3);
						break;
					default : 
					}//switch
				}
			}//for
//			System.out.println(cnt + " = 의 값");
			min = Math.min(Room.blindSpot - cnt, min);
			
			return;
		}	
		if (x == width) {
			doSurveil(0, y + 1);
			return;
		}
		
		
		Room now = room[y][x];
//		System.out.printf("x : %d , y : %d 진행 중 type : %d , %d\n",x,y,now.type);
		if (now.type == 0 || now.type == 6)
			doSurveil(x + 1, y);
		else {
			now.mod = 1;
			doSurveil(x + 1, y);

			if (now.type != 5) {
				room[y][x].mod = 2;
				doSurveil(x + 1, y);
			}
			
			if (now.type != 5 && now.type != 2) {
				room[y][x].mod = 3;
				doSurveil(x + 1, y);
				
				room[y][x].mod = 4;
				doSurveil(x + 1, y);
			}
		}
	}

	private static int goLight(int x, int y, int dir) {
		// 아래 위 오른쪽 왼쪽
		int nx = x;
		int ny = y;
		int cnt = 0;
		
		while (nx >= 0 && nx < width && ny >= 0 && ny < height) {

			if (room[ny][nx].type == 6)
				break;

			if (room[ny][nx].type == 0 && !checker[ny][nx]) {
				checker[ny][nx] = true;
				cnt++;
			}
			
			nx = nx + dx[dir];
			ny = ny + dy[dir];
		}
		
		return cnt;
	}

	static class Room {
		static int blindSpot;
		int type;
		int mod;

		public Room(int type) {
			this.type = type;
			if (type == 0)
				blindSpot++;
		}

	}
}
