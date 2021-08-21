package main.leetcode.string;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Compress {

    public int compress(char[] chars){
        int index = 0 , i = 0 ;
        int n = chars.length ;
        Stack<Integer> queue = new Stack<Integer>() ;
        while( i < n ){
            int cnt = 1 ;
            while( i + 1 < n && chars[ i + 1 ] == chars[i] ){
                i ++ ;
                cnt ++ ;
            }
            if( cnt == 1 ){
                chars[ index ++ ] = chars[i] ;
            }
            else{
                chars[ index ++ ] = chars[i] ;
                while( cnt > 0 ){
                    queue.push( cnt % 10 ) ;
                    cnt /= 10 ;
                }
                while( !queue.isEmpty() ){
                    int s = queue.pop() ;
                    chars[ index ++ ] = ( char ) ( s + '0' ) ;
                }
            }
            i ++ ;
        }
        return index ;
    }
}
