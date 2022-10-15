package com.baekjoon.daq.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DandD {
	
	static long MAX_HP;
	static long c_hp;
	static long ATK;
	static long atk;
	static Dungeon[] dungeons;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		ATK = Integer.parseInt(st.nextToken());
		dungeons = new Dungeon[n];
		for (int i = 0; i < n; i++) {
			dungeons[i] = new Dungeon(br.readLine().split(" "));
//			System.out.println(dungeons[i]);
		}
		
		long start = 1;
		long end = (long)1000000 * 1000000 * 123456;
		long mid = (start + end)/2;
		
//		System.out.println(end);
		
		while(end - start >= 0) {
//			System.out.println(mid);
			if(goAdventure(mid)) {
				if(goAdventure(mid-1)) {
					end = mid -1;
				}else {
					System.out.println(mid);
					break;
				}
			}else {
				start = mid + 1;
			}
			mid = (start + end)/2;
		}
		
	}
	
	private static boolean goAdventure(long mid) {
		MAX_HP = mid;
		c_hp = mid;
		atk = ATK;
		
		for (int i = 0; i < dungeons.length; i++) {
			Dungeon now = dungeons[i];
//			System.out.println(i+"번 던전 입장");
			if(now.type == 2) {
				atk += now.a;
				c_hp += now.h;
				if(c_hp > MAX_HP) c_hp = MAX_HP;
			}else {
				boolean win = fight(now.a, now.h);
				if(win) {}
				else return false;
			}
		}//for
		return true;
	}
	
	private static boolean fight(long ap, long hp) { // 승리 true// 패배 false
//		System.out.println("나의 체력 : " + c_hp);
//		System.out.println("적의 체력 : " + hp);
//		System.out.println("나의 공격 : " + atk);
//		System.out.println("적의 공격 : " + ap);
		if(hp % atk ==0) {
			c_hp -=  ap*(hp/atk - 1); 
		}else {
			c_hp -=  ap*(hp/atk);
		}
//		System.out.println("남은 체력 : "+c_hp);
		
		if(c_hp <= 0) return false;
		else return true;
		
//		while(hp > 0 && c_hp > 0) {
//			hp -= atk; //1. 용사가 공격
//			if(hp < 0 ) return true;
//			c_hp -= ap;
////			System.out.println("남은 체력 : " + c_hp);
//		}
	}
	
}

class Dungeon {
	int type;
	int a;
	int h;
	public Dungeon(String[] s) {
		this.type = Integer.parseInt(s[0]);
		this.a = Integer.parseInt(s[1]);
		this.h = Integer.parseInt(s[2]);
	}
}