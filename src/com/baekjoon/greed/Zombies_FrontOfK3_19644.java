package com.baekjoon.greed;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Zombies_FrontOfK3_19644 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int L = Integer.parseInt(br.readLine());
		boolean[] bomb = new boolean[L];
		
		//기관총의 사거리ML와 공격력MK
		StringTokenizer st = new StringTokenizer(br.readLine());
		int ML = Integer.parseInt(st.nextToken()), MK = Integer.parseInt(st.nextToken());
		//지뢰의 수
		int C = Integer.parseInt(br.readLine());

		//시간 제한 1초. L < 3 * 10^6 -> 3000000 입력 하나당 300번정도 연산 가능?
		//그냥 좀비들이 다가올때 기관총 계속 갈기다가 1m에 있는데도 못죽이면 폭탄 던져야하는거 아님?
		//-> 근데 폭탄 던질때는 기관총을 쏠 수 없다. 그걸 고려해야함!!
		
		//폭탄을 안던지다고 생각했을때 ML 바깥의 거리에 있는 좀비가 받는 기관총 피해는 MK * ML이다.
		//하지만 앞에 있는 좀비가 폭탄을 맞으면 ML이 1씩 줄어든다. 그 영향은 ML거리의 좀비까지 끼친다.
		
		// 1안 : 받는 데미지 거리에서 어떻게 잘 빼줘보기; 
		// 2안 : 수류탄 던질때마다 그 거리의 좀비 체력 올려주기 -> 엄청나게 많은 계산이 필요하다.
		
		//어떻게 뺄것인가? 좀비가 가장 앞에 온 순간 죽일 공격력이 모자라서 폭탄을 던진경우
		//ML거리의 좀비들은 기관총을 한번 적게 맞게 된다.
		//그 이후는 다시 돌아와야한다.
		
		//불린 배열을 만들어서 불린배열 지나면 다시 되돌리자
		
		//틀렸다. 왜일까?
		//One by off : ML 번째 좀비는 ML + 1만큼 기관총을 두들겨맞는게 아니다
		//중간에 뭔가 바보같은 생각으로 빠짐
		//+1 조건은 false 일때만 작동하는데 잘못 생각해서 좀비들이 상상 이상의 화력투사를 당하고 있었다
		
		//clear
		
		int idx = 0;
		int check = 0;
		
		while(idx < L) {
			int hp = Integer.parseInt(br.readLine());
			
			int times = ((idx >= ML - 1) ? ML : idx + 1) - check;
			
			int dmg = MK * times; 
			
			if(hp - dmg > 0) {
				C--;
				if(C == -1) {
					System.out.println("NO");
					return;
				}

				check++;
				if(idx + ML - 1 < L) bomb[idx + ML - 1] = true;  
			}	
				
			if(bomb[idx]) check--;
			idx++;
		}
		
		System.out.println("YES");
	}
}
