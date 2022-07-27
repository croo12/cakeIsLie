package com.elses.test;

import java.util.*;

public class Test0728 {
	
	public static void main(String[] args) {
		Test0728 sol = new Test0728();
		int[] n = sol.solution();
		for(int i : n) System.out.println(i);
	}
	
    public int[] solution() {
    	int[] progresses = new int[] {90,90,90,80};
    	int[] speeds = new int[] {1,1,1,1};
    	
        Stack<Integer>stack = new Stack<>();
        ArrayList<Integer>list = new ArrayList<>();

        for(int i= speeds.length-1; i>=0;i--){
            if((100-progresses[i])%speeds[i]==0)
                stack.push((100-progresses[i])/speeds[i]);
            else
                stack.push((100-progresses[i])/speeds[i]+1);
        } //남은 일수를 스택에 넣는다
        
        while(!stack.isEmpty()){
            int cnt=1;
            int a = stack.pop();
            
            while(!stack.isEmpty() && a>=stack.peek()){ //최상위 a보다 더 일찍 끝나는 뒤에 붙어있는 친구들
                
                stack.pop();
                cnt++;
            }

            list.add(cnt);
        }
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++)
            answer[i]=list.get(i);
        return answer;
    }
}
