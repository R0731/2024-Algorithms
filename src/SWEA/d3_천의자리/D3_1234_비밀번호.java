package SWEA.d3_천의자리;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class D3_1234_비밀번호 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for(int tc = 1; tc <= 10; tc++){
            int N = sc.nextInt();

            String nums = sc.next();

            char[] num = nums.toCharArray();

            List<Character> password = new ArrayList<>();

            for(int i = 0; i < N; i++){
                password.add(num[i]);
            }


            for(int i = N-1; i > 0; i--) {
                if(password.get(i) == password.get(i-1)) {
                    password.remove(i);
                    password.remove(i - 1);
                    if (i + 1 == password.size() + 2) {
                        i--;
                    }
                }
            }

            System.out.print("#" + tc + " ");
            while(!password.isEmpty()){
                System.out.print(password.remove(0));
            }
            System.out.println();
        }
    }

}
