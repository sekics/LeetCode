package main.leetcode.dynamicprogramming.knapsack;

import java.util.Arrays;

public class CoinChange {

    public int coinChange(int[] coins , int amount ){
        int INF = 100000 ;
        Arrays.sort(coins) ;
        int n = coins.length ;
        int[] coins_ = new int[ n + 1 ] ;
        for( int i = 0 ; i < n ; i ++ ){
            coins_[ i + 1 ] = coins[i] ;
        }
        int[][] dp = new int[ n + 1 ][ amount + 1 ] ;
        for( int i = 0 ; i <= n ; i ++ ){
            Arrays.fill( dp[i] , INF );
        }
        dp[0][0] = 0 ;
        for( int i = 1 ; i <= n ; i ++ ){
            dp[i][0] = 0 ;
            for( int j = 1 ; j <= amount ; j ++ ){
                dp[i][j] = Math.min( dp[i][j] , dp[ i - 1 ][j] ) ;
                if( j >= coins_[i] ){
                    for( int k = 1 ; k <= j / coins_[i] ; k ++ ){
                        int now = k * coins_[i] ;
                        dp[i][j] = Math.min( dp[i][j] , k + dp[ i - 1 ][ j - now ] ) ;
                    }
                }
            }
        }
        int ans = INF ;
        for( int i = 1 ; i <= n ; i ++ ){
            ans = Math.min( ans , dp[i][amount]) ;
        }
        return ans == INF ? -1 : ans ;
    }

    public int coinChangeOptim( int coins[] , int amount ){
        int INF = 10001 ;
        Arrays.sort(coins) ;
        int n = coins.length ;
        int[] coins_ = new int[ n + 1 ] ;
        for( int i = 0 ; i < n ; i ++ ){
            coins_[ i + 1 ] = coins[i] ;
        }
        int[] dp = new int[ amount + 1 ] ;
        Arrays.fill( dp , INF );
        dp[0] = 0 ;
        for( int i = 1 ; i <= n ; i ++ ){
            for( int j = 1 ; j <= amount ; j ++ ){
                if( j >= coins_[i] ){
                    for( int k = 1 ; k <= j / coins_[i] ; k ++ ){
                        int now = k * coins_[i] ;
                        dp[j] = Math.min( dp[j] , k + dp[ j - now ] ) ;
                    }
                }
            }
        }
        return dp[ amount ] == INF ? -1 : dp[ amount ];
    }
}
