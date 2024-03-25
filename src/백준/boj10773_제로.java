package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj10773_제로 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), "");
        int N = Integer.parseInt(st.nextToken());
        Stack<Long> stack = new Stack<>();
        for(int i = 0; i<N ; i++){
            st = new StringTokenizer(br.readLine(), "");
            long input = Long.parseLong(st.nextToken());
            if(input != 0)stack.push(input);
            else stack.pop();
        }

        long ans =0;
        if(!stack.empty()){
            while (!stack.empty()){
                ans += stack.pop();
            }
        }
        System.out.println(ans);
    }
}
