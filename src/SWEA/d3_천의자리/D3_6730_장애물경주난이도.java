package SWEA.d3_천의자리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class D3_6730_장애물경주난이도 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++){

            int N = Integer.parseInt(br.readLine());

            int[] nemo = new int[N];

            StringTokenizer line = new StringTokenizer(br.readLine());

            for(int i = 0; i < N; i++){
                nemo[i] = Integer.parseInt(line.nextToken());
            }

            List<Integer> up = new ArrayList<>();
            List<Integer> down = new ArrayList<>();

            for(int i = 1; i < N; i++){
                if(nemo[i] > nemo[i - 1]){
                    up.add(nemo[i] - nemo[i -1]);
                }else if(nemo[i] < nemo[i - 1]){
                    down.add(nemo[i - 1] - nemo[i]);
                }
            }

            int ans1 = 0;

            if(up.isEmpty()){
                ans1 = 0;
            }else {
                for (int i = 0; i < up.size(); i++) {
                    if (up.get(i) > ans1)
                        ans1 = up.get(i);
                }
            }

            int ans2 = 0;

            if(down.isEmpty()){
                ans2 = 0;
            }else {
                for (int i = 0; i < down.size(); i++) {
                    if (down.get(i) > ans2)
                        ans2 = down.get(i);
                }
            }

            System.out.println("#" + tc + " " + ans1 + " " + ans2);
        }
    }
}
