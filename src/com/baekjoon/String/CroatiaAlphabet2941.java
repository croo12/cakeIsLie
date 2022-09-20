package com.baekjoon.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CroatiaAlphabet2941 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int cnt = 0;
	
	public static void main(String[] args) throws IOException {//fail
		
		String s = br.readLine();
		s=s.replaceAll("c=", "C");
		s=s.replaceAll("c-", "B");
		s=s.replaceAll("dz=", "D");
		s=s.replaceAll("d-", "E");
		s=s.replace("lj","A");
		s=s.replaceAll("nj", "F");
		s=s.replaceAll("s=", "G");
		s=s.replaceAll("z=", "H");
		
		System.out.println(s.length());
	}
}
