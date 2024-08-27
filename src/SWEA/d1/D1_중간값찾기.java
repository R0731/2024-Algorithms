package SWEA.d1;

import java.util.Scanner;

public class D1_중간값찾기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] nums = new int[N];
		
		for(int i = 0; i < N; i++) {
		nums[i] = sc.nextInt();
		}
		
		for(int i = nums.length-1; i > 0; i--) {
			for(int j = 0; j < i; j++) {
			if(nums[j] > nums[j+1]){
				int tmp = nums[j+1];
				nums[j+1] = nums[j];
				nums[j] = tmp;
			}
		}
		}
		
		int answer = nums.length / 2;
		
		System.out.println(nums[answer]);
		
		}
	}
