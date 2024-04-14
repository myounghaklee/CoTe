package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class boj2606_바이러스 {
    static boolean[] isVisited;
    static int[][] arr;
    static int count = 0;

    static int node, line;

    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        node = Integer.parseInt(br.readLine());
        line = Integer.parseInt(br.readLine());

        arr = new int[node+1][node+1];
        isVisited = new boolean[node+1];

        for(int i = 0 ; i < line ; i ++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = 1;
            arr[b][a] = 1;
        }
        dfs(1);
        System.out.println(count-1);

    }

    private static void dfs(int now) {
        //기저조건 없음

        count++;
        isVisited[now] = true;
        for(int i = 0 ;i<= node; i++){
            if(arr[now][i] == 1 && !isVisited[i])
                dfs(i);
        }
    }
    }
