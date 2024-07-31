package d1;

import java.util.Scanner;

public class D1_2071_평균값구하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[][] arr = new int[n][10];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < 10; j++) {
			arr[i][j] = sc.nextInt();
		}
		}
		
		double[] sum = new double[n];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < 10; j++) {
					sum[i] += arr[i][j];
			}
			String s = String.format("%.0f", sum[i]/10);
			System.out.println("#" + (i+1) + " " + s);
		}
	}
}
