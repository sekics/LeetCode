package main.leetcode.dynamicprogramming;

import java.util.*;

public class MinimizeTheDifference {

    public int minimizeTheDifference( int[][] mat , int target ){
        int m = mat.length ;
        int n = mat[0].length ;
        Set<Integer>[] sets = new HashSet[m] ;
        for( int i = 0 ; i < m ; i ++ ){
            sets[i] = new HashSet<Integer>() ;
        }
        for( int i = 0 ; i < n ; i ++ ){
            sets[0].add( mat[0][i] ) ;
        }
        int[] mins = new int[m] ;

        for( int i = 1 ; i < m ; i ++ ){
            Set<Integer> pre = sets[ i - 1 ] ;
            for (Integer integer : pre) {
                for( int j = 0 ; j < n ; j ++ ){
                    if( integer + mat[i][j] < target ){
                        sets[i].add( integer + mat[i][j] ) ;
                    }
                }
            }
        }
        int ans = - 800 ;
        for (Integer integer : sets[m - 1]) {
            if( Math.abs( integer - target ) < ans ){
                ans = Math.abs(integer - target) ;
            }
        }
        return ans ;
    }

    public int minimizeTheDifference2(int[][] mat, int target) {
        int m = mat.length ;
        int n = mat[0].length ;
        Set<Integer>[] sets = new HashSet[m] ;
        for( int i = 0 ; i < m ; i ++ ){
            sets[i] = new HashSet<Integer>() ;
        }
        for( int i = 0 ; i < n ; i ++ ){
            sets[0].add( mat[0][i] ) ;
        }

        int[] mins = new int[m] ;
        for( int i = 0 ; i < m ; i ++ ){
            mins[i] = 800 ;
            for( int j = 0 ; j < n ; j ++ ){
                mins[i] = Math.min( mins[i] , mat[i][j] ) ;
            }
        }

        for( int i = 1 ; i < m ; i ++ ){
            Set<Integer> pre = sets[ i - 1 ] ;
            int rm = Integer.MAX_VALUE ;
            for (Integer integer : pre) {
                // int rm = Integer.MAX_VALUE ;
                for( int j = 0 ; j < n ; j ++ ){
                    if(integer + mat[i][j] <= target ){
                        sets[i].add( integer + mat[i][j] ) ;
                    }
                    else if( integer + mat[i][j] > target ){
                        int now = mat[i][j] + integer ;
                        if( now < rm ){
                            rm = now ;
                            sets[i].add(now) ;
                        }
                    }
                }
            }
            // System.out.println( sets[i].toString() ) ;
        }
        int ans = 1600 ;
        System.out.println( sets[ m - 1 ].toString()) ;
        for (Integer integer : sets[m - 1]) {
            if( Math.abs( integer - target ) < ans ){
                ans = Math.abs(integer - target) ;
            }
        }
        return ans ;
    }
}
