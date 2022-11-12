package com.baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class MusicProgram2623 {
  public static void main(String[] args) {
    try {
      new MusicProgram2623().solution();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private void solution() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int S = Integer.parseInt(st.nextToken());
    int P = Integer.parseInt(st.nextToken());

    int[] singers = new int[S+1];
    Queue<Integer>[] pds = new ArrayDeque[P];

    //내 앞에있는 다른 녀석들을 모두 처리하면 내가 등장할 수 있음
    //나의 언급회수 기록하기 pd가 만든 리스트 순회하기
    //pd의 리스트에서 내가 나오면 나의 차수를 하나 빼고,
    //나의 차수가 0이면 출력

    int now;
    for (int i = 0; i < P; i++) {
      st = new StringTokenizer(br.readLine());
      
      int N = Integer.parseInt(st.nextToken());
      
      pds[i] = new ArrayDeque<>();

      //지금 가리키고 있는 인덱스저장용 0번째 칸
      for (int j = 0; j < N; j++) {
        now =Integer.parseInt(st.nextToken());
        pds[i].offer(now);
        singers[now]++;
      }
    }
    //줄에 못 들어간 가수 수
    int total = S;
    
    StringBuilder sb = new StringBuilder();

    for (int i = 1; i <= S; i++) {
      if(singers[i] == 0){
        sb.append(i).append('\n');
        total--;
      }
    }

    boolean flag;
    Queue<Integer> q;
    int[] check;
    while( total != 0){
      flag = true;
      check = new int[S+1];

      for (int i = 0; i < P; i++) {
        q = pds[i];

        
        while(!q.isEmpty()){
          now = q.peek();
          if(singers[now] == ++check[now]){
            singers[now] = 0;
            sb.append(q.poll()).append('\n');
            total--;
            flag = false;
          }else if(singers[q.peek()] == 0){
            q.poll();
          }else{
            break;
          }
        }
      }

      if(flag)
        break;
    }

    if(total == 0)
      System.out.print(sb);
    else{
      System.out.println(0);
    }
  }
}
