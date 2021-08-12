public class GetMoneyAmount{
    
    public int getMoneyAmount(int n){
        int[][] dp = new int[ n + 1 ][ n + 1 ] ;
        for( int i = 0 ; i <= n ; i ++ ){
            for( int j = 0 ; j <= n ; j ++ ){
                dp[i][j] = Integer.MAX_VALUE ;
            }
        }
        
        for( int i = 0 ; i <= n ; i ++ ){
            dp[0][i] = 0 ;
        }
        for( int j = 2 ; j <= n ; j ++ ){
            
            for( int i = j ; i >= 1 ; i -- ){

                for( int k = i + 1 ; k < j ; k ++ ){
                    dp[i][j] =  Math.min(  k + Math.max( dp[i][ k - 1 ] , dp[ k + 1 ][j] ) , dp[ i ][ j ]) ;
                }
                dp[i][j] = Math.min(dp[i][j],dp[ i + 1 ][j] + i) ;
                dp[i][j] = Math.min(dp[i][j],dp[ i ][ j - 1 ] + j ) ;
            }
        }
        return dp[1][n] ;
    }
}