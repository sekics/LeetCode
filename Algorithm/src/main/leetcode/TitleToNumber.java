package main.leetcode;

import java.util.HashMap;
import java.util.Map;

public class TitleToNumber {

    public int titleToNumber(String columnTitle){
        Map<Character,Integer> map = new HashMap<>() ;
        for( int i = 0 ; i < 26 ; i ++ ){
            map.put((char)('a' + i ), i + 1 ) ;
        }
        int ans = 0 ;
        for( int i = 0 ; i < columnTitle.length() ; i ++ ){
            ans = ans * 26 + map.get( columnTitle.charAt(i) ) ;
        }
        return ans ;
    }
}
