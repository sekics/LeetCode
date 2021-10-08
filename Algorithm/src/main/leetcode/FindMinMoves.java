package main.leetcode;

import java.util.Arrays;

public class FindMinMoves {

    public int findMinMoves(int[] machines){
        int n = machines.length ;
        int move = 0 ;
        int total = 0 ;
        for( int machine : machines ){
            total += machine ;
        }
        int avg = 0 ;
        if( total % n != 0 ){
            return - 1 ;
        }
        else{
            avg = total / n ;
        }
        int sum = 0 ;
        for( int machine : machines ){
            sum += ( machine - avg ) ;
            move = Math.max( move , Math.max( Math.abs( sum ) , machine - avg ) ) ;
        }
        return move ;
    }
}
