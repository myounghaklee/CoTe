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

    static int maxCnt = Integer.MIN_VALUE;
    static int [][]work ;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        work = new int [N][2];
        for(int i = 0 ;i<N ;i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j<2; j++){
                work[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //완전 탐색


    }
}
