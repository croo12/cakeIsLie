package com.baekjoon.binaryBit;

import java.util.Scanner;

public class EightToTwo {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String e = sc.nextLine();
		StringBuilder sb = new StringBuilder();
		int len = e.length();
		
		switch(e.charAt(0) - '0') {
		case 0 : 
			sb.append("0");
			break;
		case 1 :
			sb.append("1");
			break;
		case 2 :
			sb.append("10");
			break;
		case 3 :
			sb.append("11");
			break;
		case 4 :
			sb.append("100");
			break;
		case 5 :
			sb.append("101");
			break;
		case 6 :
			sb.append("110");
			break;
		case 7 :
			sb.append("111");
			break;
		}
		
		for (int i = 1; i < len; i++) {
			switch(e.charAt(i) - '0') {
			case 0 : 
				sb.append("000");
				break;
			case 1 :
				sb.append("001");
				break;
			case 2 :
				sb.append("010");
				break;
			case 3 :
				sb.append("011");
				break;
			case 4 :
				sb.append("100");
				break;
			case 5 :
				sb.append("101");
				break;
			case 6 :
				sb.append("110");
				break;
			case 7 :
				sb.append("111");
				break;
			}
		}
		
		System.out.println(sb);
		sc.close();
	}
}
