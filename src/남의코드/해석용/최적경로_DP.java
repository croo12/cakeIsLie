package 남의코드.해석용;

import java.util.Arrays;
import java.util.Scanner;

public class 최적경로_DP {
	static int N;
	static int[][] points;
	static int INF = 987654321;
	static int cache[][];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			points = new int[N + 2][2]; //좌표들을 저장하기 위한 배열
			
			cache = new int[N + 2][1 << N + 2]; //메모이제이션용 배열
			
			for (int i = 0; i < N + 2; i++) { //배열 전부 -1로 채우기
				Arrays.fill(cache[i], -1);
			}
			
			for (int i = 0; i < N + 2; i++) { //좌표들 저장, 0하고 1은 회사 - 집;
				points[i][0] = sc.nextInt();
				points[i][1] = sc.nextInt();
			}
			
			int answer = INF; //답
			
			for (int i = 2; i < N + 2; i++) { //회사 집 빼고 나머지만 돌리기
				answer = Math.min(answer, Math.abs(points[i][0] - points[0][0]) + Math.abs(points[i][1] - points[0][1]) //스타트지점
						+ findMinDistance(i, 1 << i)); //스타트 체크한채 시작
			}
			
			sb.append("#" + t + " " + answer + "\n");
		}
		System.out.println(sb.toString());
		sc.close();
	}

	public static int findMinDistance(int node, int visited) {
		if (visited == (1 << N + 2) - 1 - 3) { //전부 다 방문한 경우
			return Math.abs(points[1][0] - points[node][0]) + Math.abs(points[1][1] - points[node][1]); //마지막 방문기준 + 집까지의 거리
		}
		if (cache[node][visited] != -1) 
			return cache[node][visited]; //이미 해본적 있으면 캐시에 저장된 부분 리턴하세요
		
		//살면서 처음와보는 길임
		int ret = INF;
		
		for (int next = 2; next < N + 2; next++) {
			if ((visited & 1 << next) == 0) { //안와본 길임
				ret = Math.min(ret, Math.abs(points[next][0] - points[node][0])	+ Math.abs(points[next][1] - points[node][1])  
				+ findMinDistance(next, visited | 1 << next)); //지금거리 + 그 뒤에 최단거리 계산하기
			}
		}
		
		return cache[node][visited] = ret; //이제 여기도 와본곳임
	}
}
