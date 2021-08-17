package main.leetcode.dynamicprogramming;

import java.util.Arrays;

public class GetMaxLength {

    public int getMaxLength(int[] nums){
        int n = nums.length ;
        int[] posDp = new int[n] ;
        int[] negDp = new int[n] ;
        int[] cnt = new int[n] ;
        posDp[0] = negDp[0] = nums[0] ;
        cnt[0] = posDp[0] > 0 ? 1 : 0 ;
        int ans = cnt[0] ;
        for( int i = 1 ; i < n ; i ++ ){
            posDp[i] = Math.max( posDp[ i - 1 ] * nums[i] , Math.max( nums[i] , nums[i] * negDp[ i - 1 ])) ;
            negDp[i] = Math.min( posDp[ i - 1 ] * nums[i] , Math.min( nums[i] , nums[i] * posDp[ i - 1 ])) ;
            if( posDp[i] > 0 ){
//                if( posDp[i] == nums[i] ){
//                    cnt[i] = 1 ;
//                }
//                else
                if( nums[i] > 0 ){
                    cnt[i] = posDp[ i - 1 ] > 0 ? cnt[ i - 1 ] + 1 : 1 ;
                }
                else if( nums[i] == 0 ){
                    cnt[i] = 0 ;
                }
                else{
                    cnt[i] = negDp[ i - 1 ] < 0 ? cnt[ i - 2 ] + 2 : 1 ;
                }

//                if( posDp[ i - 1 ] > 0 ){
//                    if( posDp[i] == posDp[ i - 1 ] * nums[i] ){
//                        cnt[i] = cnt[ i - 1 ] + 1 ;
//                    }
//                    if( posDp[i] == nums[i] && posDp[ i - 1 ] != 1 ){
//                        cnt[i] = 1 ;
//                    }
//                }
//                else{
//                    if( posDp[i] == negDp[ i - 1 ] * nums[i] ){
//                        cnt[i] = cnt[ i - 2 ] + 2 ;
//                    }
//                }
            }
        }
        System.out.println(Arrays.toString(cnt)) ;
        return ans ;
    }

    public int getMaxLength1(int[] nums){
        int n = nums.length ;
        int[] posDp = new int[ n + 1 ] ;
        int[] negDp = new int[ n + 1 ] ;
        int[] cnt = new int[ n + 1] ;
        if( nums[0] == 0 ){
            posDp[1] = negDp[1] = 0 ;
        }
        else{
            posDp[1] = negDp[1] = nums[0] > 0 ? 1 : -1 ;
        }
        cnt[1] = posDp[1] > 0 ? 1 : 0 ;
        int ans = cnt[1] ;
        for( int i = 2 ; i <= n ; i ++ ){
            if( posDp[ i - 1 ] * nums[ i - 1 ] > 0 || nums[ i - 1 ] > 0 || nums[ i - 1 ] * negDp[ i - 1 ] > 0 ){
                posDp[ i ] = 1 ;
            }
            else{
                posDp[ i ] = -1 ;
            }
            if( negDp[ i ] * nums[ i - 1 ] < 0 || nums[ i - 1 ] < 0  ){
                negDp[i] = -1 ;
            }
            else{
                negDp[i] = 1 ;
            }
            // System.out.println(posDp[i]) ;
            if( posDp[i] > 0 ){
                if( nums[ i - 1 ] > 0 ){
                    cnt[i] = posDp[ i - 1 ] > 0 ? cnt[ i - 1 ] + 1 : 1 ;
                }
                else if( nums[ i - 1 ] == 0 ){
                    cnt[i] = 0 ;
                }
                else{
                    cnt[i] = negDp[ i - 1 ] < 0 ? cnt[ i - 2 ] + 2 : 1 ;
                }
            }
            ans = Math.max( ans , cnt[i] ) ;
        }
        System.out.println(Arrays.toString(posDp)) ;
        System.out.println(Arrays.toString(negDp)) ;
        System.out.println(Arrays.toString(cnt)) ;
        return ans ;
    }

    public int getMaxLength2(int[] nums){
        int n = nums.length ;
        int[] pos = new int[n] ;
        int[] neg = new int[n] ;
        if( nums[0] > 0 ){
            pos[0] = 1 ;
        }
        if( nums[0] < 0 ){
            neg[0] = 1 ;
        }
        int ans = pos[0] ;
        for( int i = 1 ; i < n ; i ++ ){
            if( nums[i] > 0 ){
                pos[i] = pos[ i - 1 ] + 1 ;
                neg[i] = neg[ i - 1 ] > 0 ? neg[ i - 1 ] + 1 : 0 ;
            }
            else if( nums[i] < 0 ){
                pos[i] = neg[ i - 1 ] > 0 ? neg[ i - 1 ] + 1 : 0 ;
                neg[i] = pos[ i - 1 ] + 1 ;
            }
            else{
                neg[i] = pos[i] = 0 ;
            }
            ans = Math.max( ans , pos[i] ) ;
        }
        return ans ;
    }
}
