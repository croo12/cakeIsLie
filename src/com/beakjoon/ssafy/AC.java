package com.beakjoon.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class AC {
	
	static List<Integer> list; //리스트
	static boolean isReversed = false;
	static String result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		while(T-- > 0) {
			list = new ArrayList<>();
			result = null;
			isReversed = false;
			
			String[] orders = br.readLine().split("");
			Integer.parseInt(br.readLine());
			String tmp = br.readLine();
			String[] s = tmp.substring(1,tmp.length()-1).split(","); //콤마로 잘랐더니 문제 발생함
			
			for (int i = 0; i < s.length; i++) {//숫자 입력받기
				try {
					list.add(Integer.parseInt(s[i]));
				}catch (Exception e) {
				}
			}
			
//			System.out.println(list);
			
			
			for (int i = 0; i < orders.length; i++) { //명령들 가동
				switch(orders[i]) {
					case "R" :
						R();
						break;
					case "D" :
						D();
						break;
				}
			}
			
			StringBuilder sb = new StringBuilder("[");
			if(result!=null) 
				result = "error";
			else if(isReversed)	{
				for(int i=0; i<list.size(); i++) {
					sb.append(list.get(list.size()-1-i));
					if(i != list.size() -1)
						sb.append(",");
				}
				sb.append("]");
				result = sb.toString();
			}else {
				for(int i=0; i<list.size(); i++) {
					sb.append(list.get(i));
					if(i != list.size() -1)
						sb.append(",");
				}
				sb.append("]");
				result = sb.toString();
			}
			System.out.println(result);
		}
	}//main
	
	private static void R() {
		if(isReversed) {
			isReversed = false;
		}else {
			isReversed = true;
		}
	}
	
	private static void D() { // 제일 앞에 빼기
		
		if(list.size() == 0) {
			result = "error";
			return;
		}
		if(isReversed) {
			list.remove(list.size()-1);
		}else {
			list.remove(0);
		}
	}
}
