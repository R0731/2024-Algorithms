package d3_만의자리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D3_10671_신뢰 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++){
            StringTokenizer line = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(line.nextToken());

            String[] robot = new String[N];
            int[] bButton = new int[N];
            int[] oButton = new int[N];

            int oi = 0;
            int bi = 0;

            for(int i = 0; i < N; i++){
                robot[i] = line.nextToken();
                int a = Integer.parseInt(line.nextToken());
                if(robot[i].equals("O")){
                    oButton[oi] = a;
                    oi++;
                }else{
                    bButton[bi] = a;
                    bi++;
                }
            }

            int nowOrange = 1; //오렌지의 현재위치
            int nowBlue = 1; //블루의 현재 위치
            int orangeButton = 0; //오렌지가 눌러야 하는 버튼
            int blueButton = 0; //블루가 눌러야 하는 버튼

            //총 걸리는 시간
            int time = 0;

            //총 반복할 횟수
            for(int i = 0; i < N; i++){
                if(robot[i].equals("O") && orangeButton <= oi){
                    int move = Math.abs(oButton[orangeButton] - nowOrange);
                    time += move + 1;
                    nowOrange = oButton[orangeButton];

                    if(oButton[orangeButton] >= bButton[blueButton]){
                        nowBlue = bButton[blueButton];
                    }else{
                        nowBlue += move + 1;
                        if(nowBlue > bButton[blueButton]){
                            nowBlue = bButton[blueButton];
                        }
                    }

                    orangeButton++;

                }else if(robot[i].equals("B") && blueButton <= bi){
                    int move = Math.abs(bButton[blueButton] - nowBlue);
                    time += move + 1;
                    nowBlue = bButton[blueButton];

                    if(oButton[orangeButton] <= bButton[blueButton]){
                        nowOrange = oButton[orangeButton];
                    }else{
                        nowOrange += move + 1;
                        if(nowOrange > oButton[orangeButton]){
                            nowOrange = oButton[orangeButton];
                        }
                    }

                    blueButton++;
                }

            }

            System.out.println("#" + tc + " " + time);
        }
    }
}
