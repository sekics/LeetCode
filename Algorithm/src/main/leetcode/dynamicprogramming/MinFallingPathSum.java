package main.leetcode.dynamicprogramming;

public class MinFallingPathSum {

    public int minFallingPathSum( int[][] matrix ){

        int m = matrix.length ;
        int n = matrix[0].length ;
        for( int i = 1 ; i < m ; i ++ ){
            for( int j = 0 ; j < n ; j ++ ){
                if( j == 0 ){
                    matrix[i][0] = Math.min( matrix[ i - 1 ][0] , matrix[ i - 1 ][1] ) + matrix[i][0] ;
                }
                else if( j == n - 1 ){
                    matrix[i][ n - 1 ] = Math.min( matrix[ i - 1 ][ n - 2 ] , matrix[ i - 1 ][ n - 1 ] ) + matrix[i][ n - 1 ] ;
                }
                else{
                    matrix[i][j] = Math.min( matrix[ i - 1 ][ j - 1 ] , Math.min( matrix[ i - 1 ][j] , matrix[ i - 1 ][ j + 1 ] ) ) + matrix[i][j] ;
                }
            }
        }
        int ans = Integer.MAX_VALUE ;
        for( int i = 0 ; i < n ; i ++ ){
            ans = Math.min( ans , matrix[ m - 1 ][i] ) ;
        }
        return ans ;
    }
}
