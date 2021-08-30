package main.leetcode;

import java.util.Arrays;

public class MinimumDifference {

    public int minimumDifference(int[] nums , int k){
        if( k == 1 ){
            return 0 ;
        }
        else{
            Arrays.sort(nums) ;
            int ans = Integer.MAX_VALUE ;
            int n = nums.length ;
            for( int i = 0 ; i <= n - k; i ++ ){
                int nowMax = Integer.MIN_VALUE ;
                int nowMin = Integer.MAX_VALUE ;
                for( int j = i ; j < i + k ; j ++ ){
                    if( nums[j] < nowMin ){
                        nowMin = nums[j] ;
                    }
                    if( nums[j] > nowMax ){
                        nowMax = nums[j] ;
                    }
                }
                if( nowMax - nowMin < ans ){
                    System.out.println( nowMax + " " + nowMin );
                    ans = nowMax - nowMin ;
                }
            }
            return ans ;
        }

    }
}
