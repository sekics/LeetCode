package main.leetcode.dynamicprogramming;

import java.util.Arrays;

public class MinDistance583 {

    public int minDistance( String word1 , String word2 ){

        int n = word1.length() ;
        int m = word2.length() ;
        int[][] dp = new int[ m + 1 ][ n + 1 ] ;
        for( int i = n ; i >= 0 ; i -- ){
            dp[ m ][i] = n - i ;
        }
        for( int i = m ; i >= 0 ; i -- ){
            dp[i][n] = m - i ;
        }
        for( int i = m - 1 ; i >= 0 ; i -- ){
            for( int j = n - 1 ; j >= 0 ; j -- ){
                if( word2.charAt(i) == word1.charAt(j) ){
                    dp[ i ][ j ] = Math.min( Math.min( dp[ i + 1][j] , dp[ i ][ j + 1 ] )+ 1 , dp[ i + 1 ][ j + 1 ] ) ;
                }
                else{
                    dp[i][j] = Math.min( Math.min( dp[ i + 1 ][ j ] , dp[ i ][ j + 1 ] ) + 1 , dp[ i + 1 ][ j + 1 ] + 2 ) ;
                }
            }
        }
        // for( int i = 0 ; i <= m ; i ++ ){
        //     System.out.println( Arrays.toString( dp[i] ) ) ;
        // }
        return dp[0][0] ;
    }
}
