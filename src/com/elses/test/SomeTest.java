package com.elses.test;

import java.io.IOException;
import java.util.Scanner;
 
 
public class SomeTest
{
 
public static void main(String args[]) throws NumberFormatException, IOException 
{
 
    Scanner sc = new Scanner(System.in);
 
    int T=10;
    for(int test_case = 1; test_case <= T; test_case++)
    {   
        int t=sc.nextInt();
        int [] arr=new int[8];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=sc.nextInt();
        }
         
        boolean t2=true;
         
 
        while (t2) {
            int j=1;
            for (int k = 0; k < 5; k++) {
                int tmp=0;
                arr[0]-=j;
                tmp=arr[0];
                for (int i = 0; i < 7; i++) {
                    arr[i]=arr[i+1];
                }
                arr[7]=tmp;
                j++;
                if (arr[7]<=0) {
                    arr[7]=0;
                    t2=false;
                    break;
                }
            }
 
        }
         
        System.out.print("#"+t+" ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }
    	sc.close();
    }
 
}