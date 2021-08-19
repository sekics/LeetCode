package main.leetcode.dynamicprogramming.statecompression;

import java.util.Arrays;

public class CheckRecord {

    int MOD = 1000000007 ;
    public int checkRecorc(int n){
        int[][] dp = new int[ n  ][6] ;
        dp[0][0] = dp[0][1] = dp[0][2] = 1 ;
        for( int i = 0 ; i < n - 1 ; i ++ ){
            for( int j = 0 ; j < 6 ; j ++ ){
                for( int m = 0 ; m < 3 ; m ++ ){
                    if( m == 0 ){
                        if( j % 2 == 0 ){
                            dp[ i + 1 ][0] = ( dp[ i + 1 ][0] + dp[ i ][ j ] ) % MOD ;
                        }
                        if( ( j & 1 ) == 1 ){
                            dp[ i + 1 ][1] = ( dp[ i + 1 ][1] + dp[ i ][ j ] ) % MOD ;
                        }
                    }
                    else if( m == 1 ){
                        if( j == 0 ){
                            dp[ i + 1 ][2] = ( dp[ i + 1 ][2] + dp[i][j] ) % MOD ;
                        }
                        else if( j == 1 ){
                            dp[ i + 1 ][3] = ( dp[ i + 1 ][3] + dp[i][j] ) % MOD ;
                        }
                        else if( j == 2 ){
                            dp[ i + 1 ][4] = ( dp[ i + 1 ][4] + dp[i][j] ) % MOD ;
                        }
                        else if( j == 3 ){
                            dp[ i + 1 ][5] = ( dp[ i + 1 ][5] + dp[i][j] ) % MOD ; ;
                        }
                    }
                    else if( m == 2 ){
                        if( ( j & 1 ) == 1 ){
                            continue ;
                        }
                        else {
                            dp[ i + 1 ][1] = ( dp[ i + 1 ][1] + dp[i][j] ) % MOD ;
                        }
                    }
                    dp[i][j] %= MOD ;
                }
            }
            // System.out.println(Arrays.toString(dp[i])) ;
        }
        int ans = 0 ;
        for( int i = 0 ; i < 6 ; i ++ ){
            ans =  ( dp[ n - 1 ][i] + ans ) % MOD ;
        }
        return ans ;
    }
}
