package com.elses.test;

import java.io.*;
import java.util.*;

public class Test {

    static int n;
    static Stack<Integer> stack;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        stack = new Stack<>();

        if (n != 1 && n % 2 != 0) {
            bw.write(-1 + "\n");
        } else {
            stack.push(n);
            int tmp = n - 1;
            int op = -1;
            for (int i = 0; i < n - 1; i++) {
                stack.push(stack.peek() + tmp * op);
                tmp -= 2;
                op *= -1;
            }
            sb.append(' ');
            while (!stack.isEmpty()) {
                sb.append(stack.pop()).append(' ');
            }
            sb.setLength(sb.length() - 1);
            bw.write(sb.reverse().toString());
        }

        bw.flush();
        bw.close();
        br.close();
    }
}