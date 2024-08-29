package SWEA.d3_천의자리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class D3_1873_상호의배틀필드 {
    private static int H, W, N;
    private static char[][] nemo;
    private static char[] command;
    private static int direction; //전차가 현재 보는 방향
    private static int R, C; //전차의 현재 위치
    private static final int[] dr = {-1, 1, 0, 0};
    private static final int[] dc = {0, 0, -1, 1};

    static Map<Character, Integer> map = new HashMap<>();
        static{
        map.put('U', 0);
        map.put('D', 1);
        map.put('L', 2);
        map.put('R', 3);
        map.put('S', 4);
        }

    private static final char[] direct = {'^', 'v', '<', '>'};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++){
            StringTokenizer line = new StringTokenizer(br.readLine());

            H = Integer.parseInt(line.nextToken());
            W = Integer.parseInt(line.nextToken());
            nemo = new char[H][W];

            R = 0;
            C = 0;

            boolean findStart = false;

            for(int r = 0; r < H; r++) {
                String line2 = br.readLine();
                nemo[r] = line2.toCharArray();
                int c = 0;
                while (c < W){
                    for(int i = 0; i < 4; i++){
                        if(nemo[r][c] == direct[i]) {
                            direction = i;
                            R = r;
                            C = c;
                            findStart = true;
                            break;
                        }
                    }
                    if(findStart) break;
                    c++;
                }
            }

            N = Integer.parseInt(br.readLine());
            command = new char[N];
            String line3 = br.readLine();
            command = line3.toCharArray();

            for(char com : command){
                setCommand(com);
            }

            StringBuilder sb = new StringBuilder();
            sb.append("#").append(tc).append(" ");
            for(int r = 0; r < H; r++){
                for(int c = 0; c < W; c++){
                    sb.append(nemo[r][c]);
                }
                sb.append("\n");
            }
            System.out.print(sb.toString());
        }
    }

    private static void setCommand(char command){
        int a = map.get(command);

        if(a == 4) {
            shoot();
        }else{
            direction = a;
            move(direction);
        }

        return;
    }

    private static void move(int direction){
        int moveR = R + dr[direction];
        int moveC = C + dc[direction];

        if(moveR >= 0 && moveR < H && moveC >= 0 && moveC < W && nemo[moveR][moveC] == '.'){
            nemo[R][C] = '.';
            R = moveR;
            C = moveC;
        }

        nemo[R][C] = direct[direction];

        return;
    }

    private static void shoot(){
        int moveR = R + dr[direction];
        int moveC = C + dc[direction];

        while(moveR >= 0 && moveR < H && moveC >= 0 && moveC < W) {
            if(nemo[moveR][moveC] == '*'){
                nemo[moveR][moveC] = '.';
                break;
            }else if(nemo[moveR][moveC] == '#'){
                break;
            }
            moveR += dr[direction];
            moveC += dc[direction];
        }
        return;
    }
}