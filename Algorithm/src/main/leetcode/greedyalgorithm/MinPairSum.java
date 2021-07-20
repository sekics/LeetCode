package main.leetcode.greedyalgorithm;

import java.util.Arrays;

public class MinPairSum {

    public int minPairSum( int[] nums ){
        int n = nums.length ;
        int max = 0 ;
        Arrays.sort(nums) ;
        for( int i = 0 ; i < n / 2 ; i ++ ){

            if( nums[i] + nums[ n - i - 1 ] > max ){
                max = nums[i] + nums[ n - i - 1 ] ;
            }
        }
        return max ;
    }
}
