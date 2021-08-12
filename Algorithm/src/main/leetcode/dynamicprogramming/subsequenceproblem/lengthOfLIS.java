package main.leetcode.dynamicprogramming.subsequenceproblem;

import java.util.Arrays;

public class lengthOfLIS {

    public int lengthOfLIS(int[] nums ){
        int n = nums.length ;
//        int[][] dp = new int[n][n] ;
//        for( int i = 0 ; i < n ; i ++ ){
//            dp[i][i] = 1 ;
//        }
//        for( int i = 0 ; i < n ; i ++ ){
//            Arrays.fill(dp[i],1);
//        }
        int[] dp = new int[n] ;
        int ans = 0 ;
        for( int i = 0 ; i < n ; i ++ ){
            for( int j = 0 ; j < i ;j ++ ){
                if( nums[j] < nums[i] ){
                    dp[i] = Math.max( dp[i] , dp[j] + 1 ) ;
                }
            }
            ans = Math.max(ans,dp[i]) ;
        }
        return ans ;
    }
}
