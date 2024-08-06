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
			
			double[] score = new double[N];
			
			for(int i = 0; i < N; i++) {
				StringTokenizer line2 = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(line2.nextToken());
				int b = Integer.parseInt(line2.nextToken());
				int c = Integer.parseInt(line2.nextToken());

				score[i] = (a * 0.35) + (b * 0.45) + (c * 0.2);
			}

			//등수 구하기
			int count = -1;

			for(int i = 0; i < N; i++){
				if(score[i] > score[K]){
					count++;
				}
			}

			double grade = Math.ceil(count/10);

			String ans = switch (count) {
                case 1 -> "A+";
                case 2 -> "A0";
                case 3 -> "A-";
                case 4 -> "B+";
                case 5 -> "B0";
                case 6 -> "B-";
                case 7 -> "C+";
                case 8 -> "C0";
                case 9 -> "C-";
                default -> "D0";
            };


            System.out.println("#" + tc + " " + ans);
		}
		
	}
}
