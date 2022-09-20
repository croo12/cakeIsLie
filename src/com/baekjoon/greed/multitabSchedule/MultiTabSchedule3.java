package com.baekjoon.greed.multitabSchedule;

import java.util.Arrays;
import java.util.Scanner;

public class MultiTabSchedule3 { //메모리를 초과하면 안댐
								//재귀함수를 사용하니 메모리가 초과됨
	
	public static void main(String[] args) {
		MultiTabSchedule3 m = new MultiTabSchedule3();
		Scanner sc = new Scanner(System.in);
		int hole = sc.nextInt(); //멀티탭 갯수
		int use = sc.nextInt(); //명령 갯수
		
		int[] holes = new int[hole]; //멀티탭
		int[] cmd = new int[use];	//사용순서
		int[] time = new int[use+1]; //전자제품의 남은 사용 횟수
		
		int result = 0; //코드를 뽑은 횟수;
		
		for (int i = 0; i < cmd.length; i++) {
			cmd[i] = sc.nextInt();
			time[cmd[i]]++;
		}

		result = m.thinking(holes, cmd, time, result);
		
		System.out.println(result);
		sc.close();
	}
	
	public int thinking(int[] holes, int[] cmd, int[] time, int result) {
		for (int i = 0; i < cmd.length; i++) {
			if(checkHole(holes, cmd[i]) != -1) { // cmd[i]가 이미 꽂혀 있는 전자제품인가?
				time[cmd[i]]--;
				continue;
			}
			
			int check = searchEmptyHole(holes); 
			if(check != -1) { // 멀티탭에 빈칸이 있는가?
				holes[check] = cmd[i];
				time[cmd[i]]--;

			}else { //멀티탭에 빈칸이 없다면
				boolean flag = false;
				
				for (int j = 0; j < holes.length; j++) {//멀티탭에 꽂혀 있는 것 중 더 이상 안쓰는 코드가 있는가?
					if(time[holes[j]] == 0 && !flag) {
						holes[j] = cmd[i];
						result++;
						time[cmd[i]]--;
						flag = true;
						break;
					}
				}
				
				if(!flag) {
					time[cmd[i]]--;
					return thinking(holes, Arrays.copyOfRange(cmd, i+1, cmd.length) , time, result);
				}
			}
		}
		return result;
	}
	
	public int checkHole(int[] holes, int cmd) { //전자제품 cmd가 이미 꽂혀 있는가?
		for (int i = 0; i < holes.length; i++) {
			if(holes[i]==cmd) return i;
		}
		return -1;
	}
	
	public int searchEmptyHole(int[] holes) { //꽉차 있으면 -1
		for (int i = 0; i < holes.length; i++) {
			if(holes[i]==0) return i;
		}
		return -1;
	}
}
