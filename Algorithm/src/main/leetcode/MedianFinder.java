package main.leetcode;

import java.util.ArrayList;
import java.util.List;

public class MedianFinder {

    private List<Integer> nums ;

    public MedianFinder(){
        nums = new ArrayList<>() ;
    }

    public void addNum( int num ){
        int left = 0 , right = this.nums.size() - 1 ;
        // System.out.println( this.nums.toString() ) ;
        int mid = ( left + right ) / 2 ;
        while( left <= right ){
            mid = ( left + right ) / 2 ;
            int midNum = this.nums.get(mid) ;
            if( midNum == num ){
                this.nums.add( mid , num ) ;
                return ;
            }
            else if( midNum > num ){
                right = mid - 1 ;
            }
            else{
                left = mid + 1 ;
            }
        }
        this.nums.add( left , num ) ;
        return ;
    }

    public double findMedian(){
        int n = this.nums.size() ;
        if( n % 2 == 1 ){
            return  ( double ) this.nums.get( n / 2 ) ;
        }
        else{
            return ( double ) ( this.nums.get( n / 2 ) + this.nums.get( n / 2 - 1 ) ) / 2 ;
        }
    }
}
