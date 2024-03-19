package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

/*
탐욕으로도 풀 수 있을듯?

 */
public class boj14501_퇴사 {

    private static int N;
    static int maxCnt = Integer.MIN_VALUE;
    static int[][] work;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        work = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 2; j++) {
                work[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //완전 탐색
        dfs(0, 0);
        System.out.println(maxCnt);
    }

    private static void dfs(int day, int pay) {
        //기저조건
        if (day >= N) {
            maxCnt = Math.max(pay, maxCnt);
            return;
        }

        //다음 상담
        if (day + work[day][0] <= N) { // 상담을 끝마칠 수 있다면 -> 상담이 끝난 날짜와 상담비 넣음
            dfs(day + work[day][0], pay + work[day][1]);
        } else { // 상담을 끝마칠 수 없다면 -> 상담이 끝난 날짜만 넘겨준다(탈출 조건으로 써먹음)
            dfs(day + work[day][0], pay);
        }

        dfs(day + 1, pay);
    }

}
