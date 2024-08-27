package SWEA.d2;

import java.util.Scanner;

public class D2_1859_백만장자프로젝트 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println(Long.MAX_VALUE);
		
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			int number = sc.nextInt();
			
			// 왜 long을 써야하지... int는 21억까지 되는데 결과값을 어떻게 예상하는 거지
			long[] money = new long[number];
			
			for(int i = 0; i < money.length; i++) {
				money[i] = sc.nextInt();
			}
			
			long maxPrice = 0; 
			long earnMoney = 0;
			
			 for (int i = number - 1; i >= 0; i--) {
	                if (money[i] > maxPrice) {
	                    maxPrice = money[i];
	                } else {
	                    earnMoney += maxPrice - money[i];
	                }
	          }
			
			System.out.println("#" + tc + " " + earnMoney);
			

		}
		
	}
}
