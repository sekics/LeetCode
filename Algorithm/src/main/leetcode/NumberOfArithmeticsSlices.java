package main.leetcode;

public class NumberOfArithmeticsSlices {

    public int numberOfArithmeticsSlices(int[] nums){
        int[] table = new int[5001] ;
        int s = 1 ;
        for( int i = 3 ; i < 5001 ; i ++ ){
            table[i] = table[ i - 1 ] + ( s++ ) ;
        }
        int preDiff = nums[1] - nums[0] ;
        int n = nums.length ;
        int i = 1 ;
        int ans = 0 ;
        while( i < n - 1 ){
            int j = i + 1 ;
            while( nums[j] - nums[ j - 1 ] == preDiff ){
                j ++ ;
            }
            if( j - i + 1 >= 3 ){
                ans += table[ j - i + 1 ] ;
            }
            if( j < n ){
                preDiff = nums[j] - nums[ j - 1 ] ;
            }
            i = j ;
        }
        return ans ;
    }

    public int numberOfArithmeticsSlicesDP(int[] nums){
        int n = nums.length ;
        if( n < 3 ){
            return 0 ;
        }
        int ans = 0 ;
//        int[] dp = new int[n] ;
        int dp = 0 ;
        for( int i = 2 ; i < n ; i ++ ){
            if( nums[ i ] - nums[ i - 1 ] == nums[ i - 1 ] - nums[ i - 2 ] ){
                dp ++ ;
            }
            else{
                dp = 0 ;
            }
            ans += dp ;
        }
        return ans ;
    }
}
