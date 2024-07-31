package d2;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class D2_1288_새로운불면증치료법 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		for(int a = 0; a < t; a++) {
			int n = sc.nextInt();
			
			Set<Integer> number = new HashSet<>();
			
			int count = 0;
			int idx = 1;
			while(number.size() < 10) {
				int num = n * idx;
				while (num > 0) {
					number.add(num % 10);
					num /= 10;
				}
				idx++;
				//System.out.println(number);
			}
			
			
			System.out.println("#" + (a+1) + " " + (idx-1)*n);	
		}
		
	}
}