package main.leetcode.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UglyNumber {

    public int uglyNumberII( int n ){
        List<Integer> uglyNumbers = new ArrayList<>() ;
        uglyNumbers.add(1) ;
        int[] table = new int[3] ;
        int[] base = { 2 , 3 , 5 } ;
        Arrays.fill(table,1) ;
        while( uglyNumbers.size() < n ){
            int min = Integer.MAX_VALUE ;
            int minIndex = -1 ;
            for( int i = 0 ; i < 3 ; i ++ ){

                if( table[i] * base[i] < min ){
                    min = table[i] * base[i] ;
                    minIndex = i ;
                }
            }
            table[ minIndex ] ++ ;
            uglyNumbers.add( min ) ;
        }
        return uglyNumbers.get( n - 1 ) ;
    }
}
