package 백준;

import java.util.Scanner;

public class boj15651_N과M3 {
    private static int M;
    private static int N;
    private static int[] arr;
    private static boolean[] isSelected;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[M];
        isSelected = new boolean[N + 1];

        permu(0);

    }

    private static void permu(int cnt) {
        if (cnt == M) {
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            //System.out.println(Arrays.toString(arr));
            return;
        }

        for (int i = 1; i <= N; i++) {
            //if (isSelected[i]) continue;
            arr[cnt] = i;
            //isSelected[i] = true;
            permu(cnt + 1);
            //isSelected[i] = false;
        }
    }
}
