package main.leetcode.dynamicprogramming.statecompression;

public class CountArrangement {

    public int countArrangement( int n ){

        int mask = 1 << n ;
        int[][] dp = new int[ n + 1 ][ mask ] ;
        dp[0][0] = 1 ;
        for( int i = 1 ; i <= n ; i ++ ){
            for( int m = 0 ; m < mask ; m ++ ){

                for( int k = 1 ; k <= n ; k ++ ){

                    if( ( ( m >> ( k - 1 ) ) & 1) == 0 ) continue ;

                    if( ( i % k != 0 ) &&  ( k % i != 0 ) ) continue ;

                    dp[i][m] += dp[ i - 1 ][ m & ( ~( 1 << ( k - 1 ) ) ) ] ;
                }
            }
        }
        return dp[n][ mask - 1 ] ;
    }
}
