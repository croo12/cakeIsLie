package com.baekjoon.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LinkAndStart15661 {

	static int n;
	static boolean[] team;
	static Player[] players;

	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		players = new Player[n];

		StringTokenizer st;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			players[i] = new Player(n);
			for (int j = 0; j < n; j++) {
				players[i].score[j] = Integer.parseInt(st.nextToken());
			}
		}

		team = new boolean[n];
		makeTeam(0, 0);
		System.out.println(min);
	}

	private static void makeTeam(int idx, int depth) {
		if (depth == n / 2) {
			int powTrue = 0;
			int powFalse = 0;
			
			Player now;
			for (int i = 0; i < n; i++) {
				now = players[i];
				for (int j = 0; j < n; j++) {
					if(team[i] && team[j]) {
						powTrue += now.score[j];
					}
					if(!team[i] && !team[j]) {
						powFalse += now.score[j];
					}
				}
			}
			
			min = Math.min(min, Math.abs(powFalse-powTrue));
			return;
		}
		
		if(idx == n) {
			return;
		}

		team[idx] = true;
		makeTeam(idx + 1, depth + 1);
		team[idx] = false;
		makeTeam(idx + 1, depth);
	}

	static class Player {
		int[] score;

		public Player(int n) {
			score = new int[n];
		}
	}
}
