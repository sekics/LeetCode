package main.leetcode.dynamicprogramming;

public class MaxProfit {

    public int maxProfit(int[] prices){
        int ans = 0 ;
        int hold = -prices[0] ;
        int n = prices.length ;
        for( int i = 1 ; i < n ; i ++ ){
            ans = Math.max( ans , hold + prices[i] ) ;
            hold = Math.min( hold , -prices[i] ) ;
        }
        return ans ;
    }

    public int maxProfitII( int[] prices ){
        int hold = -prices[0] , unhold = 0 ;
        int n = prices.length ;
        for( int i = 1 ; i < n ; i ++ ){
            unhold = Math.max( unhold , hold + prices[i] ) ;
            hold = Math.max( hold , unhold - prices[i] ) ;
        }
        return unhold ;
    }

    public int maxProfitCold( int[] prices ){
        int n = prices.length ;
        int[][] dp = new int[n][3] ;
        dp[0][0] = -prices[0] ;
        for( int i = 1 ; i < n ; i ++ ){
            dp[i][0] = Math.max( dp[ i - 1 ][0] , dp[ i - 1 ][2] - prices[i] ) ;
            //和自己比较保证至少不会亏
            dp[i][1] = Math.max( dp[ i - 1 ][1] , dp[ i - 1 ][0] + prices[i] ) ;
            dp[i][2] = dp[ i - 1 ][1] ;
        }
        return Math.max(dp[ n - 1 ][1] , dp[ n - 1 ][2] ) ;
    }

    public int maxProfitFee( int[] prices , int fee){
        int n = prices.length ;
        int hold = -prices[0] , unhold = 0 ;
        for( int i = 1 ; i < n ; i ++ ){
            //为什么可以不用先存下unhold值
            //因为如果unhold要么是原来的unhold的状态转移过来，要么是卖掉了
            //如果是unhold转移过来，unhold不变
            //如果是卖掉了，说明已经执行了一个买操作，那下一步的hold是不可能从unhold状态买的，因为同一天不能买卖。
            //卖掉的情况带入下面的式子  Math.max( hold , hold + prices[i] - fee - prices[i] )肯定是会更小的，所以两者不会同时发生
            unhold = Math.max( unhold , hold + prices[i] - fee ) ;
            hold = Math.max( hold , unhold - prices[i] ) ;
        }
        return unhold ;
    }
}
