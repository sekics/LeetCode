package main.leetcode.binarysearch;

public class FindPeakElement {

    public int findPeakElement( int[] nums ){
        int n = nums.length ;
        if( n == 1 ){
            return 0 ;
        }
        int left = 0 , right = n - 1 ;
        int mid = ( left + right ) / 2 ;
        while( left <= right ){
            mid = ( left + right ) / 2 ;
            if( mid == 0 ){
                if( nums[mid] > nums[ mid + 1 ] ){
                    return mid ;
                }
                else if( nums[ mid ] < nums[ mid + 1 ] ){
                    left = mid + 1 ;
                }
            }
            else if( mid == n - 1 ){
                if( nums[ mid] > nums[ mid - 1 ] ){
                    return mid ;
                }
                else{
                    right = mid - 1 ;
                }
            }
            else{
                if( nums[ mid - 1 ] < nums[ mid ] && nums[ mid ] > nums[ mid + 1 ]  ){
                    return mid ;
                }
                else if( nums[ mid + 1 ] > nums[ mid] ){
                    left = mid + 1 ;
                }
                else{
                    right = mid - 1 ;
                }
            }
        }
        return left ;
    }
}
