package main.leetcode;

public class CountQuadruplets {

    public int countQuadruaplets( int[] nums ){
        int n = nums.length ;
        int ans = 0 ;
        for( int i = 0 ; i < n ; i ++ ){
            for( int j = i + 1 ; j < n ; j ++ ){
                for( int m = j + 1 ; m < n ; m ++ ){
                    for( int k = m + 1 ; k < n ; k ++ ){
                        if( ( nums[i] + nums[j] + nums[m] ) == nums[k] ){
                            ans ++ ;
                        }
                    }
                }
            }
        }
        return ans ;
    }
}
