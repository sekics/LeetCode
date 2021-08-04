package main.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindUnsortedSubarray {

    public int findUnsortedSubarray(int[] nums){
        int[] numsCopy = nums.clone() ;
        Arrays.sort(numsCopy);
        int n = nums.length ;
        int left = 0 ;
        while( left < n && numsCopy[left] == nums[left] ){
            left ++ ;
        }
        if( left == n ){
            return 0 ;
        }
        int right = n - 1 ;
        while( right >= 0 && numsCopy[right] == nums[right] ){
            right -- ;
        }
        return right - left + 1 ;
    }

    public int findUnsortedSubarray2( int[] nums ){
        int n = nums.length ;
        int[] cnt = new int[n] ;
        for( int i = 1 ; i < n ; i ++ ){
            if( nums[i] < nums[ i - 1 ] ){
                cnt[ i ] = cnt[ i - 1 ] + 1 ;
            }
            else{
                cnt[i] = cnt[ i - 1 ] ;
            }
        }
        int left = 1 ;
        while( left < n && cnt[left] == cnt[ left - 1 ] ){
            left ++ ;
        }
        if( left == n ){
            return 0 ;
        }
        int right = n - 1 ;
        while( right > 0 && cnt[right] == cnt[ right - 1 ] ){
            right -- ;
        }
        return right - left + 1 ;
    }
}
