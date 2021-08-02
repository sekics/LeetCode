package main.leetcode.graph;

import java.util.*;

public class NetworkDelayTime {

    int n_ ;
    int k_ ;
    public int getDelay(int[][] graph ){
        Set<Integer> seen = new HashSet<>() ;
        Queue<Integer> next = new LinkedList<>() ;
        Queue<Integer> delays = new LinkedList<>() ;
        int max = 0 ;
        next.add(k_) ;
        seen.add(k_) ;
        delays.add(0) ;
        while( !next.isEmpty() ){
            int size = next.size() ;
            for( int i = 0 ; i < size ; i ++ ){
                int start = next.poll() ;
                int delay = delays.poll() ;
                for( int j = 1 ; j <= n_ ; j ++ ){
                    if( graph[start][j] != 0 && !seen.contains(j) ){
                        next.add(j) ;
                        seen.add(j) ;
                        int nextDelay = delay + graph[start][j] ;
                        delays.add(nextDelay) ;
                        if( nextDelay > max ){
                            max = nextDelay ;
                        }
                    }
                }
            }
        }
        if( seen.size() == n_ ){
            return max ;
        }
        else{
            return -1 ;
        }
    }
    public int networkDelayTime(int[][] times,int n,int k){
        n_ = n ;
        k_ = k ;
        int[][] graph = new int[ n + 1 ][ n + 1 ] ;
        int m = times.length ;
        for( int i = 0 ; i < m ; i ++ ){
            graph[times[i][0]][times[i][1]] = times[i][2] ;
        }
//        int ans = getDelay( graph ) ;
        int ans = dijkstra(graph,k) ;
        return ans ;
    }

    public int dijkstra(int[][] graph, int start){
        int[] shortest = new int[ n_ + 1 ] ;
        Set<Integer> seen = new HashSet<>() ;
        for( int i = 1 ; i <= n_ ; i ++ ){
            shortest[i] = graph[start][i] ;
        }
        shortest[start] = 0 ;
        seen.add(start) ;
        for( int i = 1 ; i < n_ ; i ++ ){
            int min = Integer.MAX_VALUE ;
            int index = 0 ;
            for( int j = 1 ; j <= n_ ; j ++ ){
                if( !seen.contains(j) && shortest[j] <= min && shortest[j] != Integer.MAX_VALUE ){
                    min = shortest[j] ;
                    index = j ;
                }
            }
            seen.add(index) ;
            for( int j = 1 ; j <= n_ ; j ++ ){
                if( !seen.contains(j) && graph[index][j] != Integer.MAX_VALUE  && shortest[index] + graph[index][j] < shortest[j] ){
                    shortest[j] = shortest[index] + graph[index][j] ;
                }
            }
        }
        int ans = 0 ;
        for( int i = 1 ; i <= n_ ; i ++ ){
            if( shortest[i] == Integer.MAX_VALUE ){
                return  -1 ;
            }
            else if( ans < shortest[i] ){
                ans = shortest[i] ;
            }
        }
        return ans ;
    }
}
