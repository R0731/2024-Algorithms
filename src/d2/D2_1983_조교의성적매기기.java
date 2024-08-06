package d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D2_1983_조교의성적매기기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= t; tc++) {
			StringTokenizer line = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(line.nextToken());
			int K = Integer.parseInt(line.nextToken());
			
			int[] score = new int[N];
			
			for(int i = 0; i < N; i++) {
				StringTokenizer line2 = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(line2.nextToken());
				int b = Integer.parseInt(line2.nextToken());
				int c = Integer.parseInt(line2.nextToken());
				
//				socre[i] = a*3.5 + b + c;
			}
			
			
			
			System.out.println("#" + tc + " ");
		}
		
	}
}
