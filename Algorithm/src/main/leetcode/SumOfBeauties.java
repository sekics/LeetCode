package main.leetcode;

import java.util.Arrays;

public class SumOfBeauties {

    public int sumOfBeauties(int[] nums){
        int n = nums.length ;
        int[] maxs = new int[ n + 1 ] ;
        int[] minBack = new int[ n + 1 ] ;
        maxs[0] = 0 ;
        for( int i = 1 ; i <= n ; i ++ ){
            maxs[i] = Math.max( maxs[ i - 1 ] , nums[ i - 1 ] ) ;
        }
        minBack[ n ] = 1000001 ;
        for( int i = n - 1 ; i >= 0 ; i -- ){
            minBack[i] = Math.min( minBack[ i + 1 ] , nums[i] ) ;
        }
        int ans = 0 ;
        System.out.println(Arrays.toString(maxs));
        System.out.println(Arrays.toString(minBack));
        for( int i = 1 ; i < n - 1 ; i ++ ){
            if(  maxs[ i - 1 ] < nums[i] && nums[i] < minBack[i] ){
                ans += 2 ;
            }
            else if( nums[ i - 1 ] < nums[i] && nums[i] < nums[ i + 1 ] ){
                ans ++ ;
            }
        }
        return ans ;
    }
}
