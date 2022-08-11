package com.beakjoon.ssafy;

import java.util.Arrays;
import java.util.Scanner;

public class Triangle90Check {
	public static void main(String[] args){
	    Scanner sc = new Scanner(System.in);
//	    boolean flag = true;
	    while(true){
	        int[] arr = new int[3];
	        arr[0] = sc.nextInt();
	        arr[1] = sc.nextInt();
	        arr[2] = sc.nextInt();
	            
	        if(arr[0] == 0 && arr[1] == 0 && arr[2] == 0){
	            break;
	        }
	            
	        Arrays.sort(arr);
	        int x = arr[0] * arr[0];
	        int y = arr[1] * arr[1];
	        int z = arr[2] * arr[2];
	            
	        if(x + y == z){
	            System.out.println("right");
	        }else{
	            System.out.println("wrong");
	        }
	    }
	    sc.close();
	}
}
