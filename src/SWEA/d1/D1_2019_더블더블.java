package SWEA.d1;

import java.util.Scanner;

public class D1_2019_더블더블 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int a = 1;
		for(int i = 0; i < n; i++) {
			if(i == 0) {
				System.out.print(a + " ");
			}
		a = a * 2;	
		System.out.print(a + " ");		
		}
		}
	}
