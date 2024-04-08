package 백준;

import java.util.Scanner;

public class boj15650_N과M2 {

    static int [] numbers;
    static int N,R;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        R = sc.nextInt();
        numbers = new int [R];
        //combi(0,1);
        recursiveCombi(0,1);

    }

    static void combi(int cnt, int start) {
        if(cnt==R) {
            for(int i =0; i<R; i++) {
                System.out.print(numbers[i] + " ");
            }
            System.out.println();
            return;
        }
        for(int i =start; i<=N; i++) {
            numbers[cnt] = i;
            combi(cnt+1, i+1);
        }
    }

    // 재귀를 사용한 조합 생성 메서드
    static void recursiveCombi(int count, int start) {
        if (count == R) {
            // 조합이 완성되었을 때, 조합 출력
            for (int i = 0; i < R; i++) {
                System.out.print(numbers[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i <= N; i++) {
            numbers[count] = i; // 현재 위치에 숫자 선택
            recursiveCombi(count + 1, i + 1); // 다음 숫자를 선택하기 위해 재귀 호출
        }
    }
}
