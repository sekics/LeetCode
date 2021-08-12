package main.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Generate {

    public List<List<Integer>> generate(int numRows){
        List<List<Integer>> ans = new ArrayList<>() ;
        for( int i = 0 ; i < numRows ; i ++ ){
            List<Integer> row = new ArrayList<>() ;
            if( i < 2 ){
                for( int j = 0 ; j < i + 1 ; j ++ ){
                    row.add(1) ;
                }
            }
            else{
                List<Integer> tmp = ans.get( i - 1 ) ;
                row.add(1) ;
                for( int j = 1 ; j < tmp.size() ; j ++ ){
                    row.add( tmp.get(j) + tmp.get( j - 1 ) ) ;
                }
                row.add(1) ;
            }
            ans.add(row) ;
        }
        return ans ;
    }
}
