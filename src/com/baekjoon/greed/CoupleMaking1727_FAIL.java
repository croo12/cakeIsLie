package com.baekjoon.greed;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//틀린이유
// 가장 맘이 맞는 사람이 여럿이고
// 그 중 하나의 경우만 정답일 때가 있음

public class CoupleMaking1727_FAIL {
  public static void main(String[] args) {
    try {
      new CoupleMaking1727_FAIL().solution();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private void solution() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int MALE = Integer.parseInt(st.nextToken());
    int FEMALE = Integer.parseInt(st.nextToken());

    int[] male = new int[MALE];
    int[] female = new int[FEMALE];

    // 최고의 짝을 찾으려 한다...
    // 당연히 나랑 가장 적은 차이인 사람 만나는게 베스트임
    // 나랑 젤 잘맞는 사람 찾기
    // 그 사람에게 이미 짝이 있다면 승부보기
    // 지면 그 다음으로 잘맞는 사람 찾기

    st = new StringTokenizer(br.readLine(), " ");
    for (int i = 0; i < MALE; i++) {
      male[i] = Integer.parseInt(st.nextToken());
    }

    st = new StringTokenizer(br.readLine(), " ");
    for (int i = 0; i < FEMALE; i++) {
      female[i] = Integer.parseInt(st.nextToken());
    }

    int ans = 1_000_000_001;

    if (MALE > FEMALE) {
      diff = new int[FEMALE][2];

      for (int[] i : diff) {
        i[0] = ans;
        i[1] = -1;
      }

      waitingNumber = FEMALE;
      end = MALE;

      match(female, male, 0, true);
    } else {
      diff = new int[MALE][2];

      for (int[] i : diff) {
        i[0] = ans;
        i[1] = -1;
      }

      waitingNumber = MALE;
      end = FEMALE;

      match(male, female, 0, true);
    }

    ans = 0;
    for (int[] i : diff) {
      ans += i[0];
    }

    System.out.println(ans);
  }

  int[][] diff;
  int waitingNumber;
  int end;

  private void match(int[] waiting, int[] challenger, int num, boolean flag) {
    if (num == end) {
      return;
    }

    int challengerMind = challenger[num];
    // 가장 맘이 맞는 사람
    int best = 1_000_000_001;
    // 고백한 사람
    int theMan = -1;

    for (int i = 0; i < waitingNumber; i++) {
      int gap = Math.abs(challengerMind - waiting[i]);
      if (gap < diff[i][0] && gap < best) {
        best = gap;
        theMan = i;
      }
    }

    // 솔로로 남게됨
    if (theMan == -1) {
      if (flag) {
        match(waiting, challenger, num + 1, flag);
      }
      return;
    }

    diff[theMan][0] = best;

    // 전에 얘랑 사귀던 애
    int last = diff[theMan][1];
    // 이제 내가 사귐
    diff[theMan][1] = num;

    if (last != -1) {
      // 전 남친도 새로운 사람 찾아 떠난다
      match(waiting, challenger, last, false);
    }

    // 다음 사람 출동
    if (flag)
      match(waiting, challenger, num + 1, flag);
  }
}