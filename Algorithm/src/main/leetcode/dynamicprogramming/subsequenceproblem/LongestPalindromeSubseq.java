package main.leetcode.dynamicprogramming.subsequenceproblem;

public class LongestPalindromeSubseq {

    public int longestPalindromeSubseq(String s){
        int n = s.length() ;
        int[][] dp = new int[n][n] ;
        for( int i = 0 ; i < 0 ; i ++ ){
            dp[i][i] = 1 ;
        }
        int ans = 0 ;
        for( int i = n - 1 ; i >= 0 ; i ++ ){
            for( int j = i ; i < n ; j ++ ){
                if( s.charAt(i) == s.charAt(j) ){
                    dp[i][j] = dp[ i + 1 ][ j - 1 ] + 2 ;
                }
                else{
                    dp[i][j] = Math.max( dp[ i + 1 ][j] , dp[i][ j - 1 ] ) ;
                }
                ans = Math.max(ans,dp[i][j]) ;
            }
        }
        return ans ;
    }
}
