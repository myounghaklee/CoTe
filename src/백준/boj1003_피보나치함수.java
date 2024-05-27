package 백준;

import java.util.Scanner;

public class boj1003_피보나치함수 {
    private static int[] zeroCnt;
    private static int[] oneCnt;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[] inputs = new int[T];
        int N = 0;

        for (int i = 0; i < T; i++) {
            inputs[i] = sc.nextInt();
            if (inputs[i] > N) {
                N = inputs[i];
            }
        }
        zeroCnt = new int[N + 1];
        oneCnt = new int[N + 1];
        fiboDP(N);

        // 결과 출력
        for (int i = 0; i < T; i++) {
            int toN = inputs[i];
            System.out.println(zeroCnt[toN] + " " + oneCnt[toN]);
        }
    }

    private static void fiboDP(int n) {
        // 기본 값 설정
        zeroCnt[0] = 1;
        oneCnt[0] = 0;
        if (n > 0) {
            zeroCnt[1] = 0;
            oneCnt[1] = 1;
        }

        //memoization dp
        for (int i = 2; i <= n; i++) {
            zeroCnt[i] = zeroCnt[i - 1] + zeroCnt[i - 2];
            oneCnt[i] = oneCnt[i - 1] + oneCnt[i - 2];
        }
    }
}
