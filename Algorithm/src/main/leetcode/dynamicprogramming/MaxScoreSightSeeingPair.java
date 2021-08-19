package main.leetcode.dynamicprogramming;

public class MaxScoreSightSeeingPair {

    public int maxScoreSightSeeingPair( int[] values){
        int n = values.length ;
        int[][] dp = new int[n][n] ;
        int ans = 0 ;
        for( int i = 0 ; i < n ; i ++ ){
            for( int j = 0 ; j < i ; j ++ ){
                dp[i][j] = Math.max( dp[i][j] , values[i] + values[j] + i - j ) ;
                ans = Math.max( ans , dp[i][j]) ;
            }
        }
        return ans ;
    }

    public int maxScoreSightSeingPair( int[] values ){
        int n = values.length ;
        int[] dp = new int[n] ;
        dp[0] = values[0] ;
        dp[1] = values[0] + values[1] - 1 ;
        int[] pre = new int[2] ;
        pre[0] = 0 ;
        pre[1] = values[0] ;
        int ans = dp[1] ;
        for( int i = 3 ; i < n ; i ++ ){
            for( int j = pre[0] ; j < i ; j ++ ){
                if( values[j] > pre[1] || values[i] + values[j] - j + i > values[i] + pre[1] - j + pre[0] ){
                    pre[0] = j ;
                    pre[1] = values[j] ;
                }
                dp[i] = Math.max( dp[i] , pre[1] + values[j] - j + pre[0] ) ;
            }
            ans = Math.max( ans , dp[i] ) ;
        }
        return ans ;
    }

    public int maxScoreSightSeeingPairOptim(int[] values){

        int n = values.length ;
        int ans = 0 ;
        int mx = values[0] ;
        for( int i = 1 ; i < n ; i ++ ){
            ans = Math.max( ans , mx + values[i] - i ) ;
            mx = Math.max( mx , values[i] + i ) ;
        }
        return ans ;

    }
}
