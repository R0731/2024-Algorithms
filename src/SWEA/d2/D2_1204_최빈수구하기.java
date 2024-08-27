package SWEA.d2;

import java.util.Scanner;


public class D2_1204_최빈수구하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc = 0; tc < T; tc++) {
			int num = sc.nextInt();
			
			int[] student = new int[1000];
			
			// 학생 점수 담기
			for(int i = 0; i < 1000; i++) {
				student[i] = sc.nextInt();
			}
			
			int[] count = new int[101];
			int j = 0;
			
			for(int i = 0; i < student.length; i++) {
				j = student[i];
				count[j]++;
			}
			
			int max = 0;
			int maxcount = 0;
			
			for(int i = 0; i < count.length; i++) {
				if(count[i] >= max) {
					max = count[i];
					maxcount = i;
				}
			}
			
			System.out.println("#" + num + " " + maxcount);
			
		}
		
	}
}
