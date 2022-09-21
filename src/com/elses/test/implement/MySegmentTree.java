package com.elses.test.implement;

import java.util.Arrays;

public class MySegmentTree {
	public static void main(String[] args) {
		new MySegmentTree().action((int) (20 * Math.random()) + 1);
	}

	void action(int n) {
		int[] arr = makeRandomArr(n);

		SegmentTree st = new SegmentTree(n);
		st.init(arr, 1, 0, n-1);
		
		System.out.printf("정렬된 트리 : \n%s\n", st.toString());
		
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += arr[i];
		}
		
		System.out.printf("진짜 합은 몇일까용 : %d",sum);
	}

	int[] makeRandomArr(int n) {

		int[] tmp = new int[n];

		for (int i = 0; i < n; i++) {
			tmp[i] = (int) (1000 * Math.random());
		}

		System.out.printf("만들어진 배열 : %s\n", Arrays.toString(tmp));
		return tmp;
	}

	static class SegmentTree { // 합을 저장하는 세그먼트 트리
		int[] tree;
		int top;
		int size;
		
		SegmentTree(int n) {
			top = (int) Math.ceil(Math.log(n + 1) / Math.log(2));
			size = (int) Math.pow(2, top+1);
			tree = new int[size];
		}

		int init(int[] arr, int node, int left, int right) {
			if (left == right) {
				return tree[node] = arr[left];
			} else {
				int mid = (left + right) / 2;
				return tree[node] = init(arr, node * 2, left, mid) + init(arr, node * 2 + 1, mid + 1, right);
			}
		}

		@Override
		public String toString() {
			System.out.println(top);
			System.out.println(size);
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i <= top+1; i++) {
				for (int j = (int)Math.pow(2, i); j < size && j < (int)Math.pow(2, i+1); j++) {
					sb.append(tree[j] == 0 ? "null" : tree[j]).append(' ');
				}
				sb.append('\n');
			}
			return sb.toString();
		}
	}
}
