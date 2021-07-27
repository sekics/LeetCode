package main.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MinOperations {

    //wrong
    public int minOperations(int[] target,int[] arr){
        Map<Integer,Integer> position = new HashMap<>() ;
        Set<Integer> table = new HashSet<>() ;
        int n = target.length ;
        for( int i = 0 ; i < n ; i ++ ){
            position.put(target[i],i) ;
            table.add(target[i]) ;
        }
        int m = arr.length ;
        int[] cnt = new int[m] ;
        int nextIndex = -1 ;
        int max = 0 ;
        for( int i = 0 ; i < m ; i ++ ){
            if( table.contains(arr[i]) ){
                if( nextIndex == position.get(arr[i])){
                    cnt[i] = cnt[ i - 1 ] + 1 ;
                    nextIndex = position.get(arr[i]) + 1 ;
                }
                else{
                    cnt[i] = 1 ;
                    nextIndex = position.get(arr[i]) + 1 ;
                }
            }
            else{
                if( i == 0 ){
                    cnt[i] = 0 ;
                }
                else{
                    cnt[ i ] = cnt[ i - 1 ] ;
                }
            }
            if( cnt[i] > max ){
                max = cnt[i] ;
            }
        }
        return arr.length - max > 0 ? arr.length - max : 0 ;
    }

    //超出时间限制
    public int minOperationss(int[] target,int[] arr){
        int n = target.length ;
        int m = arr.length ;
        Map<Integer,Integer> map = new HashMap<>() ;
        Set<Integer> con = new HashSet<>() ;
        for( int i = 0 ; i < n ; i ++ ){
            map.put(target[i],i) ;
            con.add(target[i]) ;
        }
        int[] cnt = new int[m] ;
        int[] maxes = new int[n] ;
        int max = 0 ;
        int cntMax = 0 ;
        for( int i = 0 ; i < m ; i ++ ){
            if( con.contains( arr[i] ) ){
                int index = map.get( arr[i] ) ;
                if( index == 0 ){
                    maxes[ index ] = 1;
                }
                else{
                    int j = index - 1 ;
                    int tmp = 0 ;
                    while( j >= 0 ){
                        if( maxes[j] > tmp ){
                            tmp = maxes[j] ;
                        }
                        j -- ;
                    }
                    maxes[index] = tmp + 1 ;
                }
                if( i == 0 ){
                    cnt[i] = maxes[index] ;
                }
                else{
                    cnt[i] = Math.max( maxes[index], cnt[ i - 1 ] ) ;
                }
                if( cnt[i] > max ){
                    max = cnt[i] ;
                }
            }
            else{
                if( i == 0 ){
                    cnt[i] = 0 ;
                }
                else{
                    cnt[i] = cnt[ i - 1 ] ;
                }
            }
        }
        // System.out.println(Arrays.toString(maxes)) ;
        // System.out.println(Arrays.toString(cnt)) ;
        return n - max > 0 ? n - max : 0 ;
    }
}
