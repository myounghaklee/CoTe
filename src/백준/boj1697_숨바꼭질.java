package 백준;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj1697_숨바꼭질 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int subin = sc.nextInt();
        int brother = sc.nextInt();
        if (subin == brother) {
            System.out.println(0);
        } else {
            bfs(subin, brother);
        }
        sc.close();
    }

    private static void bfs(int subin, int brother) {
        Queue<Integer> q = new LinkedList<>();
        int[] distance = new int[100001];
        q.add(subin);
        distance[subin] = 0;
        while (!q.isEmpty()) {
            int now = q.poll();
            int[] nextSubin = {now + 1, now - 1, now * 2};
            for (int next : nextSubin) {
                if (next >= 0 && next <= 100000 && distance[next] == 0 && next != subin) {
                    distance[next] = distance[now] + 1; // 이전 위치에서 1분 추가
                    if (next == brother) {
                        System.out.println(distance[next]);
                        return;
                    }
                    q.add(next);
                }
            }
        }
    }
}
