package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj2644_촌수개산 {
    private static int N;
    private static int[][] arr;
    private static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int person1 = Integer.parseInt(st.nextToken());
        int person2 = Integer.parseInt(st.nextToken());
        arr = new int[N + 1][N + 1];
        isVisited = new boolean[N + 1];
        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = 1;
            arr[b][a] = 1;
        }

        int result = dfs(person1, person2, 0);
        System.out.println(result == Integer.MAX_VALUE ? -1 : result);
    }

    private static int dfs(int current, int target, int depth) {
        if (current == target) {
            return depth;
        }

        isVisited[current] = true;
        int minDistance = Integer.MAX_VALUE;

        for (int i = 1; i <= N; i++) {
            if (arr[current][i] == 1 && !isVisited[i]) {
                int result = dfs(i, target, depth + 1);
                if (result < minDistance) {
                    minDistance = result;
                }
            }
        }

        isVisited[current] = false;
        return minDistance;
    }
}
