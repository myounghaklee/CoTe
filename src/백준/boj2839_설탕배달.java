package 백준;

import java.util.Scanner;

public class boj2839_설탕배달 {
    private static int[] memo;
    private static boolean[] visited;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 설탕의 무게 입력
        int count = 0; // 봉지 수

        while (N > 0) {
            if (N % 5 == 0) { // 현재 남은 설탕 무게가 5의 배수인 경우
                count += N / 5; // 5kg 봉지로만 배달
                N = 0; // 남은 설탕 무게를 0으로 설정
                break;
            }
            N -= 3; // 5의 배수가 될 때까지 3kg을 빼나감
            count++; // 3kg 봉지를 사용한 횟수 증가
        }

        if (N < 0) { // 정확히 0이 되지 않고 음수가 되었다면 정확히 맞추기 불가능
            System.out.println(-1); // 불가능한 경우 -1 출력
        } else {
            System.out.println(count); // 가능한 경우 봉지 수 출력
        }

        sc.close();
    }
}
