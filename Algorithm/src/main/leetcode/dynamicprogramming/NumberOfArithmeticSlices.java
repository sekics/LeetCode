package main.leetcode.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class NumberOfArithmeticSlices {

    public int numberOfArithmeticsSlices(int[] nums){
        int n = nums.length ;
        Map<Long,Integer>[] maps = new HashMap[n] ;
        for( int i = 0 ; i < n ; i ++ ){
            maps[i] = new HashMap<Long,Integer>() ;
        }
        int ans = 0 ;
        for( int i = 0 ; i < n ; i ++ ){
            for( int j = 0 ; j < i ; j ++ ){
                long diff = (long)nums[i] - (long)nums[j] ;
                int cnt = maps[j].getOrDefault(diff,0) ;
                ans += cnt ;
                maps[i].put(diff,maps[i].getOrDefault(diff,0) + cnt + 1 ) ;
            }
        }
        return ans ;
    }
}
