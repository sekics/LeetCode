public class Change{

    //完全背包问题满包
    public int change(int amount,int[] coins){
        // int n = coins.length ;
        // int[][] dp = new int[ n + 1 ][ amount + 1 ] ;
        // for( int i = 1 ; i <= n ; i ++ ){
        //     for( int j = 1 ; j <= amount ; j ++ ){
        //         int max = 0 ;
        //         for( int k = 0 ; k <= j / coins[ i - 1 ] ; k ++ ){
        //             dp[i][j] = Math.max(max,dp[ i - 1 ][ j - k * coins[ i - 1 ] + k * coins[ i - 1 ] ) ;
        //         }
        //     }
        // }
        // return dp[n][amount];
        int n = coins.length ;
        int[][] dp = new int[ n + 1 ][ amount + 1 ] ;
        dp[0][0] = 1 ;
        for( int i = 1 ; i <= n ; i ++ ){
            for( int j = 0 ; j <= amount ; j ++ ){
                dp[i][j] = dp[ i - 1 ][ j  ] ;
                if( j >= coins[ i - 1 ] ){
                    dp[i][j] = dp[ i ][j] + dp[ i  ][ j -  coins[ i - 1 ]] ;
                }
            }
        }
        System.out.println(Arrays.deepToString(dp)) ;
        return dp[n][amount];
    }

    public int changeOpt(int amount,int[] coins){
        int n = coins.length ;
        int[] dp = new int[ amount + 1 ] ;
        dp[0] = 1 ;
        for( int i = 1 ; i <= n ; i ++ ){
            int coin = coins[ i - 1 ] ;
            for( int j = 0 ; j <= amount ; j ++ ){
                if( j >= coin ){
                    dp[j] += dp[ j - coin ] ;
                }
            }
        }
        return dp[amount] ;
    }
}