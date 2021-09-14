package main.leetcode;

import java.util.HashMap;
import java.util.Map;

public class NumberOfBoomrans {

    public int combination( int c ){
        return c * ( c - 1 ) / 2 ;
    }
    public int numberOfBoomerans( int[][] points ){
        int n = points.length ;
        Map<Integer,Integer> map = new HashMap() ;
        int ans = 0 ;
        for( int i = 0 ; i < n ; i ++ ){
            int nowX = points[i][0] ;
            int nowY = points[i][1] ;
            for( int j = 0 ; j < n ; j ++ ){
                if( i != j ) {
                    int X = points[j][0];
                    int Y = points[j][1];
                    int dis = (int) Math.pow(X - nowX, 2) + (int) Math.pow(Y - nowY, 2);
                    map.put(dis, map.getOrDefault(dis, 0) + 1);
                }
            }
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if( entry.getValue() > 1 ){
                    ans = ans + 2 * combination( entry.getValue()  ) ;
                }
            }
            map.clear() ;
        }
        return ans ;
    }
}
