package d3_천의자리;

import java.util.Scanner;

public class D3_1217_거듭제곱 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int tc = 1; tc <= 10; tc++) {
			int T = sc.nextInt();
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			int ans = loopProduct(N, M);
			
			System.out.println("#" + T + " " + ans);
		}
		
	}
	
	
	static int loopProduct(int N, int M) {
		if(M == 0)
			return 1;
		
		return loopProduct(N, M-1) * N;
	}
}
