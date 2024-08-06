package d3_천의자리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D3_8931_제로 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		
		for(int x = 1; x <= TC; x++) {
			int K = Integer.parseInt(br.readLine());
			
			int[] arr = new int[K];
			
			for(int i = 0; i < K; i++) {
				arr[i] = Integer.parseInt(br.readLine());
			}
			
			for(int i = 1; i < K; i++) {
				int j = i-1;
				if(arr[i] == 0) {
					boolean minus = true;
					while(minus == true) {
						if(arr[j] == 0) {
							j--;
						} else {
							arr[j] = 0;
							minus = false;
						}
					}
				}
			}
			
			int sum = 0;
			
			for(int i = 0; i < K; i++) {
				sum += arr[i];
			}
			
			System.out.println("#" + x + " " + sum);
		}
		
	}
}
