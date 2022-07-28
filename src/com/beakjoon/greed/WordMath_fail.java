package com.beakjoon.greed;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class WordMath_fail {
	static String big = "";
	static int cnt = 9;
	static String[] index = new String[10];
	static long sum = 0;
	
	static Comparator<String> comp = new Comparator<String>() {
		@Override
		public int compare(String o1, String o2) {
			// TODO Auto-generated method stub
			if(o1 == null) return 1;
			else if(o2 == null) return -1;
			else if(o1.length() == o2.length()) return 0;
			else if(o1.length() > o2.length()) return -1;
			else return 1;
		}
	};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//글자 배열을 글자 길이순으로 정렬함
		//
		//제일 긴 길이의 글자의 첫번쨰 글자에 가장 큰 수를 줌.
		//
		
		int n = Integer.parseInt(br.readLine());
		String[] words = new String[n];
		String[] last = new String[n];
		System.arraycopy(words, 0, last, 0, n);
		for (int i = 0; i < n; i++) {
			words[i] = br.readLine();
		}
		
		sortAndFor(words);
		for(String s : index) System.out.print(s+" ");
		System.out.println(sum);
	}
	
	public static int sortAndFor(String[] words) {
		
		Arrays.sort(words, comp);
		
		if(words[0] == null) {
			return 1;
		}
		
		big = words[0];
		if(big.length() > 1)
			big = big.substring(0,1);

		if(!Arrays.stream(index).anyMatch(s -> big.equals(s))) { // 이거 자릿수 합 구하는거 써서 제일 높은 숫자 가진 애한테 다 몰아줘야함
			int tmp = cnt;
			index[cnt--] = big;
			for (int i = 1; i < words[0].length(); i++) {
				tmp *= 10;
			}
			sum += tmp;
		}else {
			int tmp = 0;
			for (int i = 0; i < index.length; i++) {
				if(big.equals(index[i])) {
					tmp = i;
				}
			}
			for (int i = 1; i < words[0].length(); i++) {
				tmp *= 10;
			}
			sum+=tmp;
		}
		if(words[0].length()>1) {
			words[0] = words[0].substring(1);
		}else {
			words[0] = null;
		}
		
		return sortAndFor(words);
	}
}
