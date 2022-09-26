package com.elses.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()),M = Integer.parseInt(st.nextToken());
        
        char[] last = br.readLine().toCharArray();
        int i;
        for (i = 1; i < N; i++) {
			char[] now = br.readLine().toCharArray();
			boolean flag = false;
			int idx = 1;
			
        	for (int j = 0; j < M && !flag; j++) {
        		if(last[j] == now[M-1]) {
        			while(last[j - idx] == now[M-1 + idx] && j - idx >= 0 && M-1 + idx < M) {
        				idx++;
        			}
        			
        			if(idx > j || idx < 1)
        				flag = true;
        			
        			idx = 1;
        		}
        		
        		if(last[M-1] == now[j]) {
        			while(last[M-1 + idx] == now[j - idx] && j - idx >= 0 && M-1 + idx < M) {
        				idx++;
        			}
        			
        			if(idx > j)
        				flag = true;
        			
        			idx = 1;
        		}
        		
        		if(flag)
        			break;
			}
        	
        	if(!flag)
        		break;
		}
        
        if( i == N) {
        	System.out.println(1);
        }else
        	System.out.println(0);
    }
}
    
//    static int toInt(String s) {
//    	int me =0;
//    	for (int i = 0; i < 4; i++) {
//			me = me * 26 + s.charAt(i);
//		}
//    	return me;
//    }
