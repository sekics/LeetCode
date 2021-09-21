package main.leetcode;

import java.util.*;

public class DetectSquares {

    int[][] graph ;
    int maxX ;
    int maxY ;

    public DetectSquares() {
        this.graph = new int[1001][1001] ;
        this.maxX = 1 ;
        this.maxY = 1 ;
    }

    public void add(int[] point) {
        int X = point[0] ;
        int Y = point[1] ;
        this.graph[X][Y] ++ ;
        this.maxX = Math.max( this.maxX , X ) ;
        this.maxY = Math.max( this.maxY , Y ) ;
    }

    public int count(int[] point) {
        int ans = 0 ;
        int X = point[0] ;
        int Y = point[1] ;
        for( int k = 1 ; k <= Math.min( this.maxX , this.maxY) ; k ++ ){
            if( ( X - k ) >= 0 && ( Y - k ) >= 0 ){
                ans += this.graph[ X - k ][ Y - k ] * this.graph[ X - k ][Y] * this.graph[X][ Y - k ] ;
            }
            if( ( X + k ) <= this.maxX && ( Y - k ) >= 0 ){
                ans += this.graph[ X + k][Y] * this.graph[X][ Y - k ] * this.graph[ X + k ][ Y - k ] ;
            }
            if( ( X - k ) >= 0 && ( Y + k ) <= this.maxY ){
                ans +=  this.graph[ X - k][Y] * this.graph[X ][ Y + k ] * this.graph[ X - k ][ Y + k ] ;
            }
            if( ( X + k ) <= this.maxX && ( Y + k ) <= this.maxY){
                ans +=  this.graph[ X + k][Y] * this.graph[X ][ Y + k ] * this.graph[ X + k ][ Y + k ] ;
            }
        }
        return ans ;
    }
}
