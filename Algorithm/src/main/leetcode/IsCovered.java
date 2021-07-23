package main.leetcode;

import java.util.Arrays;

public class IsCovered {

    public boolean isCovered( int[][] ranges , int left , int right ){
        Arrays.sort(ranges,(int[] a,int[] b) -> {
            return a[0] - b[0] ;
        }) ;
        int n = ranges.length ;
        int toCover = left ;
        int i = 0 ;
        while( i < n && toCover <= right ){
            if( ranges[i][0] <= toCover && ranges[i][1] >= toCover ){
                toCover = ranges[i][1] + 1 ;
            }
            i ++ ;
        }
        if( toCover > right ){
            return true ;
        }
        else{
            return false ;
        }
    }
}
