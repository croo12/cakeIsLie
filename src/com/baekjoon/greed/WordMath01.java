package com.baekjoon.greed;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class WordMath01 { // 아 알파벳 A부터 Z까지 다받는거였네
	static String big = "";
	static int cnt = 0;
	static String[] key_index = {"A","B","C","D","E","F","G","H","I","J","K",
			"L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
	static Integer[] ans = new Integer[26];

	static Map<String, Integer> index = new HashMap<>();
	
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
		//제일 긴 길이의 글자의 첫번쨰 글자에 가장 큰 수를 줌.
		
		int n = Integer.parseInt(br.readLine());
		String[] words = new String[n];
		for (int i = 0; i < n; i++) {
			words[i] = br.readLine();
		}
		
		sortAndFor(words);
		for (int i = 0; i < key_index.length; i++) {
			if(index.get(key_index[i]) != null)
				ans[i] = index.get(key_index[i]);
		}
		
		Arrays.sort(ans, new Comparator<Integer>(){
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				if(o1 == null && o2 == null) return 0;
				if(o1 == null) return 1;
				if(o2 == null) return -1;
				return o2 - o1;
			}
		});
		
		long sum = 0;
		int cnt = 9;
		for(int i = 0; i < ans.length; i++) {
			if(ans[i] == null) break;
//			System.out.print(ans[i] +" ");
			sum += ans[i]*cnt--;
		}
		
		System.out.println(sum);
	}
	
	public static int sortAndFor(String[] words) {
		
		Arrays.sort(words, comp);
		
		if(words[0] == null) {
			return 1;
		}else {
			big = words[0];
		}
		
		if(big.length() > 1) {
			big = big.substring(0,1);
		}else {
			big = words[0];
		} // 제일 긴 배열의 첫번째 글자
		
		int tmp = 1;
		
		for (int i = 1; i < words[0].length(); i++) {
			tmp *= 10;
		}
		
		if(index.get(big) != null) {
			index.put(big, index.get(big) + tmp);
		}else {
			index.put(big, tmp);
		}
		
		if(words[0].length()>1) {
			words[0] = words[0].substring(1);
		}else {
			words[0] = null;
		}
		
		return sortAndFor(words);
	}
}
