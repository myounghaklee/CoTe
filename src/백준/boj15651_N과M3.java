package 백준;

import java.io.*;
import java.util.Scanner;

public class boj15651_N과M3 {
    private static int M;
    private static int N;
    private static int[] arr;
    private static boolean[] isSelected;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        arr = new int[M];

        permu(0);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }

    private static void permu(int cnt) {
        if (cnt == M) {
            for (int i = 0; i < arr.length; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
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
