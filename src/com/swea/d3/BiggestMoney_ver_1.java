package com.swea.d3;

import java.util.Scanner;

public class BiggestMoney_ver_1 {

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int my_number = sc.nextInt();
			String temp = Integer.toString(my_number);

			int chance = sc.nextInt();
			int[] pads = new int[temp.length()];

			int flag = 0;

			for (int i = 0; i < pads.length; i++) {
				pads[i] = Integer.parseInt(temp.substring(i, i + 1));
			}

			while (flag < chance) {

				int max = 0;

				for (int i = flag; i < pads.length; i++) {
					if (pads[i] > max) {
						max = pads[i];
					}
				}

				int loc = -1;
				int temp_num = 0;

				for (int i = flag; i < pads.length; i++) {
					if (pads[i] == max)
						loc = i;
				}

				if (loc != flag) {
					temp_num = pads[flag];
					pads[flag] = pads[loc];
					pads[loc] = temp_num;
				}

				flag++;
			}

			String temp_result = "";

			for (int i = 0; i < pads.length; i++) {
				temp_result += Integer.toString(pads[i]);
			}

			// int result = Integer.parseInt(temp_result);

			System.out.println("#" + test_case + " " + temp_result);
		}
		sc.close();
	}
}
