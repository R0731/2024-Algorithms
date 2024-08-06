package d3;

import java.util.Scanner;

public class D3_Flatten {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 100개의 숫자를 입력받는 배열 만들기
		for(int i = 0; i < 10; i++) {
			int n = sc.nextInt();
			int[] arr = new int[100];
			// 배열 채우기
			for(int j = 0; j < 100; j++) {
				arr[j] = sc.nextInt();
			}
			
			
			//평탄화 작업
			for(int j = 0; j < n; j++) {
				//최댓값 최솟값 구하기
				int maxIndex = 0;
				int minIndex = 0;
				
				for(int a = 1; a < arr.length; a++) {
					if(arr[maxIndex] < arr[a]) {
						maxIndex = a;
					} else if(arr[minIndex] > arr[a]) {
						minIndex = a;
					}
				}
				
				if(arr[maxIndex] - arr[minIndex] <=1) {
					break;
				}
				
				arr[maxIndex]--;
				arr[minIndex]++;
				
			}
			
			int maxIndex = 0;
			int minIndex = 0;
			
			for(int a = 1; a < arr.length; a++) {
				if(arr[maxIndex] < arr[a]) {
					maxIndex = a;
				} else if(arr[minIndex] > arr[a]) {
					minIndex = a;
				}
			}
			
			
			System.out.println("#" + (i+1) + " " + (arr[maxIndex]-arr[minIndex]));
		}
	}
}
