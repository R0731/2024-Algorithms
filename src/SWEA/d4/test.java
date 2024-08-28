package SWEA.d4;

public class test {
    public static void main(String[] args) {

        recursiveFor(0);
    }

    private static void recursiveFor(int i) {

        System.out.println(i);

        if(i <1000)

            recursiveFor(i+1);

    }

}
