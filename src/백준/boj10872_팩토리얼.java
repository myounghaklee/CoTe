package 백준;

import java.util.Scanner;

public class boj10872_팩토리얼 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int ans = factorial(N);
        System.out.println(ans);
    }

    private static int factorial(int n) {
        if(n == 0 ){
            return 1;
        }
        return n*factorial(n-1);
    }
}
