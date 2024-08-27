package SWEA.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class D2_1974_스도쿠검증_Re {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {

            int[][] nemo = new int[9][9];

            for(int r = 0; r < 9; r++){
                StringTokenizer line = new StringTokenizer(br.readLine());
                for(int c = 0; c < 9; c++){
                    nemo[r][c] = Integer.parseInt(line.nextToken());
                }
            }

            boolean ans = true;

            //가로줄 검사
            for(int r = 0; r < 9; r++) {
                Set<Integer> nums = new HashSet<>();
                for (int c = 0; c < 9; c++) {
                    nums.add(nemo[r][c]);
                }
                if(!(nums.size() == 9)){
                    ans = false;
                    break;
                }
            }

            //세로줄 검사
            for(int c = 0; c < 9; c++) {
                Set<Integer> nums = new HashSet<>();
                for (int r = 0; r < 9; r++) {
                    nums.add(nemo[r][c]);
                }
                if(!(nums.size() == 9)){
                    ans = false;
                    break;
                }
            }

            //사각형 검사
            for(int r = 0; r < 9; r+=3) {
                for (int c = 0; c < 9; c+=3) {
                    Set<Integer> nums = new HashSet<>();
                    for(int a = 0; a < 3; a++){
                        for(int b = 0; b < 3; b++){
                            nums.add(nemo[r+a][c+b]);
                        }
                    }
                    if(!(nums.size() == 9)){
                        ans = false;
                        break;
                    }
                }
            }



            System.out.println("#" + tc + " " + (ans ? 1 : 0));
        }
    }
}

