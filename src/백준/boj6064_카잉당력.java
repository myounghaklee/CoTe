package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj6064_카잉당력 {
    private static int M;
    private static int N;
    private static int X;
    private static int Y;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            X = Integer.parseInt(st.nextToken()) - 1;  // Decrementing to match 0-index based cycle
            Y = Integer.parseInt(st.nextToken()) - 1;

            System.out.println(bfs(0, 0));
        }
    }

    private static int bfs(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        HashSet<Point> visited = new HashSet<>();  // To keep track of visited positions

        q.add(new Point(x, y));
        visited.add(new Point(x, y));

        int ans = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Point now = q.poll();
                int nx = (now.x + 1) % M;
                int ny = (now.y + 1) % N;

                if (nx == X && ny == Y) {
                    return ans;
                }

                Point next = new Point(nx, ny);
                if (!visited.contains(next)) {
                    visited.add(next);
                    q.add(next);
                }
            }
            ans++;
        }
        return -1;  // If no solution is found
    }

    public static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return 31 * x + y;
        }
    }
}
