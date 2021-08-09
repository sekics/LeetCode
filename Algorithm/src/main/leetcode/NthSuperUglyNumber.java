package main.leetcode;

import java.util.*;

public class NthSuperUglyNumber {

    public int nthSuperUglyNumber( int n , int[] primes ){
        int m = primes.length ;
        int[] pointers = new int[m] ;
        Arrays.fill(pointers,1);
        int[] nums = new int[m] ;
        int[] ans = new int[ n + 1 ] ;
        ans[1] = 1 ;
        for( int i = 2 ; i < n ; i ++ ){
            int minNum = Integer.MAX_VALUE ;
            for( int j = 0 ; j < m ; j ++ ){
                nums[j] = ans[pointers[i]] * primes[i] ;
                minNum = Math.min( minNum , nums[j] ) ;
            }
            for( int j = 0 ; j < m ; j ++ ){
                if( minNum == nums[j] ){
                    pointers[j] ++ ;
                }
            }
            ans[i] = minNum ;
        }
        return ans[n] ;
    }
}
