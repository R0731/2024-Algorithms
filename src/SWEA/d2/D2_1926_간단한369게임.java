package SWEA.d2;

import java.util.Scanner;

public class D2_1926_간단한369게임 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		String[] str = new String[N];
		
		for(int i = 1; i <= N; i++) {
			str[i-1] = i+"";
		}
		
		
		for(int i = 0; i < str.length; i++) {
			int clap = 0;
			for(int j = 0; j < str[i].length(); j++) {
				if(str[i].charAt(j) == '3' || str[i].charAt(j) == '6' || str[i].charAt(j) == '9') {
					clap++;
				}
			}
			
			if(clap > 0) {	
				String claptext = "";
				while(clap > 0) {
					claptext = claptext + "-";
					clap--;
				}
				str[i] = claptext;
			}
				
			System.out.print(str[i] + " ");
			}
	}
		
}
		