package day0729_Array;

import java.util.Arrays;
import java.util.Scanner;

public class D2_중간평균값구하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		int[][] arr = new int[t][10];
		
		for(int i = 0; i < t; i++) {
			for(int j = 0; j < 10; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		for(int i = 0; i < t; i++) {
			for(int j = arr[i].length-1; j > 0; j--) {
				for(int a = 0; a < j; a++) {
					if(arr[i][a]> arr[i][a+1]) {
						int tmp = arr[i][a+1];
						arr[i][a+1] = arr[i][a];
						arr[i][a] = tmp;  
					}
				}
			}
		}
		
		double []sum = new double[t];
		
		for(int i = 0; i < t; i++) {
			for(int j = 1; j < 9; j++) {
				sum[i] += arr[i][j];
			}
			String s = String.format("%.0f", sum[i]/8);
			System.out.println("#" + (i+1) + " " + s);
		}
		
	}
}
