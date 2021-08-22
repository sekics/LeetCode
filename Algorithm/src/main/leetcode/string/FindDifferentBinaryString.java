package main.leetcode.string;

import java.util.HashSet;
import java.util.Set;

public class FindDifferentBinaryString {

    public String findDifferentBinaryString(String[] nums){
        Set<String> set = new HashSet<>() ;
        for (String num : nums) {
            set.add( num ) ;
        }
        int n = nums.length ;
        int max = (int) Math.pow( 2 , n ) ;
        String ans = null;
        for( int i = 0 ; i < max ; i ++ ){
            ans = getString( i , n ) ;
            if( !set.contains(ans) ){
                break ;
            }
        }
        return ans ;
    }

    public String getString( int i , int n ){
        StringBuilder sb = new StringBuilder() ;
        while( i > 0 && n > 0 ){
            sb.append( i % 2 == 0 ? '0' : '1' ) ;
            i = i / 2 ;
            n -- ;
        }
        return sb.toString() ;
    }
}
