package main.leetcode.dynamicprogramming.subsequenceproblem;

import java.util.Arrays;

public class FindLengthOfLCIS {

    public int findLenghtOfLCIS(int[] nums){
        int n = nums.length ;
        int[][] dp = new int[n][n] ;
        for( int i = 0 ; i < n ; i ++ ){
            dp[i][i] = 1 ;
        }
        int ans = 0 ;
        for( int i = 0 ; i < n ; i ++ ){
            for( int j = i + 1  ; j < n ; j ++ ){
                if( nums[j] > nums[i] ){
                    dp[i][j] = dp[i][ j - 1 ] + 1 ;
                }
                else{
                    dp[i][j] = 1 ;
                }
                ans = Math.max(ans,dp[i][j]) ;
            }
        }
        return ans ;
    }

    public int findLengthOfLCISOptim(int[] nums){
        int n = nums.length ;
        int[] dp = new int[n] ;
        Arrays.fill(dp,1);
        int ans = 1 ;
        for( int i = 1 ; i < n ; i ++ ){
            if( nums[i] > nums[ i - 1 ] ){
                dp[i] = dp[ i - 1 ] + 1 ;
            }
            ans = Math.max(ans,dp[i]) ;
        }
        return ans ;
    }
}
