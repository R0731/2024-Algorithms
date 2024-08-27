package SWEA.d1;

import java.util.Scanner;

public class D1_2050_알파벳을숫자로변환하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String example = sc.next();
		
		for(int i = 0; i < example.length(); i++) {
			System.out.print((int)example.charAt(i) - 64 + " ");
		}
	}
}
