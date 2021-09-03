package main.leetcode.dynamicprogramming.statecompression;

import java.util.*;

public class CountSubgraphsForEachDiameter {

    int[][] graph ;
    int n_ ;
    boolean flag = false ;
    public Set<Integer> getEdges(int state ){
        Set<Integer> edges = new HashSet<>() ;
        int idx = 0 ;
        while( state > 0 ){
            if( (state & 1) == 1 ){
                edges.add( idx ) ;
            }
            idx ++ ;
            state = state >> 1 ;
        }
        return edges ;
    }
    public void DFS( Set<Integer> edges , int nowEdge ){
        edges.remove( nowEdge ) ;
        if( edges.isEmpty() ){
            flag = true ;
        }
        else{
            for( int i = 0 ; i < n_ ; i ++ ){
                if( graph[nowEdge][i] != 20 && edges.contains( i ) ){
                    // System.out.println( nowEdge + "  " + i + "  " + graph[nowEdge][i] + " " + edges.toString() ) ;
                    DFS( edges , i ) ;
                }
            }
        }
    }
    public boolean judgeConnectivity( int state ){
        Set<Integer> edges = getEdges( state ) ;
        int start = 0 ;
        for (Integer edge : edges) {
            start = edge ;
            break ;
        }
        flag = false ;
        // System.out.println( "State : " + state + " edges : " + edges.toString() ) ;
        DFS( edges , start ) ;
        // System.out.println( flag ) ;
        return flag ;
    }

    public int[] countSubgraphsForEachDiameter(int n, int[][] edges) {
        graph = new int[ n ][ n ] ;
        n_ = n ;
        for( int i = 0 ; i < n ; i ++ ){
            Arrays.fill( graph[i] , 20 );
            graph[i][i] = 0 ;
        }
        for( int i = 0 ; i < edges.length ; i ++ ){
            int start = edges[i][0] - 1 ;
            int end = edges[i][1] - 1 ;
            graph[start][end] = 1 ;
            graph[end][start] = 1 ;
        }
        boolean[] isConnected = new boolean[ 1 << n ] ;
        for( int i = 0 ; i < ( 1 << n ) ; i ++ ){
            isConnected[i] = judgeConnectivity(i) ;
        }

        System.out.println( Arrays.toString( isConnected ) ) ;
        int[][] shortest = new int[n][n] ;
        for( int i = 0 ; i < n ; i ++ ){
            boolean[] vis = new boolean[n] ;
            vis[i] = true ;
            for( int j = 0 ; j < n ; j ++ ){
                shortest[i][j] = graph[i][j] ;
            }
            for( int j = 0 ; j < n - 1 ; j ++ ){
                int min = 25 ;
                int minIndex = i ;
                for( int k = 0 ; k < n ; k ++ ){
                    if( vis[k] == false && shortest[i][k] < min ){
                        min = shortest[i][k] ;
                        minIndex = k ;
                    }
                }
                vis[minIndex] = true ;
                for( int k = 0 ; k < n ; k ++ ){
                    // System.out.println( minIndex ) ;
                    if( vis[k] == false && shortest[i][minIndex] + graph[minIndex][k] < shortest[i][k] ){
                        shortest[i][k] = shortest[i][minIndex] + graph[minIndex][k] ;
                    }
                }
            }
            System.out.println(Arrays.toString( shortest[i] ) ) ;
        }
        int[] ans = new int[ n - 1 ] ;
        for( int i = 0 ; i < 1 << n ; i ++ ){
            if( isConnected[i] ){
                Set<Integer> edgesI = getEdges(i) ;
                if( edgesI.size() > 2 ){
                    int maxD = 0 ;
                    for (Integer outer : edgesI) {
                        for (Integer inner : edgesI) {
                            if( shortest[outer][inner] > maxD ){
                                maxD = Math.max( maxD , shortest[ outer ][ inner ] ) ;
                            }
                        }
                    }
                    if( maxD > 0 ){
                        ans[ maxD - 1 ] ++ ;
                    }
                }
            }
//            for( int j = ( i - 1 ) & i  ; j > 0 ; j = ( j - 1 ) & i ){
//                if( isConnected[i] && isConnected[j] ){
//                    Set<Integer> edgeI = getEdges(i) ;
//                    Set<Integer> edgeJ = getEdges(j) ;
//                    int maxD = 0 ;
//                    for (Integer edgei : edgeI) {
//                        for (Integer edgej : edgeJ) {
//                            maxD = Math.max( edgei , edgej ) ;
//                        }
//                    }
//                    if( maxD > 0 ){
//                        ans[ maxD - 1 ] ++ ;
//                    }
//                }
//            }
        }
        return ans ;
    }

}
