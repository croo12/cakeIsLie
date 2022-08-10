package com.elses.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SomeTest {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int M = Integer.parseInt(bf.readLine());
        String s = bf.readLine();
        int i = 0;
        int cnt =1;
        int cnt2=0;
        while(i<M){
            if(s.startsWith("IO", i)){
                cnt++;
                i++;
            }else if(s.startsWith("I",i)){
                if(cnt-N>0)
                    cnt2+=(cnt-N);
                cnt=1;
            }else{
                if(cnt-N>0)
                    cnt2+=(cnt-N-1);
                cnt=1;
            }
            i++;
//            System.out.println(i+" "+cnt+" "+cnt2);
        }
        if(cnt-N>0&&cnt>2)
            cnt2+=(cnt-N);
        System.out.println(cnt2);

    }
}
