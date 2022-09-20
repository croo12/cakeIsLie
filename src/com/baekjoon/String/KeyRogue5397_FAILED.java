package com.baekjoon.String;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class KeyRogue5397_FAILED {
	
	class Keys {
		char data;
		Keys next;
		public Keys(char data) {
			this.data = data;
		}
	}
	
	class LL {
		Keys start;
		int size;
		
		public Keys get(int rear) {
			if(rear >= size || rear < 0) return null;
			Keys now = start;
			for (int i = 0; i < rear; i++) {
				now = now.next;
			}
			return now;
		}
		
		public void remove(int rear) {
			if(rear < 0 || size <= rear) {
//				System.out.println("hoxy  " + size + " : " + rear);
				return;
			}
			if(size==1) {
				start = null;
				size--;
				return;
			}
			Keys prev = get(rear-1);
			Keys now = prev.next;
			if(now == null) {
				prev.next=null;
				size--;
				return;
			}
			prev.next = now.next;
			size--;
		}
		
		public void add(int rear, char data) {
			if(size < rear) {
				return;
			}
			Keys now = new Keys(data);
			if(rear == 0) {
				now.next = start;
				start = now;
				size++;
				return;
			}
			Keys prev = get(rear-1);
			now.next = 
					prev.next;
			prev.next = now;
			size++;
		}
		
		public void clear() {
			start = null;
			size = 0;
		}
		
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		KeyRogue5397_FAILED me = new KeyRogue5397_FAILED();
		LL ans = me.new LL();
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int rear = -1;
			while(true) {
				char now = (char)br.read();
//				System.out.printf("#%d 명령 수행 시작\n",tc);
				
				if (now == '<') {
					if(rear > -1)
						rear--;
				}
				else if (now == '>') {
					if(rear < ans.size - 1)
						rear++;
				}
				else if (now == '-') {
					if(rear != -1) {
						ans.remove(rear);
						rear--;
					}
				}else if(now == '\r'){
					break;
				}else {
					rear++;
					ans.add(rear, now);
				}
			}
			br.readLine();
			for (int i = 0; i < ans.size; i++) {
				sb.append(ans.get(i).data);
			}
			sb.append("\n");
			bw.write(sb.toString());
			sb.setLength(0);
			ans.clear();
		}
		bw.flush();
		bw.close();
	}
}

