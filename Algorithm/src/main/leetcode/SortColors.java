package main.leetcode;

public class SortColors {
    public void sortColors(int[] nums){
        int[] cnt = new int[3] ;
        int n = nums.length ;
        for( int i = 0 ; i < n ; i ++ ){
            cnt[ nums[i] ] ++ ;
        }
        int index = 0 ;
        for( int i = 0 ; i < 3 ; i ++ ){
            int j = 0 ;
            while( j < cnt[i] ){
                nums[ index ++ ] = i ;
                j ++ ;
            }
        }
    }
}
