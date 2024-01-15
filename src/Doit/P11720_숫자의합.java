package Doit;

import java.util.Scanner;

public class P11720_숫자의합 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        String numString = sc.next();
        char []  numCharArray = numString.toCharArray();
        int sum =0;

        for(int i = 0 ; i<numCharArray.length; i++){
            sum += numCharArray[i] - '0';
        }
        System.out.println(sum);

    }
}
