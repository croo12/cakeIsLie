package com.baekjoon.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sudoku2239 {
  public static void main(String[] args) {
    try {
      new Sudoku2239().solution();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  boolean[][] rowCheck = new boolean[9][10];
  boolean[][] colCheck = new boolean[9][10];
  boolean[][] squareCheck = new boolean[9][10];

  int[][] arr = new int[9][9];

  private void solution() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // char[][] arr = new char[9][9];
    String s;
    for (int i = 0; i < 9; i++) {
      s = br.readLine();
      for (int j = 0; j < 9; j++) {
        arr[i][j] = s.charAt(j) - '0';
        if (arr[i][j] != 0) {
          updateChecker(i, j, arr[i][j], true);
        }
      }

    }

    dfs(0, 0);

    System.out.print(sb);
    // System.out.println("end");
  }

  StringBuilder sb = new StringBuilder();
  boolean flag = false;

  private void dfs(int r, int c) {
    if (r == 9 && c == 0) {
      // System.out.println("hi");
      flag = true;

      for (int i = 0; i < 9; i++) {
        for (int j = 0; j < 9; j++) {
          sb.append(arr[i][j]);
        }
        sb.append('\n');
      }

      return;
    }

    if (flag)
      return;

    if (arr[r][c] == 0) {
      for (int i = 1; i <= 9 && !flag; i++) {
        if (!rowCheck[r][i] && !colCheck[c][i] && !squareCheck[r / 3 * 3 + c / 3][i]) {
          updateChecker(r, c, i, true);
          arr[r][c] = i;

          if (c + 1 == 9)
            dfs(r + 1, 0);
          else
            dfs(r, c + 1);

          if (flag) {
            return;
          }

          arr[r][c] = 0;
          updateChecker(r, c, i, false);
        }
      }
    } else {
      if (c + 1 == 9)
        dfs(r + 1, 0);
      else
        dfs(r, c + 1);
    }
  }

  private void updateChecker(int row, int col, int num, boolean change) {
    rowCheck[row][num] = change;
    colCheck[col][num] = change;
    squareCheck[row / 3 * 3 + col / 3][num] = change;
  }
}