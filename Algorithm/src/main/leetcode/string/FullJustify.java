package main.leetcode.string;

import java.util.ArrayList;
import java.util.List;

public class FullJustify {

    public List<String> fullJustify( String[] words , int maxWidth ){
        List<String> ans = new ArrayList<>() ;
        List<String> tmp = new ArrayList<>() ;
        int cnt = 0 ;
        for( int i = 0 ; i < words.length ; i ++ ){
            int length = words[i].length() ;
            int size = tmp.size()  ;
            int gap = size - 1 ;
            if( cnt + size+ length > maxWidth ){
                StringBuilder sb = new StringBuilder() ;
                int remainNum = maxWidth - cnt;
//                int averageBlank = remainNum / gap ;
                int averageBlank = gap > 0 ? remainNum / gap : remainNum ;
//                int remainBlank = remainNum % gap ;
                int remainBlank = gap > 0 ? remainNum % gap : 0 ;
                int num = 0 ;
                for( int j = 0 ; j < size ; j ++ ){
                    sb.append( tmp.get(j) ) ;
                    if( j < gap || gap == 0 ){
                        int blank = num < remainBlank ? averageBlank + 1 : averageBlank ;
                        while( blank > 0 ){
                            sb.append(" ") ;
                            blank -- ;
                        }
                        num ++ ;
                    }
                }
                cnt = 0 ;
                ans.add( sb.toString() ) ;
                tmp.clear() ;
            }
            cnt += length ;
            tmp.add( words[i] ) ;
        }
        if( !tmp.isEmpty() ){
            StringBuilder sb = new StringBuilder() ;
            for( int j = 0 ; j < tmp.size() ; j ++ ){
                sb.append( tmp.get(j) ) ;
                if( j < tmp.size() - 1 ){
                    sb.append( " " ) ;
                }
            }
            while( sb.length() < maxWidth ){
                sb.append( " " ) ;
            }
            ans.add( sb.toString() ) ;
        }
        return ans ;
    }
}
