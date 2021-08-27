package main.leetcode;

import java.util.Arrays;

public class NumRescueBoats {

    public int numRescueBoats( int[] people , int limit ){
        Arrays.sort( people ) ;
        int n = people.length ;
        int left = 0 , right = n - 1 , ans = 0 ;
        while( left <= right ){
            if( people[left] + people[right] > limit ){
                right -- ;
                ans ++ ;
            }
            else if( people[left] + people[right] <= limit ){
                left ++ ;
                right -- ;
                ans ++ ;
            }
        }
        return ans ;
    }
}
