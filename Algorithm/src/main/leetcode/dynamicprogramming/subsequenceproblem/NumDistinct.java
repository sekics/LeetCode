package main.leetcode.dynamicprogramming.subsequenceproblem;

import java.util.Arrays;

public class NumDistinct {

    public int numDistinct(String s,String t){
        int m = s.length() , n = t.length() ;
        int[][] dp = new int[m + 1 ][ n + 1 ] ;
        for( int i = 0 ; i <= m ; i ++ ){
            dp[i][ n  ] = 1 ;
        }
        for( int i = m - 1 ; i >= 0 ; i -- ){
            for( int j = n - 1 ; j >= 0 ; j -- ){
                if( s.charAt(i) == t.charAt(j) ){
                    dp[i][j] = dp[ i + 1 ][ j + 1 ] + dp[ i + 1 ][j] ;
                }
                else{
                    dp[i][j] = dp[ i + 1 ][j] ;
                }
            }
        }
        return dp[0][0] ;
    }

    public int numDistinctOptim(String s,String t){
        int m = s.length() , n = t.length() ;
        int[] dp = new int[ n + 1 ] ;
        dp[0] = 1 ;
        for( int i = m - 1 ; i >= 0 ; i -- ){
            for( int j = n - 1 ; j >= 0 ; j -- ){
                if( s.charAt(i) == t.charAt(j) ){
                    dp[j] = dp[ j + 1 ] + dp[j] ;
                }
            }
            System.out.println(Arrays.toString(dp)) ;
        }
        return dp[0] ;
    }

    public int numDistinctOptim2(String s, String t) {
        int sl = s.length();
        int tl = t.length();
        int[] dp = new int[tl+1];
        dp[tl] = 1;
        for (int i = sl-1; i >= 0; i--){
            for (int j = 0; j < tl; j++){
                if (t.charAt(j) == s.charAt(i)){
                    dp[j] += dp[j+1];
                }
            }
            System.out.println(Arrays.toString(dp)) ;
        }
        return dp[0];
    }
}
