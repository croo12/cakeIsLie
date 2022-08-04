package com.beakjoon.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class SortWord {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		TreeSet<String> s = new TreeSet<>();
		for (int i = 0; i < n; i++) {
			s.add(br.readLine());
		}
		Iterator<String> iter = s.iterator();
		String[] ss = new String[s.size()];
		
		int cnt = 0;
		
		while(iter.hasNext()) {
			ss[cnt++] = (String)iter.next();
		}
		
		Arrays.sort(ss,new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return o1.length() - o2.length();
			}
		});
		
		for(String a : ss) System.out.println(a);
		
	}
}
