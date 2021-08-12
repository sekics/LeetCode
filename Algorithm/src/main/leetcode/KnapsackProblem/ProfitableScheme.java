public class ProfitableScheme{

    public profitableScheme(int n,int minProfit,int[] group,int[] profit){
        int n_ = n ;
        int totalProfit = 0 ;
        int[] profits = new int[ n + 1 ] ;
        for( int i = 1 ; i <= n ; i ++ ){
            totalProfit += profit[ i - 1 ] ;
            profits[i] = profits[ i - 1 ] + profit[ i - 1 ] ;
        }
        //cnt[i][j]表示从0，1...i个盈利任务时，获得的利润为j时的计数
        int[][] cnt = new int[ n + 1 ][ totalProfit + 1 ] ;
        //剩余员工计数
        int[][] stuff = new int[ n + 1 ][ totalProfit + 1 ] ;
        for( int i = 0 ; i <= n ; i ++ ){
            for( int j = 0 ; j <= totalProfit ; j ++ ){
                stuff[i][j] = n ;
            }
        }
        for( int i = 1 ; i <= n ; i ++ ){
            for( int j = 0 ; j <= profits[i] ; j ++ ){
                //当利润为j时不选i
                cnt[i][j] = cnt[ i - 1 ][j] ;
                if( stuff[ i -  1 ][j] > group[ i - 1 ] && j > profit[ i - 1 ]){
                    //选i
                    stuff[i][j] = stuff[ i - 1 ][j] - group[ i - 1 ] ;
                    cnt[i][j] += 1 ;
                }
            }
        }
    }

    public profitableScheme3D(int n,int minProfit,int[] group,int[] profit){
        int n_ = group.length ;
        int MOD = (int)1e9 + 7 ;
        int[][][] dp = new int[ n_ + 1 ][ n + 1 ][ minProfit + 1 ] ;
        dp[0][0][0] = 1 ;
        for( int i = 1 ; i <= n_ ; i ++ ){
            for( int j = 0 ; j <= n ; j ++ ){
                for( int k = 0 ; k <= minProfit ; k ++ ){
                    if( j < group[ i - 1 ] ){
                        dp[i][j][k] = dp[ i - 1 ][j][k] ;
                    }
                    else{
                        dp[i][j][k] = ( dp[ i - 1 ][j][k] + dp[ i - 1 ][ j - group[ i - 1 ]][Math.max(0,k - profit[ i - 1 ])]) % MOD;
                    }
                    if( k == 0 ){
                        System.out.println(dp[i][j][k]);
                    }
                }
            }
        }
        int sum = 0 ;
        for( int j = 0 ; j <= n ; j ++ ){
            sum += dp[n_][j][minProfit] ;
        }
        return sum ;
    }
}