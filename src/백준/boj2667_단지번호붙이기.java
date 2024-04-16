package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj2667_단지번호붙이기 {

    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, 1, -1};
    static int map [][];
    static boolean isVisited [][];
    static List<Integer> result = new ArrayList<>();
    static int N;
    static int cnt;
    static class Point {
        int y;
        int x;
        public Point(int y, int x){
            this.y = y;
            this.x = x;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int [N][N];
        isVisited = new boolean[N][N];
        for(int i=0; i<N; i++){
             String line = br.readLine();
            for(int j = 0 ;j<N; j++){
                map[i][j] = line.charAt(j) - '0';
            }
        }

        for(int i=0; i<N; i++){
            for(int j = 0 ;j<N; j++){
                cnt =0;
                if(map[i][j] == 1 && !isVisited[i][j]) {
                    bfs(i, j);
                    //result ++;
                }
            }
        }
        Collections.sort(result);

        System.out.println(result.size());
        for(int i : result){
            System.out.println(i);
        }
    }

    private static void bfs(int y, int x) {

        isVisited[y][x] = true;
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(y, x));
        cnt = 0;
        while (!q.isEmpty()){
            Point p = q.poll();
            cnt ++ ;

            for(int i = 0 ;i<4; i++){
                int ny = p.y + dy[i];
                int nx = p.x + dx[i];

                if(ny>=0 && ny<N && nx>=0 && nx<N){
                    if(!isVisited[ny][nx] && map[ny][nx] ==1){
                        isVisited[ny][nx] = true;
                        q.add(new Point(ny, nx));
                    }
                }
            }

        }
        result.add(cnt);


    }

}
