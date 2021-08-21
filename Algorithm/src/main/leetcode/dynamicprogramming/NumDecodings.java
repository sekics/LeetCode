package main.leetcode.dynamicprogramming;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class NumDecodings {

    public int numDecodings( String s ){
//        Map< String , String > map = new HashMap<>() ;
        Set<String> set = new HashSet<>() ;
        for( int i = 1 ; i <= 26 ; i ++ ){
//            map.put( String.valueOf(i) , )
            set.add( String.valueOf(i) ) ;
        }
        int n = s.length() ;
        int[] dp = new int[n] ;
        if( set.contains( s.substring(0,1) ) ){
            dp[0] = 1 ;
        }
        else{
            return 0 ;
        }
        for( int i = 1 ; i < n ; i ++ ) {
            //当前位不为0
            if( set.contains( s.substring( i , i + 1 ) ) ){
                if( set.contains( s.substring( i - 1 , i + 1 ) ) ){
                    dp[i] = dp[ i - 1 ] + 1 ;
                }
                else{
                    dp[i] = dp[ i - 1 ] ;
                }
            }
            //当前位为0
            else{
                //能够和前面一位组合
                if( i - 2 >= 0 && set.contains( s.substring( i - 1 , i + 1 ) ) ){
                    dp[i] = dp[ i - 2 ] ;
                }
                else{
                    return 0 ;
                }
            }
        }
        return dp[ n - 1 ] ;
    }
}
