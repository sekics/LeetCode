package main.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestObstableCourseAtEachPosition {

    //超时dp
    public int[] longesObstacleCourseAtEachPosition(int[] obstacles){
        int n = obstacles.length ;
        int[] dp = new int[n] ;
        dp[0] = 1 ;
        for( int i = 1 ; i < n ; i ++ ){
            dp[i] = 1 ;
            for( int j = 0 ; j < i ; j ++ ){
                if( obstacles[j] <= obstacles[i] ){
                    dp[i] = Math.max(dp[i], dp[j] + 1 ) ;
                }
            }
        }
        return dp ;
    }

    public int getIndex(int[] cnt , int size , int target){
        int left = 1 , right = size ;
        int mid = ( left + right ) / 2 ;
        while( left <= right ){
            mid = ( left + right ) ;
            if( cnt[mid] == target ){
                return mid + 1 ;
            }
            else if( cnt[mid] < target ){
                left = mid + 1 ;
            }
            else{
                right = mid - 1 ;
            }
        }
        return left ;
    }
    public int[] longestObstacleCourseAtEachPosition(int[] obstacles){
        int n = obstacles.length ;
        int[] ans = new int[ n ] ;
        int[] cnt = new int[ n + 1 ] ;
        int nowLength = 1 ;
        cnt[nowLength] = ans[0] ;
        for( int i = 1 ; i < n ; i ++ ){
            if( obstacles[i] >= cnt[nowLength] ){
                nowLength ++ ;
                cnt[nowLength] = obstacles[i] ;
                ans[i] = nowLength ;
            }
            else {
                int index = getIndex(cnt,nowLength,obstacles[i])  - 1 ;
                ans[i] = index ;
                cnt[ index ] = Math.min( cnt[ index ] ,obstacles[i] ) ;
            }
        }
        return ans ;
    }
}
