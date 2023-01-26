package com.SMTC;

import java.util.Scanner;
import java.util.stream.Stream;

public class A {
    public static void main(String[] args) {
        new A().solution();
    }

    public void solution(){
        var sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[] arr = Stream.of(sc.nextLine().split(" "))
                .mapToInt(str -> Integer.parseInt(str)).toArray();

        int sum1 = 0;
        int sum2 = 0;

        int max = 0;
        int min1 = 0;
        int min2 = 0;

        int now;
        for (int i=0; i < n; i++){
            now = arr[i];

            if(now == 1){
                sum1++;
                sum2--;
            }else{
                sum1--;
                sum2++;
            }

            min1 = Math.min(min1, sum1);
            min2 = Math.min(min2, sum2);

            max = Math.max( Math.max(sum1 - min1, sum2 - min2), max );
        }

        System.out.println(max);
    };
}
