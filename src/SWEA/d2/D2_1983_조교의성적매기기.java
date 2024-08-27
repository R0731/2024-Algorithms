package SWEA.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class D2_1983_조교의성적매기기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= t; tc++) {
			StringTokenizer line = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(line.nextToken());
			int K = Integer.parseInt(line.nextToken())-1;
			
			int[] score = new int[N];
			
			for(int i = 0; i < N; i++) {
				StringTokenizer line2 = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(line2.nextToken());
				int b = Integer.parseInt(line2.nextToken());
				int c = Integer.parseInt(line2.nextToken());

				score[i] = (a * 35) + (b * 45) + (c * 20); //계산하기 편하게 100곱해주기
			}

			//등수 구하기
			Integer[] count = new Integer[N];

			//배열복사
			for(int i = 0; i < N; i++){
				count[i] = score[i];
			}

			//내림차순 정렬
			Arrays.sort(count, Collections.reverseOrder());

			int num = 0;

			for(int i = 0; i < N; i++){
				if(count[i] == score[K]){
					num = i;
					break;
				}
			}

			int ans = num / (N / 10);

			String[] grades = {"A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0"};



            System.out.println("#" + tc + " " + grades[ans]);
		}
		
	}
}
