package main.leetcode;

public class MaxSubArray {

    public int maxSunArray(int[] nums){
        int n = nums.length ;
        int max , now ;
        max = now = -101 ;
        for( int i = 0 ; i < n ; i ++ ){
            if( now < 0 ){
                now = nums[i] ;
            }
            else{
                now = now + nums[i] ;
            }
            if( now > max ){
                max = now ;
            }
        }
        return max ;
    }
}
