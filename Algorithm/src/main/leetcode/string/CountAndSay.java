package main.leetcode.string;

public class CountAndSay {

    public String countAndSay(int n){
        if( n == 1 ){
            return String.valueOf(1) ;
        }
        StringBuilder sb = new StringBuilder() ;
        sb.append("1") ;
        for( int i = 2 ; i <= n ; i ++ ){
            String pre = sb.toString() ;
            StringBuilder now = new StringBuilder() ;
            int sl = pre.length() ;
            for( int j = 0 ; j < sl ; ){
                int k = 1 ;
                while( j < sl && pre.charAt(j) == pre.charAt( j + 1 ) ){
                    k ++ ;
                    j ++ ;
                }
                now.append(pre.charAt(j)) ;
                now.append(String.valueOf(k)) ;
            }
            sb = now ;
        }
        return sb.toString() ;
    }

    public String countAndSayRecursion(int n){
        if( n == 1 ){
            return "1" ;
        }
        else{
            String pre = countAndSayRecursion( n - 1 ) ;
            int ln = pre.length() ;
            StringBuilder sb = new StringBuilder() ;
            for( int i = 0 ; i < ln ; ){
                int k = 1 ;
                while( i + 1 < ln && pre.charAt(i) == pre.charAt( i + 1 ) ){
                    i ++ ;
                    k ++ ;
                }
                sb.append(String.valueOf(k)) ;
                sb.append(pre.charAt(i)) ;
                i ++ ;
            }
            return sb.toString() ;
        }
    }
}
