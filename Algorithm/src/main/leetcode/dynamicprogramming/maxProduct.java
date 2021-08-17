package main.leetcode.dynamicprogramming;

public class maxProduct {

    //此方法对值大于零才行
    public int maxProduct(int[] nums){
        int n = nums.length ;
        int[] dp = new int[n] ;
        int ans = dp[0] = nums[0] ;

        for( int i = 1 ; i < n ; i ++ ){
            dp[i] = Math.max( dp[ i - 1 ] * nums[i] , nums[i] ) ;
            ans = Math.max( ans , dp[i] ) ;
        }
        return ans ;
    }

    public int maxProdictTwo(int[] nums){
        int n = nums.length ;
        int[][] dp = new int[n][n] ;
        int ans = nums[0] ;
        for( int i = 0 ; i < n ; i ++ ){
            dp[i][i] = nums[i] ;
        }

        for( int i = n - 1 ; i >= 0 ; i -- ){
            for( int j = i + 1 ; j < n ; j ++ ){
                dp[i][j] = dp[i][ j - 1 ] * nums[j] ;
                ans = Math.max( ans , dp[i][j] ) ;
            }
        }
        return ans ;
    }

    public int maxProductOptim(int[] nums){
        int n = nums.length ;
        int[] dp = new int[n] ;
        int ans = nums[0] ;
        for( int i = n - 1 ; i >= 0 ; i -- ){
            dp[i] = nums[i] ;
            for( int j = i + 1 ; j < n ; j ++ ){
                dp[j] = dp[ j - 1 ] * nums[j] ;
                ans = Math.max( ans,dp[j] ) ;
            }
        }
        return ans ;
    }

    public int maxProductOptimTime( int[] nums ){
        int n = nums.length ;
        int[] minProduct = new int[n] ;
        int[] maxProduct = new int[n] ;
        minProduct[0] = maxProduct[0] = nums[0] ;
        for( int i = 1 ; i < n ; i ++ ){
            // 第一个数是前面乘积为正，nums[i]也为正，nums[i]的情况是前面为负（minProduct和maxProduct都为负），而当前为正，第三种情况为负负
            maxProduct[i] = Math.max( maxProduct[ i - 1 ] * nums[i] , Math.max( nums[i] , minProduct[ i - 1 ] * nums[i])) ;
            minProduct[i] = Math.min( minProduct[ i - 1 ] * nums[i] , Math.min( nums[i] , maxProduct[ i - 1 ] * nums[i])) ;
        }
        int ans = maxProduct[0] ;
        for( int i = 1 ; i < n ; i ++ ){
            ans = Math.max( ans , maxProduct[i] ) ;
        }
        return ans ;
    }
}
