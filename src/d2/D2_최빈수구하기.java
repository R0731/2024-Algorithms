package d2;

import java.util.Scanner;

public class D2_최빈수구하기 {
	public static void main(String[] args) {
	
		Scanner	sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		for(int i = 0; i < t; i++) {
			int num = sc.nextInt();
			int[] arr = new int[1000];
		
			for(int j = 0; j < 1000; j++) {
				arr[j] = sc.nextInt();
				}
			
			int[] count = new int[101];
			
			for(int j = 0; j < arr.length; j++) {
				count[arr[j]]++;
			}
			
			int max = 0;
			int maxnum = 0;
			for(int j = 0; j < count.length; j++) {
				if(max < count[j]) {
					max = count[j];
					maxnum = j;
				} else if (max == count[j] && maxnum < j) {
					maxnum = j;
				}
			}
			
			System.out.println("#" + (i+1) + " " + maxnum);
	}
}
}
