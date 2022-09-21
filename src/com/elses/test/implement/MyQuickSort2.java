package com.elses.test.implement;

import java.util.Arrays;
//import java.util.Scanner;

public class MyQuickSort2 {
	public static void main(String[] args) {
		new MyQuickSort2().action((int)(20*Math.random())+1);
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
		int pivot = arr[right];
		int idx = left-1;
		int tmp;
		
		for (int i = left; i < right; i++) {
			if(arr[i] <= pivot) {
				idx++;
				tmp = arr[idx];
				arr[idx] = arr[i];
				arr[i] = tmp;
			}
		}
		
		tmp = arr[right];
		arr[right] = arr[idx+1];
		arr[idx+1] = tmp;
		return idx+1;
	}
}





