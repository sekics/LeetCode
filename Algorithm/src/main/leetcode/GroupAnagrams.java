package main.leetcode;

import org.junit.Test;

import java.util.*;

public class GroupAnagrams {

    @Test
    public void setTest(){
        Set<String> set1 = new HashSet<>() ;
        Set<String> set2 = new HashSet<>() ;
        set1.add("ab") ;
        set1.add("bc") ;
        set2.add("bc") ;
        set2.add("ab") ;
        System.out.println(set1.equals(set2));
    }

    public List<List<String>> groupAnagrams(String[] strs){
        List<List<String>> ans = new ArrayList<List<String>>() ;
        Map<String,List<String>> map = new HashMap<>() ;
        int n = strs.length ;
        for(String str : strs){
            int[] cnt = new int[26] ;
            int l = str.length() ;
            for( int i = 0 ; i < l ; i ++ ){
                cnt[ str.charAt(i) - 'a' ] ++ ;
            }
            StringBuilder sb = new StringBuilder() ;
            for( int i = 0 ; i < 26 ; i ++ ){
                if( cnt[i] > 0 ){
                    sb.append( i + 'a' ) ;
                    sb.append( String.valueOf(cnt[i]) ) ;
                }
            }
            String key = sb.toString() ;
            List<String> value = map.get(key) ;
            if( value == null ){
                value = new ArrayList<String>() ;
            }
            value.add(str) ;
            map.put(key,value) ;
        }
        for(Map.Entry<String,List<String>> value : map.entrySet() ){
            ans.add( value.getValue() ) ;
        }
        return ans ;
    }
}
