package com.baekjoon.dataStructure.heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class DoublePriorityQueue {
	public static void main(String[] args) throws IOException {
//		DoublePriorityQueue me = new DoublePriorityQueue();
//		
//		MMQ q = me.new MMQ();
		
		TreeMap<Integer, Integer> q = new TreeMap<>();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int tc = 1; tc <= T; tc++) {
			int m = Integer.parseInt(br.readLine());
			int num = 0;
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				
				if(st.nextToken().equals("I")) {
					num = Integer.parseInt(st.nextToken());
					q.put(num, q.get(num)!= null ? q.get(num)+1 : 1);
					
					for(Entry<Integer, Integer> entry : q.entrySet()) System.out.print(entry+ " -> ");
					System.out.println();
				}else {
					if(!q.isEmpty()) {
						if(st.nextToken().equals("-1")) {
							Entry<Integer,Integer> now = q.firstEntry();
							if(now.getValue() == 1)
								q.remove(now.getKey());
							else
								q.put(now.getKey(), now.getValue()-1);
						}else {
							Entry<Integer,Integer> now = q.lastEntry();
							if(now.getValue() == 1)
								q.remove(now.getKey());
							else
								q.put(now.getKey(), now.getValue()-1);
						}
					}
				}
			}
			
			if(q.isEmpty()) System.out.println("EMPTY");
			else { 
				System.out.println(q.lastKey()+" "+q.firstKey());
				q.clear();
			}
		}
	}
	
//	class MMQ{
//		int size = 0;
////		int level = 0;
//		int newLevel = 1;
//		int[] trees = new int[1000001];
//		
////		int min = Integer.MIN_VALUE;
//		
//		public boolean isEmpty() {
//			return size == 0;
//		}
//		
//		public void insert(int data) {
//			trees[plusSize()] = data;
//			upSort(size);
//			//정렬해줘야함
//		}
//		
//		public void clear() {
//			trees = new int[1000001];
//			size = 0;
//			newLevel = 1;
//		}
//		
//		public int topPoll() {
//			if(size == 0) return 0;
//			int data = trees[1];
//			trees[1] = trees[size];
//			minusSize();
//			
//			downSort(1);
//			//정렬해줘야함
//			return data;
//		}
//		
//		public int bottomPoll() {
//			if(size == 0) return 0;
//			int min = Integer.MAX_VALUE;
//			int idx = 0;
//			for (int i = newLevel/4; i <= size; i++) {
//				if(trees[i] < min) {
//					min = trees[i];
//					idx = i;
//				}
//			}
//			trees[idx] = trees[size];
//			minusSize();
//			
//			upSort(idx);
//			
//			return min;
//		}
//		
//		private void upSort(int idx) {
//			if(trees[idx] > trees[idx/2]) {
//				int tmp = trees[idx];
//				trees[idx] = trees[idx/2];
//				trees[idx/2] = tmp;
//				upSort(idx/2);
//			}
//		}
//		
//		private void downSort(int idx) {
//			
//			int tmp;
//			int leftV = Integer.MIN_VALUE;
//			int rightV = Integer.MIN_VALUE;
//			
//			if(idx*2 < size)
//				leftV = trees[idx*2];
//			if(idx*2 + 1 < size)
//				rightV = trees[idx*2];
//			
//			if(leftV < trees[idx] && rightV < trees[idx])
//				return;
//				
//			if(leftV > rightV) {
//				tmp = trees[idx];
//				trees[idx] = trees[idx*2];
//				trees[idx*2] = tmp;
//				downSort(idx*2);
//			}else {
//				tmp = trees[idx];
//				trees[idx] = trees[idx*2+1];
//				trees[idx*2+1] = tmp;
//				downSort(idx*2+1);
//			}
//		}
//		
//		private int plusSize() {
//			size++;
//			if(size == newLevel) {
////				level++;
//				newLevel *= 2;
//			}
//			return size;
//		}
//		
//		private int minusSize() {
//			size--;
//			if(size == newLevel/2 - 1) {
////				level--;
//				newLevel /= 2;
//			}
//			return size;
//		}
//	}
}
