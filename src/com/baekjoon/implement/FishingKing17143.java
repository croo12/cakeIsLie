package com.baekjoon.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class FishingKing17143 {
  public static void main(String[] args) {
    try {
      new FishingKing17143().solution();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private void solution() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    int R = Integer.parseInt(st.nextToken());
    int C = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    
    Shark[] sharks = new Shark[M];

    int sum = 0;

    //죽일 상어 찾기용
    int num = -1;
    int min = R + 1;
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      sharks[i] = new Shark(Integer.parseInt(st.nextToken()), 
                            Integer.parseInt(st.nextToken()), 
                            Integer.parseInt(st.nextToken()), 
                            Integer.parseInt(st.nextToken()), 
                            Integer.parseInt(st.nextToken()));

      if(sharks[i].c == 1 && sharks[i].r < min){
        min = sharks[i].r;
        num = i;
      }
    }

    if(num != -1){
      sum += sharks[num].z;
      sharks[num] = null;
    }

    //int[0] => 상어의 번호
    //int[1] => 상어의 크기
    HashMap<Integer, int[]> map = new HashMap<>();

    //낚시꾼은 C번 낚시한다
    Shark shark;
    for (int i = 1; i < C; i++) {

      //젤 위에 있는 상어번호
      int topIdx = -1; 
      //젤 위에 있는 상어의 깊이
      int minDepth = R + 1;

      //상어가 이동한다.
      for (int j = 0; j < M; j++) {
        shark = sharks[j];

        if(shark == null)
          continue;

        int s = shark.s;
        
        //상어는 s칸 이동한다
        //처음에는 dir 방향으로 이동한다
        //그 다음에는 왔다리갔다리함
        
        if(shark.d == 1 || shark.d == 2){
          int r = shark.r;

          while( s != 0 ){

            if( shark.d == 1){
              int move = Math.min(s, r - 1);
              s -= move;
              r = r - move;
              
              if(r == 1){
                shark.d = dirChange[shark.d];
              }
            }else{
              int move = Math.min(s, R - r);
              s -= move;
              r = r + move;
              
              if(r == R){
                shark.d = dirChange[shark.d];
              }
            }
          }

          shark.r = r;
        }

        else if(shark.d == 3 || shark.d == 4){
          int c = shark.c;
        
          while( s != 0 ){

            if( shark.d == 3){
              int move = Math.min(s, C - c);
              s -= move;
              c = c + move;
              
              if(c == C){
                shark.d = dirChange[shark.d];
              }
            }else{
              int move = Math.min(s, c - 1);
              s -= move;
              c = c - move;
              
              if(c == 1){
                shark.d = dirChange[shark.d];
              }
            }
          }

          shark.c = c;
        }

        //이동이 끝나면 상어의 위치를 맵에 넣기
        int key = shark.r * 1000 + shark.c;
        if(!map.containsKey(key)){
          map.put(key, new int[]{j, shark.z});
          if(shark.c == i + 1 && shark.r <= minDepth){
            minDepth = shark.r;
            topIdx = j;
          }

        }else{
          int[] before = map.get(key);

          if(before[1] > shark.z){
            sharks[j] = null;
          }else{
            sharks[before[0]] = null;
            map.put(key, new int[]{j, shark.z});
            if(shark.c == i + 1 && shark.r <= minDepth){
              minDepth = shark.r;
              topIdx = j;
            }
          }
        }
      }//상어 이동끝

      // System.out.println(i + " no. result : " + sum);
      // for (Shark print : sharks) {
      //   if(print == null)
      //     System.out.printf("[ null ] , ");
      //   else{
      //     System.out.printf("[ %d , %d, direction : %d ] , ", print.r, print.c, print.d);
      //   }
      // }
      // System.out.println();

      map.clear();
      
      //i+1번 col 에서 젤 위에 있는 상어를 낚기
      if(topIdx != -1){
        sum += sharks[topIdx].z;
        sharks[topIdx] = null;
      }

    }//낚시꾼 이동 끝

    System.out.println(sum);
  }

  int[] dirChange = {0, 2, 1, 4, 3};

  class Shark {
    //d : 상하우좌
    int r,c,s,d,z;
    public Shark(int r, int c, int s, int d,int z){
      this.r = r;
      this.c = c;
      this.s = s;
      this.d = d;
      this.z = z;
    }
  }
}
