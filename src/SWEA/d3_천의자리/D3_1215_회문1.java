package SWEA.d3_천의자리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D3_1215_회문1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));

        for(int tc = 1; tc <= 10; tc++){
            int N = Integer.parseInt(br.readLine());

            Character[][] nemo = new Character[8][8];

            for(int r = 0; r < 8; r++){
                String line2 = br.readLine();
                char[] temp = line2.toCharArray();
                for(int c = 0; c < 8; c++) {
                    nemo[r][c] = temp[c];
                }
            }

//            System.out.println(Arrays.deepToString(nemo));

            int count = 0; //회문갯수를 세기 위한 변수

            //가로 회문 찾기
            for(int r = 0; r < 8; r++){
                for(int c = 0; c <= 8 - N; c++) {
                    boolean pel = true;
                    for(int a = 0; a < N / 2; a++){
                        if(nemo[r][c + a] != nemo[r][c + (N - 1 - a)]){
                            pel = false;
                            break;
                        }
                    }
                    if(pel)
                        count++;
                }
            }

            //세로 회문 찾기
            for(int c = 0; c < 8; c++){
                for(int r = 0; r <= 8 - N; r++) {
                    boolean pel = true;
                    for(int a = 0; a < N / 2; a++){
                        if(nemo[r + a][c] != nemo[r + (N - 1 - a)][c]){
                            pel = false;
                            break;
                        }
                    }
                    if(pel)
                        count++;
                }
            }

            System.out.println("#" + tc + " " + count);
        }
    }
}
