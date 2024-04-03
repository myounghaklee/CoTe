package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj15686_치킨배달 {

    static int city[][];
    static List<Position> chicken = new ArrayList<>();
    static List<Position> home = new ArrayList<>();
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        city = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                city[i][j] = Integer.parseInt(st.nextToken());
                if (city[i][j] == 1) home.add(new Position(i, j));
                if (city[i][j] == 2) chicken.add(new Position(i, j));
            }
        }

        int result = 0;
        for (int i = 0; i < home.size(); i++) {
            min = Integer.MAX_VALUE;
            Position temp;
            Position nHome = home.get(i);
            for (int j = 0; j < chicken.size(); j++) {
                temp = chicken.get(i);
                int dist = Math.abs(nHome.x - temp.x) + Math.abs(nHome.y - temp.y);
                min = Math.min(dist, min);
            }

            result += min;
        }

    }

    static class Position {
        int y;
        int x;

        Position(int y, int x) {
            this.x = x;
            this.y = y;
        }
    }

}
