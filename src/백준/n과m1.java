package 백준;

import java.util.Scanner;

public class n과m1 {
    private static int [] array ;
    private static boolean [] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        array = new int [N];
        visited = new boolean[N];
        for(int i = 0; i<N; i++){
            array[i] = i+1;
        }


        combination(array, visited, 0, N, M);
    }

    private static void combination(int[] array, boolean[] visited, int depth, int n, int r) {
        if( r == 0){
            for(int i = 0 ;i<n ; i++){
                if(visited[i]){
                    System.out.print(array[i] + " ");
                }
            }
            System.out.println();
        }
        if(depth == n) return;
        visited[depth] = true;
        combination(array, visited, depth+1, n, r-1);
        visited[depth] = false;
        combination(array, visited, depth+1, n, r);

    }

}
