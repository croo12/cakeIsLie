package com.baekjoon.greed;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CoupleMaking1727 {
  public static void main(String[] args) {
    try {
      new CoupleMaking1727().solution();
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

    //최고의 짝을 찾으려 한다...
    //당연히 나랑 가장 적은 차이인 사람 만나는게 베스트임
    //나랑 젤 잘맞는 사람 찾기
    //그 사람에게 이미 짝이 있다면 승부보기
    //지면 그 다음으로 잘맞는 사람 찾기

    st = new StringTokenizer(br.readLine(), " ");
    for (int i = 0; i < MALE; i++) {
      male[i] = Integer.parseInt(st.nextToken());
    }

    st = new StringTokenizer(br.readLine(), " ");
    for (int i = 0; i < FEMALE; i++) {
      female[i] = Integer.parseInt(st.nextToken());      
    }

    Arrays.sort(male);
    Arrays.sort(female);

    int ans = 1_000_000_001;
    if(MALE > FEMALE){
      ans = match(female, male, MALE);
    }else{
      ans = match(male, female, FEMALE);
    }
    System.out.println(ans);
  }

  private int match(int[] waiting, int[] challenger, int length) {
    boolean[] isSelected = new boolean[length];
    
    int sum = 0;
    for (int me : waiting) {
      int min = 1_000_001;
      int last = -1;
      for (int i = 0; i < length; i++) {
        int now = Math.abs(challenger[i] - me);
        if( !isSelected[i] && now < min){
          min = now;
          if(last != -1){
            isSelected[last] = false;
          }
          isSelected[i] = true;
        }
      }

      sum += min;
    }

    return sum;
  }


}
