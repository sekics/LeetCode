package main.leetcode;

import java.util.Arrays;

public class RearrangeArray {

    public int[] rearrangeArray(int[] nums){
        Arrays.sort(nums) ;
        int n = nums.length ;
        int left = 0 , right = n - 1 ;
        int i = 0 ;
        int flag = 0 ;
        int[] ans = new int[n] ;
        while( left <= right ){
            if( flag % 2 == 0 ){
                int j = 0 ;
                while( left < right ){
                    if( j % 2 == 0 ){
                        ans[ i ++ ] = nums[ right -- ] ;
                    }
                    else{
                        ans[ i ++ ] = nums[ left ++ ] ;
                    }
                    j ++ ;
                }
            }
            else{
                int j = 0 ;
                while( left < right ){
                    if( j % 2 == 1 ){
                        ans[ i ++ ] = nums[ right -- ] ;
                    }
                    else{
                        ans[ i ++ ] = nums[ left ++ ] ;
                    }
                    j ++ ;
                }
            }
        }
        return ans ;
    }
}
