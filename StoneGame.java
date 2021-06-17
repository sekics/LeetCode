public class StoneGame{

    //另一种dp数组形式，头尾各选一个
    //dp[i][j]表示当前的头是i号元素，尾是j号元素
    
    public boolean stoneGame(int[] piles){
        int n = piles.length ;
        int[][] dp = new int[n][n] ;
        for( int i = 0 ; i < n ; i ++ ){
            dp[i][i] = piles[i] ;
        }
        for( int i = n - 2 ; i >= 0 ; i -- ){
            for( int j = i + 1 ; j < n ; j ++ ){
                dp[i][j] = Math.max( piles[i] - dp[ i + 1 ][j] , piles[j] - dp[i][ j - 1 ] ) ;
            }
        }
        return dp[0][ n - 1 ] > 0 ; 
    }

    public boolean stoneGame(int[] piles){
        int n = piles.length , sum = 0 ;
        for( int pile : piles){
            sum += pile ;
        }
        int[][] dp = new int[ n + 1 ][ sum/2 + 2] ;
        int left = 1 , right = n  ;
        int i ;
        while( left < right ){
            if( ( right - left + 1 ) % 2 == 0 ){
                i = left ;
            }
            else{
                i = right ;
            }
            for( int j = 0 ; j <= sum/2 + 1 ; j ++ ){
                if( i == 1 || i == n ){
                    if( j <= piles[i] ){
                        dp[i][j] = 1 ;
                    }
                }
                else{
                    dp[i][j] = dp[ left - 1 ][j] == 1 ? 1 : dp[ right + 1 ][j] ;
                    if( dp[i][j] == 0 ){
                        if( dp[ left - 1 ][ j - piles[i] ] == 1 || dp[ right + 1 ][ j - piles[i] ] == 1 ){
                            dp[i][j] = 1 ;
                        }
                    }
                }
            }
            if( (right - left + 1 ) % 2 == 0 ){
                left ++ ;
            }
            else{
                right -- ;
            }
        }
        for( int i = 1 ; i <= n ; i ++ ){
            if( dp[i][ sum/2 + 1 ] == 1 ){
                return true ;
            }
        }
        return false ;
    }
}