package d1;

import java.util.Scanner;

public class D1_1936_1대1가위바위보 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		if(b == 3 && a == 1) {
			System.out.println("A");			
		} else if (a == 3 && b == 1) {
			System.out.println("B");
		} else if (a < b) {
			System.out.println("B");
		} else {
			System.out.println("A");
		}
	}
}
