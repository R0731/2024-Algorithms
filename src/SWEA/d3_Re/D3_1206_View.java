package SWEA.d3_Re;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D3_1206_View {
    //좌우로 모두 거리 2 이상의 조망권 확보되는 지역
    static int N; //건물의 개수
    static int[] building; //건물의 높이
    static int ans; //정답
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int tc = 1; tc <= 10; tc++){
            N = Integer.parseInt(br.readLine());
            building = new int[N];
            ans = 0;
            StringTokenizer line = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++){
                int a = Integer.parseInt(line.nextToken());
                building[i] = a;
            }

            for(int i = 2; i < N - 2; i++){
                int max = 0;
                for(int j = 1; j <= 2; j++){
                    int temp = Math.max(building[i + j], building[i - j]);
                    if(temp > max) max = temp;
                }
                if(building[i] - max > 0){
                    ans += building[i] - max;
                }
            }

            System.out.println("#" + tc + " " + ans);
        }
    }
}
