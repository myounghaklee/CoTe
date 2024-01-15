package 백준;

public class boj4673_셀프넘퍼 {
    public static boolean selfNumCheck[] = new boolean[10001];
    public static void main(String[] args) {


        selfNumCheck[0] = true;

        for(int i = 1; i<10000; i++){
            int now = d(i);
            if(now<=10000) selfNumCheck[now] = true;
        }

        for(int i =0 ;i<10001; i++){
            if(!selfNumCheck[i]){
                System.out.println(i);
            }

        }
    }

    public static int d(int n){
        int sum = n;

        while(n !=0){
            sum += n%10;
            n = n/10;
        }
        return sum;
    }
}