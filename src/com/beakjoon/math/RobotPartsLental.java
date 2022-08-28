package com.beakjoon.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class RobotPartsLental {
	
	static int lentalPeriod;
	static int penalty;
	static HashMap<String, Lent> lentList = new HashMap<>();
	static TreeMap<String, Long> penaltyList = new TreeMap<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		char[] cs = st.nextToken().toCharArray();
		lentalPeriod = ((cs[0] - '0')*100 + (cs[1] - '0')*10 + (cs[2] - '0'))*24*60 
				+ ((cs[4]-'0')*10 + (cs[5]-'0'))*60 
				+ (cs[7]-'0')*10 + cs[8]-'0';
		penalty = Integer.parseInt(st.nextToken());
		
//		System.out.println(lentalPeriod);

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			char[] calendar = st.nextToken().substring(5).toCharArray();
			int month = (calendar[0]-'0')*10 + (calendar[1]-'0');
			int day = (calendar[3]-'0')*10 + (calendar[4]-'0');
			char[] clock = st.nextToken().toCharArray();
			int time = ((clock[0]-'0')*10 + (clock[1]-'0'))*60 + (clock[3]-'0')*10 + (clock[4]-'0');
			String part = st.nextToken();
			String nickname = st.nextToken();
			
//			System.out.printf("%d월 %d일 %d분 \n",month,day,time);
			
			Lent lent = lentList.get(part+" "+nickname);
			if(lent == null) { //대여임
//				System.out.printf("%s 의 대여",nickname);
				lentList.put(part+" "+nickname, new Lent(month, day, time, nickname));
				
			}else { //반납임
				
				if(!lent.nickname.equals(nickname)) continue;
				
				int money = lent.penaltyCalc(month, day, time);
				lentList.put(part+" "+nickname, null);
				if(penaltyList.get(nickname) != null) {
					penaltyList.put(nickname, (penaltyList.get(nickname) + money));
				}else {
					penaltyList.put(nickname, (long)money);
				}
			}
		}//for
		StringBuilder sb = new StringBuilder();
		
		Iterator<String> iter = penaltyList.keySet().iterator();
		String now;
		boolean flag = false;
		while(iter.hasNext()) {
			now = iter.next();
			if(penaltyList.get(now) != 0) {
				sb.append(now).append(" ").append(penaltyList.get(now)).append("\n");
				flag = true;
			}
		}
		if(flag)System.out.print(sb);
		else System.out.println(-1);
	}
	
	static class Lent{
		int DEADLINE;
		String nickname;
		
		public Lent(int month, int day, int time, String nickname) {
			this.DEADLINE = parseDeadline(month, day, time) + lentalPeriod;
			this.nickname = nickname;
		}
		
		public int penaltyCalc(int month, int day, int time) {
			int returnDate = parseDeadline(month, day, time);
			int gap = returnDate - DEADLINE;
			return gap <= 0 ? 0 : gap*penalty;
		}
		
		private int parseDeadline(int month, int day, int time) {
			int deadline = 0;
			
			switch(month) {
			case 12 :
				deadline += 30;
			case 11 :
				deadline += 31;
			case 10 :
				deadline += 30;
			case 9 :
				deadline += 31;
			case 8 :
				deadline += 31;
			case 7 :
				deadline += 30;
			case 6 : 
				deadline += 31;
			case 5 :
				deadline += 30;
			case 4 :
				deadline += 31;
			case 3 :
				deadline += 28;
			case 2 : 
				deadline += 31;
			case 1 : 
				
			}
			deadline += day;
			deadline *= 24 * 60;
			deadline += time;
			
			return deadline;
		}
	}
}
