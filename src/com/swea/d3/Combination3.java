package com.swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Combination3 {
    static int mod = 1234567891;
    static int[] nfa;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(bf.readLine());
        for(int t=1;t<=T;t++){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int n = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            nfa= new int[n+1];
            nfa[0]=1;
            for(int i=1; i<=n; i++){
                nfa[i]=nfa[i-1] * i %mod;
            }
            int rnr = (nfa[r] * nfa[n-r])%mod;
            System.out.println(nfa[n] * soSad(rnr,mod-2) % mod);
        }
    }
    static long soSad(long a, long b){
        if(b==1)
            return a;
        long result = soSad(a,b/2);
        if((b%2)==0)
            return result * result%mod;
        else
            return ((result * result%mod)*a)%mod;
    }
}