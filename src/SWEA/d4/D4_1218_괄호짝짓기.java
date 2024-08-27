package SWEA.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D4_1218_괄호짝짓기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc = 1; tc <= 10; tc++) {
			
			int N = Integer.parseInt(br.readLine());
			
			String str = br.readLine();
			
			char[] arr = str.toCharArray();
			
			int ans = 1;
			
			if(arr.length % 2 != 0) {
				ans = 0;
				System.out.println("#" + tc + " " + ans);
				continue;
			}
			
			
			//카운트배열
			int[] count = new int[8];
					
			for(int i = 0; i < arr.length; i++) {
				char c = arr[i];
				switch(c) {
				case '(':
					count[0]++;
					break;
				case ')':
					count[1]++;
					break;
				case '[':
					count[2]++;
					break;
				case ']':
					count[3]++;
					break;
				case '{':
					count[4]++;
					break;
				case '}':
					count[5]++;
					break;
				case '<':
					count[6]++;
					break;
				case '>':
					count[7]++;
					break;
				}
			}
			
			for(int i = 0; i < 8; i = i + 2) {
				if(count[i] != count[i+1]) {
					ans = 0;
					break;
				}
			}
				
			
			System.out.println("#" + tc + " " + ans);
		}
		
	}
}
