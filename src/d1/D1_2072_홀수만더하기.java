package d1;

import java.util.Arrays;
import java.util.Scanner;

public class D1_2072_홀수만더하기 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[][] arr = new int[n][10];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < 10; j++) {
			arr[i][j] = sc.nextInt();
		}
	}
		
		int[] sum = new int[n];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < 10; j++) {
				if(arr[i][j] % 2 == 1) {
					sum[i] += arr[i][j];
				}
			}
			System.out.println("#" + (i+1) + " " + sum[i]);
		}
}
}
