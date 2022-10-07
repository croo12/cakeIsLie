package com.baekjoon.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class YellMid1655_Fail {
	//틀린이유
	//1 : 느리네 이거
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		Node mid = new Node(Integer.parseInt(br.readLine()));
		sb.append(mid.val).append('\n');
		int idx = 1;
		
		//1착 : 
		//100,000 의 호출
		//어차피 계속 정렬하면서 가운데 값을 불러야한다면 가운데 기준으로 양옆으로 붙이면서
		//링크드리스트로 삽입정렬하면 좀 빠를지도?
		//그냥 n^2/4 인가? 잘 모르겠다.
		
		//2착 :
		//중간 힙을... 만들 수 있을까?
		
		int now;
		for (int i = 1; i < N; i++) {
			now = Integer.parseInt(br.readLine());
			Node tmp = new Node(now);
			
			if(now < mid.val) {
				idx++;
				Node before = mid;
				while(before.before != null && before.before.val > now) {
					before = before.before;
				}
				
				tmp.next = before;
				tmp.before = before.before;
				before.before = tmp;
				if(tmp.before != null) {
					tmp.before.next = tmp;
				}
				
			}else {
				Node next = mid;
				while(next.next != null && next.next.val < now) {
					next = next.next;
				}
				
				tmp.before = next;
				tmp.next = next.next;
				next.next = tmp;
				if(tmp.next != null) {
					tmp.next.before = tmp;
				}
			}
			
			int size = Node.size;
			if(size%2 == 0) {
				if(idx < size/2) {
					idx++;
					mid = mid.next;
				}else if(idx > size/2) {
					idx--;
					mid = mid.before;
				}
			}else {
				if(idx < size/2 + 1) {
					idx++;
					mid = mid.next;
				}else if(idx > size/2 + 1) {
					idx--;
					mid = mid.before;
				}
			}
			
			sb.append(mid.val).append('\n');
		}
		System.out.print(sb);
	}
	
	static class Node{
		static int size;
		int val;
		Node next;
		Node before;
		Node(int val){
			this.val = val;
			size++;
		}
	}
}
