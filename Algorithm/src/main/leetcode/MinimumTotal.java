package main.leetcode;

import java.util.List;

public class MinimumTotal {

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        dp[0][0] = triangle.get(0).get(0);
        // System.out.println(Arrays.toString(dp[0])) ;
        for (int i = 1; i < n; i++) {
            List<Integer> tmp = triangle.get(i);
            for (int j = 0; j < tmp.size(); j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + tmp.get(j);
                } else if (j == tmp.size() - 1) {
                    dp[i][j] = dp[i - 1][j - 1] + tmp.get(j);
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + tmp.get(j);
                }
            }
            // System.out.println(Arrays.toString(dp[i])) ;
        }
        int ans = Integer.MAX_VALUE ;
        for( int i = 0 ; i < n ; i ++ ){
            if( dp[ n - 1 ][i] < ans ){
                ans = dp[ n - 1 ][i] ;
            }
        }
        return ans ;
    }

    public int minimunTotalOptim(List<List<Integer>> triangle){
        int n = triangle.size() ;
        int[] dp = new int[n] ;
        dp[0] = triangle.get(0).get(0) ;
        for( int i = 1 ; i < n ; i ++ ){
            List<Integer> tmp = triangle.get(i) ;
            int m = tmp.size() ;
            for( int j = 0 ; j < m ; j ++ ){
                int val = tmp.get(j) ;
                if( j == 0 ){
                    dp[j] += val ;
                }
                else if( j == m - 1 ){
                    dp[j] = dp[ j - 1 ] + val ;
                }
                else{
                    dp[j] = Math.min( dp[j] , dp[ j - 1 ] ) + val ;
                }
            }
        }
        int ans = Integer.MAX_VALUE ;
        for( int i = 0 ; i < n ; i ++ ){
            ans = Math.min(ans,dp[i]) ;
        }
        return ans ;
    }
}
