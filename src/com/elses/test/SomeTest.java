package com.elses.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SomeTest {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] board = new int[100][100];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
	        st = new StringTokenizer(br.readLine());
	        int x = Integer.parseInt(st.nextToken());
	        int y = Integer.parseInt(st.nextToken());
	
	        for (int j = x; j < x + 10; j++) {
	            board[j][y]++;
	            board[j][y + 10]++;
	        }
	        for (int j = y; j < y + 10; j++) {
	            board[x][j]++;
	            board[x + 10][j]++;
	        }
	        for (int a = 0; a < 100; a++) {
	            for (int b = 0; b < 100; b++) {
	                System.out.print(board[a][b]);
	            }
	            System.out.println();
	        }
	    }

    }
}
