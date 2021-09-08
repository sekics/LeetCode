package main.leetcode.binarysearch;

public class Search {

    public int search(int[] nums, int target) {
        int n = nums.length ;
        int left = 0 , right = n - 1 ;
        int mid = ( left + right ) / 2 ;
        while( left <= right ){
            mid = ( left + right ) / 2 ;
            if( nums[mid] == target ){
                return mid ;
            }
            else if( nums[mid] < target ){
                left = mid + 1 ;
            }
            else{
                right = mid - 1 ;
            }
        }
        return -1 ;
    }

}