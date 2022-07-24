package com.beakjoon.greed;

import java.util.Scanner;

public class MultiTabSchedule { //틀렸당.
	public static void main(String[] args) {
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
		//무엇을 뺄것인가? --> 1. 남은 사용 횟수가 없는코드 // 2. 가장 재사용이 멀리있는 코드.
		
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
					}
				}
				if(!flag) { //재사용이 가장 먼 코드를 찾자
					int[] distance = new int[hole];//거리를 저장할 배열
					for (int j = 0; j < holes.length; j++) { //거리 조사
						for (int c = i; c < cmd.length; c++) { 
							if(holes[j] == cmd[c]) {
								distance[j] = c;
							}
						}
					}
					int max = 0;
					int num = -1;
					for (int k = 0; k < distance.length; k++) { // 멀티탭 num번째 있는 놈이 가장 나중에 쓰인다. 
						if(distance[k] > max) {
							max = distance[k];
							num = k;
						}
					}
					holes[num] = cmd[num];
					result++;
					time[cmd[i]]--;
					continue;
				}
			}
		}
		System.out.println(result);
		sc.close();
	}
	
	public static int checkHole(int[] holes, int cmd) { //전자제품 cmd가 이미 꽂혀 있는가?
		for (int i = 0; i < holes.length; i++) {
			if(holes[i]==cmd) return i;
		}
		return -1;
	}
	
	public static int searchEmptyHole(int[] holes) { //꽉차 있으면 -1
		for (int i = 0; i < holes.length; i++) {
			if(holes[i]==0) return i;
		}
		return -1;
	}
}
