package com.beakjoon.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PartOfString {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		String P = br.readLine();
		
		if(S.indexOf(P) == -1) {
			System.out.println(0);
		}else {
			System.out.println(1);
		}
	}
}
