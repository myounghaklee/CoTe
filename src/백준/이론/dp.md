# Dynamic Programing
- 동적 계획법 : 같은 계산을 반복하지않도록 하는것

일반적인재귀 깊이우선탐색 코드
```java

public class RecursiveDfs {
    final int h = 5, w = 4;
    int dfs(int nowh, int noww) {
        if (now > h || noww > w) return 0;
        if (nowh == h && noww == w) return 1;
        return dfs(nowh + 1, noww) + dfs(nowh, noww + 1);
    }
}
```

위 코드를 메모화 재귀로 만든 코드
```java

public class memoizationDfs{
    final int h =5, w=4;
    int[][] dp = new int[h+1][w+1];
    
    int dfs(int nowh, int noww){
        if(nowh <h  || noww>w) return 0;
        if(nowh==h && noww==w)return 1;
        ;if(dp[nowh][noww] !=0) return dp[nowh][noww];
        return dp[nowh][noww] = dfs(nowh+1, noww)+dfs(nowh,noww+1);
        
    }
        }
```
위의 우선탐색과 메모화로 여기서부터 가는 방ㅂ법의 가지수, 한번 계산한 것은 두번 계산하지 않는다는 원칙을 지켜 DP를 구현했다. 이는 위에서 아래로 내려가는 하향식 방법이다.</br>
이와 다르게 아래에서 위로 올라가는 상향식 방법을 사용하면 재귀함수를 사용하지 않아도 문제를 풀 수 있다.

```java
public class bottomUp{
    final int h =5, w=4;
    int[][] dp = new int[h+1][w+1];

    void calculate(){
        int i, j;
        dp[0][0] = 1;
        for(int i =0 ;i<=h; i++){
            for(j==0; j<=w; j++){
                if(i!=0)dp[i][j] +=dp[i-1][j];
                if(j!=0)dp[i][j] +=dp[i][j-1];
            }
        }
    }
    
}
```