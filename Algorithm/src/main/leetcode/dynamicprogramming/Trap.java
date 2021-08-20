package main.leetcode.dynamicprogramming;

import java.util.Arrays;

public class Trap {

    public int trap(int[] height){
        int n = height.length ;
        int[] left = new int[ n + 2 ] ;
        int[] right = new int[ n + 2 ] ;
        for( int i = 1 ; i <= n ; i ++ ){
            left[i] = Math.max( height[ i - 1 ] , left[ i - 1 ] ) ;
        }
        for( int i = n ; i >= 1 ; i -- ){
            right[i] = Math.max( height[ i - 1 ] , right[ i + 1 ] ) ;
        }
        int ans = 0 ;
        for( int i = 1 ; i < n - 1 ; i ++ ){
            int wall = Math.min( left[ i - 1 ] , right[ i + 1 ] ) ;
            ans = wall > height[i] ? wall - height[i] + ans : ans ;
        }
        System.out.println(Arrays.toString(left) ) ;
        System.out.println( Arrays.toString( right ) ) ;
        return ans ;
    }
}
