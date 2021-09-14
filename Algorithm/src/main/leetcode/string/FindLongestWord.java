package main.leetcode.string;

import java.util.*;

public class FindLongestWord {

    public String findLongestWord( String s , List<String> dictionary){
        Map< Character , List<Integer> > map = new HashMap<>() ;
        int n = s.length() ;
        for( int i = 0 ; i < n ; i ++ ){
            List<Integer> tmp = map.getOrDefault( s.charAt(i) , new ArrayList<Integer>());
            tmp.add( i ) ;
            map.put( s.charAt(i) , tmp );
        }
        Collections.sort(dictionary, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if( o1.length() != o2.length() ){
                    return o2.length() - o1.length() ;
                }
                else{
                    int n = o1.length() ;
                    for( int i = 0 ; i <  n ; i ++ ){
                        if( o1.charAt(i) != o2.charAt(i) ){
                            return o1.charAt(i) - o2.charAt(i) ;
                        }
                    }
                    return 0 ;
                }
            }
        });
        for( int i = 0 ; i < dictionary.size() ; i ++ ){
            String str = dictionary.get( i ) ;
            n = str.length() ;
            int nowIndex = -1 ;
            StringBuilder sb = new StringBuilder() ;
            for( int j = 0 ; j < n ; j ++ ){
                List<Integer> list = map.get(str.charAt(j)) ;
                int mark = nowIndex ;
                if( list == null ){
                    break ;
                }
                else{
                    for (Integer integer : list) {
                        if( integer > nowIndex ){
                            nowIndex = integer ;
                            sb.append( str.charAt(j) ) ;
                            break ;
                        }
                    }
                }
            }
            if( str.equals( sb.toString() ) ){
                return str ;
            }
        }
        return null ;
    }

    public String findLongestWordPointer( String s , List<String> dictionary ){
        String ans = "";
        for (String str : dictionary) {
            int i = 0  , t = 0 ;
            while( i < s.length() && t < str.length() ){
                if( s.charAt(i) == str.charAt(t) ){
                    t ++ ;
                }
                i ++ ;
            }
            if( t == str.length() && str.length() > ans.length() && ans.compareTo( str ) < 0 ){
                ans = str ;
            }
        }
        return ans ;
    }

    public String findLongestWordDpPreprocess( String s , List<String> dictionary ){
        int m = s.length() ;
        int[][] dp = new int[ m + 1 ][ 26 ] ;
        Arrays.fill( dp[m] , m ) ;
        for( int i = m - 1 ; m >= 0 ; i -- ){
            for( int j = 0 ; j < 26 ; j ++ ){
                if( s.charAt(i) == ( j + 'a') ){
                    dp[i][j] = i ;
                }
                else{
                    dp[i][j] = dp[ i + 1 ][ j ] ;
                }
            }
        }
        String ans = "" ;
        for (String str : dictionary) {
            int j = 0 ;
            int nowIndex = 0 ;
            for( ; j < m ;  ){
                if( dp[j][ s.charAt(nowIndex) - 'a'] != m ){
                    j = dp[j][ s.charAt( nowIndex ++ ) - 'a' ] ;
                }
                else{
                    break ;
                }
            }
            if( nowIndex == str.length() && ( str.length() > ans.length() || ( str.length() == ans.length() && str.compareTo( ans) < 0 ))){
                ans = str ;
            }
        }
        return ans ;
    }
}
