package main.leetcode;

public class FindGCD {

    public int findGCD( int[] nums ){
        int n = nums.length ;
        int min = Integer.MAX_VALUE ;
        int max = Integer.MIN_VALUE ;
        for( int i = 0 ; i < n ; i ++ ){
            min = Math.min( min , nums[i] ) ;
            max = Math.max( max , nums[i] ) ;
        }
        int gcd = max ;
        while( min % gcd != 0 || max % gcd != 0 ){
            gcd -- ;
        }
        return gcd ;
    }
}
