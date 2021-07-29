package main.leetcode.treetraversal;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PathZigzagTree {

    public List<Integer> pathZigzagTree( int label ){
        List<Integer> ans = new ArrayList<>() ;
        int nowHeight = (int) ( Math.log(label) / Math.log(2) ) + 1 ;
        int[] table = new int[21] ;
        table[1] = 1 ;
        int base = 2 ;
        for( int i = 2 ; i <= 20 ; i ++ ){
            table[i] = table[ i - 1 ] + base ;
            base *= 2 ;
        }
        int nowLabel = label ;
        ans.add(label) ;
        while( nowHeight > 1 ) {
            int lastLayerMax = table[ nowHeight - 1 ] ;
            int originParent = nowLabel / 2 ;
            int diff = lastLayerMax - originParent + 1 ;
            nowLabel = table[ nowHeight - 2 ] + diff ;
            ans.add(0,nowLabel) ;
            // ans.add(nowLabel) ;
            nowHeight = nowHeight - 1 ;
        }
        // Collections.reverse(ans) ;
        return ans ;
    }

    @Test
    public void testLog(){
        System.out.println(Math.log(8) / Math.log(2)) ;
    }
}
