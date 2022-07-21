package com.swea.ssafy;

import java.util.Scanner;

class AverageMiddle{
	public static void main(String args[]) throws Exception{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++){
            System.out.print("#"+test_case+" ");
            int[] arr = new int[10];
            int max = 0;
            int min = 10001;
            int sum = 0;
            for(int i=0; i < 10; i++){
            	arr[i] = sc.nextInt();
                sum += arr[i];
                if(arr[i] > max)
                    max = arr[i];
                else if(arr[i] < min){
                	min = arr[i];
                }
            }
            double result = (sum - max - min)/8.0;
            
            System.out.println(Math.round(result));
		}
		sc.close();
	}
}