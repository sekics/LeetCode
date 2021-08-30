package main.leetcode.dynamicprogramming.statecompression;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumberWays {

    public int numberWays(List<List<Integer>> hats){
        int MOD = 1000000007 ;
        int n = hats.size() ;
        int m = 1 << n ;
        int maxHat = 0 ;
        for (List<Integer> hat : hats) {
            for (Integer item: hat) {
                maxHat = Math.max( maxHat , item ) ;
            }
        }
        Map< Integer , List<Integer>> map = new HashMap<>() ;
        for( int i = 0 ; i < n ; i ++ ){
            List<Integer> temp = hats.get(i) ;
            for (Integer hat : temp) {
                if( map.get(hat) == null ){
                    map.put( hat , new ArrayList<>() ) ;
                }
                map.get(hat).add( i ) ;
            }
        }
        System.out.println( map.toString() ) ;
        int[][] dp = new int[ maxHat + 1 ][ m ] ;
        dp[0][0] = 1 ;
        for( int i = 1 ; i <= maxHat ; i ++ ){
            for( int j = 0 ; j < m ; j ++ ){
                dp[i][j] = dp[ i - 1 ][j] ;
                List<Integer> likes = map.get(i) ;
                for (Integer like : likes) {
                    if( (j >> like & 1) != 1 ){
                        continue ;
                    }
                    dp[i][j] = dp[i][j] + dp[ i - 1 ][  j & ( ~( 1 << like ) ) ] ;
                    dp[i][j] %= MOD ;
                }
            }
        }
        return dp[maxHat][ m - 1 ] ;
    }

    public int numberWaysOptim(List<List<Integer>> hats){
        int MOD = 1000000007 ;
        int n = hats.size() ;
        int maxHat = 0 ;
        int m = 1 << n ;
        for (List<Integer> hat : hats) {
            for (Integer item : hat) {
                maxHat = Math.max( maxHat , item ) ;
            }
        }
        Map<Integer , List<Integer> > map = new HashMap<>() ;
        for( int i = 0 ; i < n ; i ++ ){
            List<Integer> temp = hats.get(i) ;
            for (Integer hat : temp) {
                if( map.get( hat ) == null ){
                    map.put( hat , new ArrayList<>() ) ;
                }
                map.get(hat).add( i ) ;
            }
        }
        int[] dp = new int[m] ;
        dp[0] = 1 ;
        for( int i = 1 ; i <= maxHat ; i ++ ){
            for( int j = 0 ; j < m ; j ++ ){
                List<Integer> likes = map.get( i ) ;
                if( likes == null ){
                    continue ;
                }
                for (Integer like : likes) {
                    dp[j] = dp[j] + dp[ j & ( ~ ( 1 << like ) ) ] ;
                    dp[j] %= MOD ;
                }
            }
        }
        return dp[ m - 1 ] ;
    }
}
