package com.swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MiddleTree {
	
	static Tree[] trees;
	static StringBuilder result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <= 10; tc++) {
			result = new StringBuilder();
			int n = Integer.parseInt(br.readLine());
			trees = new Tree[n+1];
			for (int i = 1; i <= n; i++) {
				String[] ss = new String[3];
				String[] line = br.readLine().split(" ");
				
				for (int j = 1; j < 4; j++) {
						try {
							ss[j-1] = line[j];
						}catch(ArrayIndexOutOfBoundsException e){
							continue;
						}
				}
				
				trees[i] = new Tree(ss[0],
								ss[1] == null || ss[1].equals("0") ? null : Integer.parseInt(ss[1]), 
								ss[2] == null || ss[2].equals("0") ? null : Integer.parseInt(ss[2])
							);
				
//				System.out.println(trees[i]);
			}
			
			dfs(1);
			
			System.out.printf("#%d %s\n",tc,result);
		}
	}
	
	private static void dfs(Integer now) {
		if(now == null) return;
		
		Tree tmp = trees[now];
		
		dfs(tmp.left);
		dfs(tmp.right);
		result.append(tmp.val).append(" -> ");
		return;
		
	}
}

class Tree{
	String val;
	Integer left;
	Integer right;
	public Tree(String val, Integer left, Integer right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
	
	@Override
	public String toString() {
		return "tree["+val +", "+ left +", "+ right + "]";
	}
}