package d4_1231_중위순회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D4_1231_중위순회 {
    static int N;
    static char[]tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int tc = 1; tc <= 10; tc++){
            N = Integer.parseInt(br.readLine());

            tree = new char[N+1];

            for(int i = 0; i < N; i++){
                StringTokenizer line = new StringTokenizer(br.readLine());
                int n = Integer.parseInt(line.nextToken());
                char c = line.nextToken().charAt(0);
                tree[n] = c;
            }

            System.out.print("#" + tc + " ");
            inorder(1);
            System.out.println();

        }
    }

    static void inorder(int root){
        if(root > N){
            return;
        }
        inorder(root * 2);
        System.out.print(tree[root]);
        inorder(root * 2 +1);
    }
}
