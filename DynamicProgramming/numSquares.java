public class NumSquares{
    int maxN = 101 ;
    public int numSquares(int n){
        int squareRoot = (int)Math.sqrt(n) ;
        dp[0][0] = 0 ;
        int[][] dp = new int[ squareRoot + 1 ][ n + 1 ] ;
        for( int i = 1 ; i <= squareRoot ; i ++ ){
            for( int j = 0 ; j <= n ; j ++ ){
                dp[i][j] = dp[ i - 1 ][j] ;
                int tmp = j ;
                if( j > i * i ){
                    dp[i][j] = Math.min(dp[i][j],dp[i][ j - i * i] + 1 ) ;
                }
            }
        }
        int min = Integer.MAX_VALUE ;
        for( int i = 1 ; i <= squareRoot ; i ++ ){
            if( dp[i][n] != 0 && dp[i][n] < min ){
                min = dp[i][n] ;
            }
        }
        return min ;
    }

    public int numSquaresOpt(int n){
        int squareRoot = (int)Math.sqrt(n) ;
        int[] dp = new int[ n + 1 ] ;
        for( int i = 0 ; i <= n ; i ++ ){
            dp[i] = i ;
        }
        for( int i = 2 ; i <= squareRoot ; i ++ ){
            for( int j = 0 ; j <= n ; j ++ ){
                if( j >= i * i ){
                    dp[j] = Math.min(dp[j],dp[ j - i * i ] + 1 ) ;
                }
            }
        }
        return dp[n] ;
    }
    int cnt ;
    int target ;
    int squareRoot;
    public numSquaresDFS(int n){
        cnt = n ;
        target = n ;
        squareRoot = (int)Math.sqrt(n) ;
        DFS(1,0,0) ;
    }

    public void DFS(int nowI,int nowCnt,int nowSum){
        if( nowSum == target){
            if( nowCnt < cnt ){
                cnt = nowCnt ;
            }
            return ;
        }
        else if( nowSum > target){
            return ;
        }
        else{
            DFS(nowI,nowCnt + 1 ,nowSum + nowI * nowI) ;
            for( int i = nowI + 1 ; i <= squareRoot ; i ++ ){
                DFS(i,nowCnt + 1 ,nowSum + i * i ) ;
            }
        }
    }
}