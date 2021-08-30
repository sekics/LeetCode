package main.leetcode.dynamicprogramming.statecompression;

import java.util.Arrays;

public class MinSessions {

    public int minSessions( int[] tasks , int sessionTime ){
        int n = tasks.length ;
        int m = 1 << n ;
        int[] dp = new int[ m ] ;
        Arrays.fill( dp , 20 );
        //预处理
        //对于每一中状态，如果当前状态满足花费小于sessionTime就是一种可能的解
        for( int i = 1 ; i < m ; i ++ ){
            int state = i , spend = 0 ;
            int index = 0 ;
            while( state > 0 ){

                if( (state & 1) == 1 ){
                    spend += tasks[ index ] ;
                }
                state = state >> 1 ;
                index ++ ;
            }
            // System.out.println( i + " " + spend ) ;
            if( spend <= sessionTime ){
                dp[i] = 1 ;
            }
        }
        // System.out.println( Arrays.toString(dp) ) ;
        //列举每个状态的二进制子集，如果当前状态的二进制子集更小，更新为更小的值
        for( int i = 1 ; i < m ; i ++ ){
            if( dp[i] == 1 ){
                continue ;
            }
            else{
                for( int j = i ; j > 0 ; j = ( j - 1 ) & i ){
                    dp[i] = Math.min( dp[i] , dp[j] + dp[ i ^ j ] ) ;
                }
            }
        }
        return dp[ m - 1 ] ;
    }
}
