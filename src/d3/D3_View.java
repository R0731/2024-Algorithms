package d3;

import java.util.Arrays;
import java.util.Scanner;

public class D3_View {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int t = 1; t <=10; t++) {
			int N = sc.nextInt();
			
			int[] arr = new int[N];
			
			for(int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}
			
			int answer = 0;
			
			for(int i = 2; i < N-2; i++) {
				int leftsecond = arr[i-2];
				int leftfirst = arr[i-1];
				int center = arr[i];
				int rightfirst = arr[i+1];
				int rightsecond = arr[i+2];
				
				int leftmax = leftsecond;
				int rightmax = rightsecond;
				if(leftsecond < leftfirst) {
					leftmax = leftfirst; 
				}
				if(rightsecond < rightfirst) {
					rightmax = rightfirst;
				}
				
				int max = leftmax;
				if(leftmax < rightmax) {
					max = rightmax;
				}
				if(center > max) {
					answer += center - max;
				}
			}
			System.out.println("#" +  t + " " + answer);
		}
//		for(int i = 2; i < N-2; i++) {
//			int first = 0;
//			int second = 0;
//			for(int j = i-2; j < i+3; j++)
//				if(arr[j] > first) {
//				second = first;
//				first = arr[j];
//			} else if(arr[j] > second) {
//				second = arr[j];
//			}
//			answer[i] = first - second;
//		}
//		
//		System.out.println(Arrays.toString(answer));
//		
////		for(int i = answer.length-1; i > 0; i--) {
////			for(int j = 0; j < i; j++) {
////				if(answer[j] > answer[j+1]) {
////					int tmp = answer[j+1];
////					answer[j+1] = answer[j];
////					answer[j] = tmp;	
//					}
//				}
//			}
//		System.out.println(answer[N-5]);
		}		
	}

