package main.leetcode.dynamicprogramming;

import java.util.List;

public class WordBreak {

    public boolean wordBreak(String s , List<String> wordDict){
        int n = s.length() ;
        int[][] dp = new int[ n ][ n ] ;
        for( int k = 0 ; k < n ; k ++ ){
            for( int i = 0 ; i < n - k ; i ++ ){

                if( wordDict.contains( s.substring( i , i + k + 1) ) ){
                    dp[i][ i + k ] = 1 ;
                }
                else{
                    for( int j = i ; j < i + k ; j ++ ){
                        // if( k == 7 ){
                        //     System.out.println( i + ":" + j + "   " + ( i + k ) ) ;
                        //     System.out.println( dp[i][j] + ":" + dp[ j + 1 ][ i + k] ) ;
                        // }
                        dp[i][ i + k ] = ( dp[i][ i + k ] )| ( dp[i][j] & dp[ j + 1 ][ i + k ] ) ;
                    }
                }
            }
        }
        // for( int i = 0 ; i < n ; i ++ ){
        //     System.out.println(Arrays.toString(dp[i])) ;
        // }
        if( dp[ 0 ][ n - 1 ] == 1 ){
            return true ;
        }
        else{
            return false ;
        }
    }

    public boolean wordBreakOptim(String s , List<String> wordDict){
        int n = s.length() ;
        int[] dp = new int[n] ;
        for( int i = 0 ; i < n ; i ++ ){
            if( wordDict.contains( s.substring(0,i) ) ){
                dp[i] = 1 ;
            }
            else{
                for( int j = 0 ; j < i ; j ++ ){
                    if( wordDict.contains( s.substring( j + 1 , i  ) ) ){
                        dp[i] = dp[i] | ( dp[j]  ) ;
                    }
                }
            }
        }
        return dp[ n - 1 ] == 1 ? true : false ;
    }
}
