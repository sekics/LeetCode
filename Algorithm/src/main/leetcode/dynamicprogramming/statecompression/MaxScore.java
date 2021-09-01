package main.leetcode.dynamicprogramming.statecompression;

public class MaxScore {

    public int countOne( int state ){
        int ans = 0 ;
        while( state > 0 ){
            if( (state & 1) == 1 ){
                ans ++ ;
            }
            ans = ans >> 1 ;
        }
        return ans ;
    }

    public int getGCD( int state , int[] nums ){
        int[] num = new int[2] ;
        int i = 0 ;
        int idx = 0 ;
        while( state > 0 ){
            if( (state & 1) == 1 ){
                num[ i ++ ] = idx ;
            }
            idx ++ ;
            state = state >> 1 ;
        }
        return gcd( nums[num[0]],nums[num[0]]) ;
    }

    public int gcd( int a , int b ){
        if( b == 0 ){
            return a ;
        }
        return gcd( b , a % b ) ;
    }

    public int maxScore( int[] nums ){
        int n = nums.length ;
        int row = n / 2 ;
        int m = 1 << n ;
        int[][] dp = new int[ row + 1 ][ m ] ;
        for( int i = 1 ; i < m ; i ++ ){
            if( countOne(i) == 2 ){
                dp[1][i] = getGCD(i,nums) ;
            }
        }
        for( int i = 2 ; i <= row ; i ++ ){

            for( int j = 1 ; j < m ; j ++ ){

                if( countOne(j) == i * 2 ){
                    for( int k = j ; k > 0 ; k = ( k - 1 ) & j ){
                        int num1 = k ;
                        int num2 = k ^ j ;
                        if( countOne(num2) == 2 ){
                            dp[i][j] = Math.max( dp[i][j] , dp[ i - 1][ j & ( ~num2)] + dp[1][num2] * i ) ;
                        }
                    }
                }
                else{
                    continue ;
                }
            }
        }
        return dp[row][ m - 1 ] ;
    }
}
