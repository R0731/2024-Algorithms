package SWEA.d1;

import java.util.Scanner;

public class D1_2070_큰놈작은놈같은놈 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[][] numbers = new int[T][2];
		
		for(int i = 0; i < T; i++) {
			for(int j = 0; j < 2; j++) {
				numbers[i][j] = sc.nextInt();
				}
			}
		
		for(int i = 0; i < T; i++) {
			if(numbers[i][0] < numbers[i][1]) {
				System.out.println("#" + (i+1) + " <");
			}else if(numbers[i][0] > numbers[i][1]) {
				System.out.println("#" + (i+1) + " >");
			}else {
				System.out.println("#" + (i+1) + " =");
			}
		}
		}
	}

