package 백준;

import javax.swing.text.html.ListView;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj5014_스타트링크 {

    private static Integer F;
    private static Integer S;
    private static Integer G;
    private static Integer U;
    private static Integer D;
    private static boolean[] isVisited;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        F = Integer.valueOf(st.nextToken()); //total
        S = Integer.valueOf(st.nextToken()); //현재
        G = Integer.valueOf(st.nextToken()); //목표
        U = Integer.valueOf(st.nextToken());
        D = Integer.valueOf(st.nextToken());
        isVisited = new boolean[F + 1];

        if(S==G){
            System.out.println(0);
            return;
        }
        bfs(S);


    }

    private static void bfs(Integer s) {
        Queue<Integer> q = new LinkedList<>();
        int[] buttonCnt = new int[F + 1];
        q.add(s);
        isVisited[s] = true;
        buttonCnt[s] = 0;

        while (!q.isEmpty()) {
            int now = q.poll();

            if (now == G) {
                System.out.println(buttonCnt[now]);
                return;
            }

            for (int i = 0; i < 2; i++) {
                int next = 0;
                if (i == 0) next = now + U;
                if (i == 1) next = now - D;
                if (next >= 1 && next <= F && !isVisited[next]) {
                    isVisited[next] = true;
                    buttonCnt[next] = buttonCnt[now] + 1;
                    q.add(next);
                }
            }
        }
        System.out.println("use the stairs");
    }
}