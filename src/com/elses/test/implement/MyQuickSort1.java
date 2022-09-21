package com.elses.test.implement;

import java.util.Arrays;
//import java.util.Scanner;

public class MyQuickSort1 {
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
		new MyQuickSort1().action((int)(20*Math.random())+1);

//		sc.close();
	}

	void action(int n) {
		System.out.println(n);
		int[] arr = makeRandomArr(n);

		quickSort(arr, 0, n - 1);

		System.out.printf("정렬된 배열 : %s\n", Arrays.toString(arr));
	}

	int[] makeRandomArr(int n) {

		int[] tmp = new int[n];

		for (int i = 0; i < n; i++) {
			tmp[i] = (int) (1000 * Math.random());
		}

		System.out.printf("만들어진 배열 : %s\n", Arrays.toString(tmp));
		return tmp;
	}
	
	void quickSort(int[] arr, int left, int right) {
		if(left >= right)
			return;
		
		int pivotIdx = partition(arr, left, right);
		quickSort(arr, left, pivotIdx -1);
		quickSort(arr, pivotIdx + 1, right);
	}
	
	int partition(int[] arr, int left, int right) {
		int L = left + 1;
		int R = right;
		int pivot = arr[left];
		int tmp;
		
		while(L <= R) {
			while(L <= R && arr[L] <= pivot) L++;
			while(arr[R] > pivot) R--;
			if(L < R) {
				tmp = arr[R];
				arr[R] = arr[L];
				arr[L] = tmp;
			}
		}
		tmp = arr[left];
		arr[left] = arr[R];
		arr[R] = tmp;
		return R;
	}
}





