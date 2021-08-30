package main.leetcode.dynamicprogramming.statecompression;

import java.util.Arrays;

public class CanIWin {

    public int countOne( int item ){
        int ans = 0 ;
        while( item > 0 ){
            ans = (item & 1) == 1 ? ans + 1 : ans ;
            item = item >> 1 ;
        }
        return ans ;
    }
    public boolean canIWin(int maxChoosableInteger , int desiredTotal){

        int[][] dp = new int[ maxChoosableInteger + 1 ][ 1 << maxChoosableInteger ] ;
        for( int i = 0 ; i < maxChoosableInteger ; i ++ ){
            dp[1][ 1 << i ] = i + 1 ;
        }
        System.out.println(Arrays.toString( dp[1] ) ) ;
        for( int i = 2 ; i <= maxChoosableInteger ; i ++ ){
            for( int j = 1 ; j < 1 << maxChoosableInteger ; j ++ ){

                if( countOne(j) == i ){
                    for( int k = 0 ; k < maxChoosableInteger ; k ++ ){
                        dp[i][j] = Math.max( dp[i][j] , dp[ i - 1 ][ j & ( ~ ( 1 << k ) ) ] + dp[1][ 1 << k ] ) ;
                    }
                    if( i % 2 == 0 && dp[i][j] > desiredTotal ){
                        return false ;
                    }
                }
                else{
                    continue ;
                }
            }
        }
        return true ;
    }
}
