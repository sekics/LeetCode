package main.leetcode;

import java.util.*;

public class NumberOfWeakCharacters {

    public int numberOfWeakCharacters(int[][] properties) {
        int n = properties.length ;
        Arrays.sort( properties , ( int[] a , int[] b ) -> {
            if( a[0] != b[0] ){
                return a[0] - b[0] ;
            }
            else{
                return a[1] - b[1] ;
            }
        }) ;
        int[] right = new int[ n + 1 ] ;
        for( int i = n - 1 ; i > 0 ; i -- ){
            right[i] = Math.max( right[ i + 1 ] , properties[i][1] ) ;
        }
        int ans = 0 ;
        for( int i = 0 ; i < n ; i ++ ){
            int l = 0 , r = n - 1 ;
            while( l <= r ){
                int mid = ( l + r ) / 2 ;
                if( properties[mid][0] <= properties[i][0] ){
                    l = mid + 1 ;
                }
                else{
                    r = mid - 1 ;
                }
            }
            if( right[l] > properties[i][1] ){
                ans ++ ;
            }
        }
        return ans ;
    }

}
