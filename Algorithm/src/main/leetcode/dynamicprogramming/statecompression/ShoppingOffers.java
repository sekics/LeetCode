package main.leetcode.dynamicprogramming.statecompression;


import java.util.Arrays;
import java.util.List;

public class ShoppingOffers {

    public int shoppingOffers( List<Integer> price , List<List<Integer>> special , List<Integer> needs){
        int n = needs.size() ;
        int m = 1 << n ;
        int[] dp = new int[m] ;
        for( int i = 1 ; i < m ; i ++ ){
            int state = i , idx = 0 ;
            int cost = 0 ;
            while( state > 0 ){
                if( (state & 1) == 1 ){
                    cost = cost + price.get(idx) * needs.get(idx) ;
                }
                state = state >> 1 ;
                idx ++ ;
            }
            dp[i] = cost ;
        }
        System.out.println(Arrays.toString(dp));

        for( int i = 1 ; i < m ; i ++ ){

        }
        return 0 ;
    }
}
