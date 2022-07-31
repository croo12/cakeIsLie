package com.beakjoon.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class GuitarBluerayLesson {
//9 3
//	1 2 3 4 5 6 7 8 9
	
	static long times[];
	static long lectureNum;
	static long cdNum;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		lectureNum = Integer.parseInt(st.nextToken());
		cdNum = Integer.parseInt(st.nextToken());
		
		times = Arrays.stream(br.readLine().split(" ")).mapToLong(s -> Long.parseLong(s)).toArray() ;
		
		//long t = (Arrays.stream(times).sum() /(cdNum));
		long start = 1; //(t == 0 ? t : 1) ;
		long end = (100000 * 100000) + 1;
		long mid = (start + end)/2;
		
//		if(lectureNum == cdNum ) {
//			System.out.println(Arrays.stream(times).max().getAsLong());
//		}else {	
		while(end-start > 0) {
//			System.out.println(start+ "+" + end + "/2 : " + mid);
			if(make(mid)) {
				end = mid;
			}else {
				start = mid+1;
			}
			mid = (end+start)/2;
		}
		System.out.println(mid);
	}
	
	private static boolean make(long mid) { // 다 들어감?
		long cd = cdNum; //내가 가진 cd 갯수
		long now = mid; //cd의 길이
		
		cd--; //cd 한장 갖고 한다.
		
		for (int i = 0; i < times.length; i++) {
			if(now < times[i]) { // 남은 cd공간이 다음 강의 길이 보다 적다면
				cd--; //새cd꺼내기
				now = mid; //cd 공간 다시 풀충전 하기
				if(now < times[i]) { //풀충전한 길이도 작니?
					return false; // 그럼 이건 실패임
				}else {
					now -= times[i]; //풀충전 하니까 괜찮으면 새 cd에 강의 넣기
				}
			}else {
				now -= times[i];
			}	
		}
		
		
		if(cd < 0) return false; //cd부족
		else return true; //성공
	}
}
