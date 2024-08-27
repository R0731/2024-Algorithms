package SWEA.d2;

import java.util.Arrays;
import java.util.Scanner;

public class D2_1989_초심자의회문검사 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		for(int test = 1; test <= t; test++) {
			String voca = sc.next();
			
			char[] arr1 = voca.toCharArray();
			
			int N = voca.length();
			char[] arr2 = new char[N];
			
			for(int i = 0; i < N; i++) {
				arr2[i] = arr1[i];
			}
			
			for(int i = 0; i < N / 2; i++) {
				char tmp = arr2[i];
				arr2[i] = arr2[N-1-i];
				arr2[N-1-i] = tmp;
				
			}
			
	
			int ans = 0;
			
			if(Arrays.equals(arr1, arr2)) {
				ans = 1;
			}
			
			System.out.println("#" + test + " " + ans);
			
			
		}
		
		
	}
}
