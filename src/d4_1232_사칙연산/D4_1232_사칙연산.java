package d4_1232_사칙연산;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class D4_1232_사칙연산 {
    static int N;
    static String[] tree;
    static Stack<String> stack = new Stack<>();
    static Stack<Double> number = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int tc = 1; tc <= 10; tc++) {
            N = Integer.parseInt(br.readLine());

            tree = new String[N + 1];

            for (int i = 1; i <= N; i++) {
                StringTokenizer line = new StringTokenizer(br.readLine());
                int index = Integer.parseInt(line.nextToken());
                String str = line.nextToken();
                tree[index] = str;
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
            postorder(root * 2);
            postorder(root * 2 + 1);
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
