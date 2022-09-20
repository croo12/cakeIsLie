package com.baekjoon.greed.multitabSchedule;

import java.util.Arrays;
import java.util.Scanner;

public class MultiTabSchedule02 { //메모리 초과됐다.
								//생각해보니 당연함.문제를 그냥 재귀함수로 내일의 나에게 떠넘겼는데
								//내일의 나도 모르니까 그냥 걔도 내일의 나 호출하고 무한반복인것
	
	public static void main(String[] args) {
		MultiTabSchedule02 m = new MultiTabSchedule02();
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
		//실행을 함.
		//나온 순서대로 빈멀티탭에 맞는 코드를 뽑는다.
		//멀티탭이 꽉 찼는데 새 코드를 뽑아야 하는 경우 기존 코드를 빼야한다.
		//무엇을 뺄것인가? --> 1. 남은 사용 횟수가 없는코드 
		//남은 명령으로 다시 알고리즘을 수행한다.
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
					return thinking(holes, Arrays.copyOfRange(cmd, i, cmd.length) , time, result);
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
