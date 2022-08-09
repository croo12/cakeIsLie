package com.swea.d2;

import java.util.Scanner;
import java.io.FileInputStream;
 
public class SearchMostPopularNum
{
    public static void main(String args[]) throws Exception{
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
 
        for(int test_case = 1; test_case <= T; test_case++)
        {
            int test_number = sc.nextInt();
            int max_score = 100;
            int[] score_arr = new int[max_score+1];
             
            for(int i=0; i<1000; i++){
                int score = sc.nextInt();
                score_arr[score] = score_arr[score] + 1;
            }
             
            int most = 0;
            int most_score = 0;
             
            for(int i=0; i<score_arr.length; i++){
                if(score_arr[i] >= most){
                    most = score_arr[i];
                }
            }
             
            for(int i=0; i<score_arr.length; i++){
                if(score_arr[i] == most){
                    most_score = i;
                }
            }
             
            System.out.println("#"+test_number+" "+most_score);
        }
    }
}
