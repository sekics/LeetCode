package main.leetcode.dynamicprogramming;

public class Rob {

    public int rob( int[] nums ){
        if( nums.length == 1 ){
            return nums[0] ;
        }
        int n = nums.length ;
        int[] dp = new int[ n ] ;
        dp[ 0 ] = nums[ 0 ] ;
        dp[ 1 ] = nums[ 1 ] ;
        int ans = Math.max( dp[0] , dp[1] ) ;
        for( int i = 2 ; i < n ; i ++ ){
            for( int j = 0 ; j < i - 1 ; j ++ ){
                dp[i] = Math.max(dp[i],dp[i] + dp[j] ) ;
            }
            ans = Math.max( ans , dp[i] ) ;
        }
        return ans ;
    }
}
