package SWEA.d1;

import java.util.Scanner;

public class D1_1545_거꾸로출력해보아요 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt() + 1;
		
		for(int i = 0; n > 0; i++) {
			n--;
			System.out.print(n + " ");
		}
	}
}
