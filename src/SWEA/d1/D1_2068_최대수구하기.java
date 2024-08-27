package SWEA.d1;


import java.util.Scanner;

public class D1_2068_최대수구하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[][] numbers = new int [T][10];
		
		for(int i = 0; i < T; i++) {
			for(int j = 0; j < 10; j++) {
			numbers[i][j] = sc.nextInt();
		}	
		}
		
		int max[] = new int[T];
		
		for(int i = 0; i < T; i++) {
			max[i] = 0;
			for(int j = 0; j < 10; j++) {
				if(max[i] < numbers[i][j]) {
					max[i] = numbers[i][j];
				}
			}
		}
		
		for(int i = 0; i < T; i++) {
		System.out.println("#" + (i+1) + " " + max[i]);
		}
	}
}

