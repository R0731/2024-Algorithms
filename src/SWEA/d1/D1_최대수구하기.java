package SWEA.d1;

import java.util.Scanner;

public class D1_최대수구하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		int[][] arr = new int[t][10];
		
		for(int i = 0; i < t; i++) {
			for(int j = 0; j < 10; j++) {
			arr[i][j] = sc.nextInt();	
			}
		}
		
		for(int a = 0; a < t; a++) {
		for(int i = 9; i > 0; i--) {
			for(int j = 0; j < i; j++) {
				if(arr[a][j] > arr[a][j+1]) {
					int tmp = arr[a][j+1];
					arr[a][j+1] = arr[a][j];
					arr[a][j] = tmp;
				}
			}
		}
		}
		for(int i = 0; i < t; i++) {
			System.out.println("#" + (i+1) + " " + arr[i][9]);
		}
	}
}
