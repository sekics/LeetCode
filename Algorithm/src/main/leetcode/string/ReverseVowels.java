package main.leetcode.string;

import java.util.HashSet;
import java.util.Set;

public class ReverseVowels {

    public String reverseVowels(String s){
        char[] chars = s.toCharArray();
        int left = 0 , right = chars.length - 1 ;
        Set<Character> vowels = new HashSet<>() ;
        char[] vs = {'a','e','i','o','u'} ;
        for (char v : vs) {
            vowels.add(v) ;
        }
        while( left <= right ){
            while( left <= right && !vowels.contains(chars[left]) ){
                left ++ ;
            }
            while( left <= right && !vowels.contains(chars[right]) ){
                right -- ;
            }
            char ch = chars[left] ;
            chars[left] = chars[right] ;
            chars[right] = ch ;
        }
        return new String(chars) ;
    }
}
