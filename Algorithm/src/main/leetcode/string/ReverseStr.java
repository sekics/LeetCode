package main.leetcode.string;

public class ReverseStr {

    public String reverseStr( String s , int k ){
        StringBuilder sb = new StringBuilder() ;
        char[] chars = s.toCharArray() ;
        int i = 0 ;
        int K = 2 * k ;
        while( i < s.length() ){
            int j = i + k - 1 ;
            if( i % K < k ){
                for( ; j >= i ; j -- ){
                    sb.append( chars[j] ) ;
                }
            }
            j = i ;
            for( ; j < i + k && j < s.length() ; j ++ ){
                sb.append( chars[j] ) ;
            }
            i = i + K > s.length() ? s.length() : i + K ;
        }
        return sb.toString() ;
    }

    public String reverseStrII( String s , int k ){
        StringBuilder sb = new StringBuilder() ;
        char[] chars = s.toCharArray() ;
        int i = 0 , n = s.length();
        int K = 2 * k ;
        int cnt = 0 ;
        while( i < n ){
            if( cnt % 2 == 0 ){
                int j = Math.min( i + k - 1 , n ) ;
                for( ; j >= i ; j -- ){
                    sb.append(chars[j]) ;
                }
            }
            else{
                int j = Math.min( i + k , n ) ;
                sb.append(chars,i,j) ;
            }
            cnt ++ ;
            i = i + k  ;
        }
        return sb.toString() ;
    }
}
