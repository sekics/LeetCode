package main.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TriangleNumber {

    public int getIndex(int[] nums,int left , int mid , int right){
        int bleft = mid + 1 , bright = right ;
        int bmid = ( bleft + bright ) / 2 ;
        while( bleft <= bright ){
            bmid = ( bleft + bright ) / 2 ;
            if( nums[left] + nums[mid] > nums[bmid] ){
                bleft = bmid + 1 ;
            }
            else{
                bright = bmid - 1 ;
            }
        }
        return bleft - 1 ;
    }

    public int triangleNumber(int[] nums) {
        Arrays.sort( nums ) ;
        int n = nums.length ;
        int ans = 0 ;
        for( int i = 0 ; i < n - 2 ; i ++ ){
            for( int j = i + 1 ; j < n - 1 ; j ++ ){
                int left = i , mid = j , right = n - 1 ;
                right = getIndex(nums,i,j,right) ;
                int now = right - mid <= 0 ? 0 : right - mid ;
                ans += now ;
            }
        }
        return ans ;
    }
}
