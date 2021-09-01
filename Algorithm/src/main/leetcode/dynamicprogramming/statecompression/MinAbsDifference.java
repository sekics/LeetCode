package main.leetcode.dynamicprogramming.statecompression;

import java.util.Arrays;

public class MinAbsDifference {

    public int getSum( int state , int[] nums ){
        int idx = 0 , sum = 0 ;
        while( state > 0 ){
            if( (state & 1) == 1 ){
                sum += nums[idx] ;
            }
            idx ++ ;
            state = state >> 1 ;
        }
        return sum ;
    }

    public int minAbsDifference(int[] nums, int goal) {
        int n = nums.length ;
        int part1L = n / 2 , part2L = n % 2 == 0 ? n / 2 : n / 2 + 1 ;
        int[] nums1 = new int[ part1L ] ;
        int[] nums2 = new int[ part2L ] ;
        int i = 0 ;
        for(  ; i < part1L ; i ++ ){
            nums1[i] = nums[i] ;
        }
        for( i = 0 ; i < part2L ; i ++ ){
            nums2[i] = nums[ i + part1L ] ;
        }
        int[] dp1 = new int[ 1 << part1L ] ;
        int[] dp2 = new int[ 1 << part2L ] ;
        for( i = 1 ; i < 1 << part1L ; i ++ ){
            dp1[i] = getSum( i , nums1 ) ;
        }
        for( i = 1 ; i < 1 << part2L ; i ++ ){
            dp2[i] = getSum( i , nums2 ) ;
        }
        int[] subsets1 = dp1;
        int[] subsets2 = dp2;
        Arrays.sort( subsets1 ) ;
        // System.out.println( Arrays.toString( subsets1 ));
        // System.out.println( Arrays.toString( subsets2 ));
        int ans = Integer.MAX_VALUE ;
        for( i = 0 ; i < subsets2.length ; i ++ ){
            int find = goal - subsets2[i] ;
            int left = 0 , right =  ( 1 << part1L ) - 1 ;
            while( left <= right ){
                int mid = ( left + right ) / 2 ;
                // if( i == 4 ){
                //     System.out.println( "test " + left + " " + mid + "  " + right ) ;
                // }
                if( subsets1[mid] == find ){
                    return 0 ;
                }
                else if( subsets1[mid] > find ){
                    right = mid - 1 ;
                }
                else{
                    left = mid + 1 ;
                }
            }
            if( left >= subsets1.length ){
                ans = Math.min( ans , Math.abs( find - subsets1[ left - 1 ] ) ) ;
            }
            else if( left <= 0 ){
                ans = Math.min( ans , Math.abs( find - subsets1[ 0 ] ) ) ;
            }
            else{
                ans = Math.min( ans , Math.min( Math.abs( find - subsets1[ left ] ), Math.abs(find - subsets1[ left - 1 ]) ) ) ;
            }
        }
        return ans ;
    }
}
