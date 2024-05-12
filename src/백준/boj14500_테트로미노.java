package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj14500_테트로미노 {
    static int N, M;
    static int[][] board;
    static boolean[][] visited;
    static int maxSum = 0;
    // DFS 탐색을 위한 방향 벡터 (상, 하, 좌, 우)
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = true;
                dfs(i, j, 0, 0);
                visited[i][j] = false;
                checkTShape(i, j);
            }
        }

        System.out.println(maxSum);
    }

    static void dfs(int x, int y, int depth, int sum) {
        if (depth == 4) {
            maxSum = Math.max(maxSum, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny]) {
                visited[nx][ny] = true;
                dfs(nx, ny, depth + 1, sum + board[nx][ny]);
                visited[nx][ny] = false;
            }
        }
    }

    static void checkTShape(int x, int y) {
        // 중심을 기준으로 'ㅗ', 'ㅜ', 'ㅏ', 'ㅓ' 모양 체크
        int[][] tShapes = {
                {-1, 0, 1, 0}, {0, 1, 0, -1}, {1, 0, -1, 0}, {0, -1, 0, 1}
        };
        int[] px = {0, 1, 0, -1};
        int[] py = {-1, 0, 1, 0};

        for (int i = 0; i < 4; i++) {
            int sum = board[x][y];
            boolean valid = true;

            for (int j = 0; j < 4; j++) {
                if (j == i) continue; // 네 방향 중 세 방향만 사용
                int nx = x + px[j];
                int ny = y + py[j];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    sum += board[nx][ny];
                } else {
                    valid = false;
                    break;
                }
            }

            if (valid) {
                maxSum = Math.max(maxSum, sum);
            }
        }
    }

}
