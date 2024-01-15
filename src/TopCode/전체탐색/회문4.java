package TopCode.전체탐색;

import java.util.Scanner;

public class 회문4 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        System.out.println(find(s));
    }

    public static int find(String s){
        //답의 문자 길이 결정
        for(int i = s.length(); ; i++){
            boolean isPalindrome = true;
            for(int j = 0; j<s.length(); j++){
                //반대쪽에 문자가 존재하는데 다를 경우 isPalindrome false
                if((i-j-1)<s.length() && s.charAt(j) != s.charAt(i-j-1)){
                    isPalindrome = false;
                    break;
                }
            }

            if(isPalindrome) return i;
        }
    }
}
