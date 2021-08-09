package main.leetcode;

public class lengthOfLIS {

    public int getIndex( int nowLength , int[] record , int target ){
        int left = 1 , right = nowLength ;
        int mid = ( left + right ) / 2 ;
        while( left <= right ){
            mid = ( left + right ) / 2 ;
            if( record[mid] < target ){
                left = mid + 1 ;
            }
            else{
                right = mid - 1 ;
            }
        }
        return left ;
    }

    public int lengthOfLIS(int[] nums) {
        int n = nums.length ;
        int[] record = new int[ n + 1 ] ;
        int nowLength = 1 ;
        record[nowLength] = nums[0] ;
        for( int i = 1 ; i < n ; i ++ ){
            if( nums[i] > record[nowLength] ){
                nowLength ++ ;
                record[ nowLength ] = nums[i] ;
            }
            else{
                int index = getIndex(nowLength,record,nums[i]) ;
                // System.out.println(index) ;
                record[index] = Math.min(record[index],nums[i]) ;
            }
            // System.out.println(Arrays.toString(record)) ;
        }
        return nowLength ;
    }
}
