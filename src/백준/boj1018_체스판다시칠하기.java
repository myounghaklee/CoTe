package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1018_체스판다시칠하기 {

    static char[][] board;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        board = new char[N][M];

        // input
        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = row.charAt(j);
            }
        }

        // 탐색
        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                int result = findMinSquare(i, j);
                min = Math.min(min, result);
            }
        }

        System.out.println(min);
    }

    private static int findMinSquare(int y, int x) {
        int endY = y + 8;
        int endX = x + 8;
        int cnt1 = 0; // 첫 칸이 W일 경우
        int cnt2 = 0; // 첫 칸이 B일 경우

        for (int i = y; i < endY; i++) {
            for (int j = x; j < endX; j++) {
                if ((i + j) % 2 == 0) {
                    if (board[i][j] != 'W') cnt1++;
                    else cnt2++;
                } else {
                    if (board[i][j] != 'B') cnt1++;
                    else cnt2++;
                }
            }
        }

        return Math.min(cnt1, cnt2);
    }
}
