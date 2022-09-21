package com.elses.test;

import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        
        System.out.println((int)Math.ceil( Math.log(n+1) / Math.log(2) ));
    }

}