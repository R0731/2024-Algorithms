package d1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class D1_1933_간단한N의약수 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		List<Integer> numbers = new ArrayList<>();
		
		for(int i = 1; i <= N; i++) {
			if(N % i == 0) {	
			numbers.add(i);
			}
		}
		
		for(int n : numbers) {
			System.out.print(n + " ");
		}
	}

}
