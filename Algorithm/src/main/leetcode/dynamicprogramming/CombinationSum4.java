package main.leetcode.dynamicprogramming;

import java.util.Arrays;

public class CombinationSum4 {

    public int combinationSum4( int[] sums , int target ){
        int n = sums.length ;
        int[][] dp = new int[ n + 1 ][ target ] ;
        Arrays.fill( dp[0] , 0 ) ;
        dp[0][0] = 1 ;
        for( int i = 1 ; i <= n ; i ++ ){
            dp[i][0] = 1 ;
            for( int j = 1 ; j <= target ; j ++ ){
                dp[i][j] = dp[ i - 1 ][j] ;

                int k = 1 , nowSum = k * sums[i] ;
                while( nowSum <= j ){
                    dp[i][j] = dp[i][j] + dp[ i - 1 ][ j - nowSum ] ;
                    k ++ ;
                    nowSum = k * sums[i] ;
                }
            }
        }
        return dp[ n ][ target ] ;
    }
}
