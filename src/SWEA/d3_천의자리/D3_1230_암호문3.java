package SWEA.d3_천의자리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class D3_1230_암호문3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int tc = 1; tc <= 10; tc++){
            int N = Integer.parseInt(br.readLine()); //원본 중 암호문 개수

            StringTokenizer original = new StringTokenizer(br.readLine()); //원본 암호문

            List<String> ans = new ArrayList<>();

            while(original.hasMoreTokens()){
                ans.add(original.nextToken());
            }

            int M = Integer.parseInt(br.readLine());

            StringTokenizer newpassword = new StringTokenizer(br.readLine());

            while(newpassword.hasMoreTokens()){
                String command = newpassword.nextToken();
                if(command.equals("I")){
                    int x = Integer.parseInt(newpassword.nextToken());
                    int y = Integer.parseInt(newpassword.nextToken());

                    for(int i = 0; i < y; i++){
                        ans.add((x + i), newpassword.nextToken());
                    }

                }else if(command.equals("D")){
                    int x = Integer.parseInt(newpassword.nextToken());
                    int y = Integer.parseInt(newpassword.nextToken());

                    for(int i = y; i > 0; i--){
                        ans.remove((x+y));
                    }

                }else if(command.equals("A")){
                    int y = Integer.parseInt(newpassword.nextToken());

                    for(int i = 0; i < y; i++) {
                        ans.add(newpassword.nextToken());
                    }
                }
            }


            System.out.print("#" + tc + " ");
            for(int i = 0; i < 10; i++){
                System.out.print(ans.get(i) + " ");
            }
        }
    }
}
