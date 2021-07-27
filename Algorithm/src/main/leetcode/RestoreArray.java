package main.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class RestoreArray {

    public int[] restoreArray(int[][] adjacentPairs){
        int n = adjacentPairs.length ;
        Map<Integer,Integer> next = new HashMap<>() ;
        Set<Integer> set = new HashSet<>() ;
        for( int i = 0 ; i < n ; i ++ ){
            int first = adjacentPairs[i][0] ;
            int sec = adjacentPairs[i][1] ;
            //寻找只出现了一次的元素，标记开头和结尾 ；
            if( set.contains(first) ){
                set.remove(first) ;
            }
            else{
                set.add(first) ;
            }
            if( set.contains(sec) ){
                set.add(sec) ;
            }
            else{
                set.remove(set) ;
            }
            if( next.containsKey(first) ){
                next.put(sec,first) ;
            }
            else{
                next.put(first,sec) ;
            }
        }
        int start = 0 ;
        for( int end : set ){
            start = end ;
        }
        n = n + 1 ;
        int[] ans = new int[ n ] ;
        ans[0] = start ;
        for( int i = 1 ; i < n ; i ++ ){
            start = next.get(start) ;
            ans[i] = start ;
        }
        return ans ;
    }
}
