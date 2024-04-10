package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj15655_N과M6 {
    private static int N;
    private static int R;
    private static int[] arr;
    private static boolean[] isSelected;
    private static int[] ans;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        arr = new int [N];
        st = new StringTokenizer(br.readLine());
        for(int i =0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        ans = new int[R];
        isSelected = new boolean[N];
        combi(0,0);

    }
    private static void combi(int cnt, int start) {
        //±âÀúÁ¶°Ç
        if (cnt == R) {
            for (int i = 0; i < R; i++) {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
            return;
        }
        //À¯µµÆÄÆ®
        for (int i = start; i < N; i++) {
            if(isSelected[i]) continue;
            ans[cnt] = arr[i];
            isSelected[i] = true;
            combi(cnt + 1, i);
            isSelected[i] = false;

        }

    }
}
