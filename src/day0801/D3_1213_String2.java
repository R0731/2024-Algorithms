package day0801;

import java.util.Scanner;

public class D3_1213_String2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int tc = 1; tc <= 10; tc++) {
			int t = sc.nextInt();
			String str1 = sc.next();
			String str2 = sc.next();
			
//			char[] findVoca = str1.toCharArray();
//			char[] voca = str2.toCharArray();
//			
//			int findNum = 0;
//			int arrNum = 0;
//			
//			while(findNum < findVoca.length && arrNum < voca.length) {
//				for(int i = 0; i < voca.length; i++) {
//					if()
			
			System.out.println("#" + t + " " + bruteForce(str2, str1));
				
				}
				
			}
			
			
			


	
	static int bruteForce(String voca, String findVoca) {
		int V = voca.length();
		int F = findVoca.length();
		int vi = 0;
		int fi = 0;
		int count = 0;
		while(vi <= V - F) {
			fi = 0;
			while(fi < F && voca.charAt(vi + fi) == findVoca.charAt(fi)) {
				fi++;
			}
			if(fi == F) {
				count++;
			}
			vi++;
		}
		
		return count;
	}
	
}
