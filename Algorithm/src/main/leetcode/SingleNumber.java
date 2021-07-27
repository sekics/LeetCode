package main.leetcode;

import java.util.HashMap;
import java.util.Map;

public class SingleNumber {

    public int singleNumber( int[] nums ){
        int n = nums.length ;
        for( int i = 1 ; i < n ; i ++ ){
            nums[i] = nums[ i - 1 ] ^ nums[i] ;
        }
        return nums[ n - 1 ] ;
    }

    public int singleNumber2( int[] nums ){
        Map<Integer,Integer> map = new HashMap<>() ;
        int n = nums.length ;
        for( int i = 0 ; i < n ; i ++ ){
            map.put(nums[i],map.getOrDefault(nums[i],0) + 1 ) ;
        }
        int value = 3 ;
        int ans = -1 ;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            value = entry.getValue() ;
            if( value == 1 ){
                ans = entry.getKey() ;
            }
        }
        return ans ;
    }
}
