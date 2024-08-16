package d4_1232_사칙연산;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class D4_1232_사칙연산 {
    static int N;
    static String[] tree;
    static int[][] treeroot;
    static Stack<String> stack = new Stack<>();
    static Stack<Double> number = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int tc = 1; tc <= 10; tc++) {
            N = Integer.parseInt(br.readLine());

            tree = new String[N + 1];
            treeroot = new int[N+1][2];
            for (int i = 1; i <= N; i++) {
                StringTokenizer line = new StringTokenizer(br.readLine());
                int index = Integer.parseInt(line.nextToken());
                String str = line.nextToken();
                tree[index] = str;
                if(line.hasMoreTokens())
                    treeroot[i][0] = Integer.parseInt(line.nextToken());
                if(line.hasMoreTokens())
                    treeroot[i][1] = Integer.parseInt(line.nextToken());
            }

            postorder(1);

            double ans = number.pop();
            int answer = (int)ans;

            System.out.println("#" + tc + " " + answer);


        }



    }

        static void postorder ( int root){
            if (root >= N + 1 || (tree[root] == null)) {
                return;
            }
            postorder(treeroot[root][0]);
            postorder(treeroot[root][1]);
            if (tree[root] != null) {
                if(tree[root].equals("+")){
                    number.push(number.pop() + number.pop());
                } else if(tree[root].equals("-")) {
                    number.push(- number.pop() + number.pop());
                } else if(tree[root].equals("*")){
                    number.push(number.pop() * number.pop());
                } else if(tree[root].equals("/")){
                    double n1 = number.pop();
                    double n2 = number.pop();
                    number.push(n2 / n1);
                }else{
                    number.push((double) Integer.parseInt(tree[root]));
                }
            }
        }
}
