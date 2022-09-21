package com.elses.test.implement;

import java.util.Arrays;
//import java.util.Scanner;

public class MyMergeSort {
	static int[] sorted;
	
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
		new MyMergeSort().action((int)(20*Math.random())+1);
		
//		sc.close();
	}
	
	void action(int n) {
		int[] arr = makeRandomArr(n);
		sorted = new int[n];
		
		mergeSort(arr, 0, n-1);
		
		System.out.printf("정렬된 배열 : %s\n", Arrays.toString(arr));
	}
	
	void mergeSort(int[] arr, int left, int right) {
		if(left >= right) return;
		
		int mid = (left + right)/2;
		
		mergeSort(arr, left, mid);
		mergeSort(arr, mid + 1, right);
		merge(arr, left, mid, right);
		
		System.out.printf("배열의 현재 상태 : %s\n", Arrays.toString(arr));
	}
	
	void merge(int[] arr,int left, int mid, int right) {
		int L = left;
		int R = mid+1;
		int idx = left;
		
		while(L <= mid && R <= right) {
			if(arr[L] < arr[R]) {
				sorted[idx] = arr[L];
				idx++;
				L++;
			}else {
				sorted[idx] = arr[R];
				idx++;
				R++;
			}
		}
		
		if(L <= mid) {
			while(L <= mid) {
				sorted[idx] = arr[L];
				idx++;
				L++;
			}
		}else {
			while(R <= right) {
				sorted[idx] = arr[R];
				idx++;
				R++;
			}
		}
		
		for (int i = left; i <= right; i++) {
			arr[i] = sorted[i];
		}
	}
	
	int[] makeRandomArr(int n) {
		
		int[] tmp = new int[n];
		
		for (int i = 0; i < n; i++) {
			tmp[i] = (int) (1000*Math.random());
		}
		
		System.out.printf("만들어진 배열 : %s\n", Arrays.toString(tmp));
		return tmp;
	}
}
