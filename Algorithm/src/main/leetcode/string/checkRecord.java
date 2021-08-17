package main.leetcode.string;

public class checkRecord {

    public boolean checkRecord(String s){
        char[] chars = s.toCharArray();
        int aCnt = chars[0] == 'A' ? 1 : 0 ;
        for( int i = 1 ; i < chars.length ; i ++ ){
            if( chars[i] == 'A' ){
                aCnt ++ ;
            }
            if( aCnt > 1 ){
                return false ;
            }
            if( i < chars.length - 2 ){
                if( chars[ i - 1 ] == 'L' && chars[ i ] == 'L' && chars[ i + 1 ] == 'L' ){
                    return false ;
                }
            }
        }
        return true ;
    }
}
