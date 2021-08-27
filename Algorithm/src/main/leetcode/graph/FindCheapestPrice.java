package main.leetcode.graph;

import java.util.*;

public class FindCheapestPrice {


    //超时
    int min = Integer.MAX_VALUE ;
    Set<Integer> seen = new HashSet<>() ;
    int[][] fee ;
    Map<Integer, List<Integer>> graph ;
    int dst_ ;
    public void DFS( int now , int nowCost , int k){
        if( now == dst_ && seen.size() <= k + 2 && nowCost < min ){
            min = nowCost ;
        }
        else if( seen.size() > k + 2 ){
            return ;
        }
        else if( now != dst_ ){
            List<Integer> nextSteps = graph.get( now ) ;
            if ( nextSteps != null ) {
                for (Integer nextStep : nextSteps) {
                    int fe = nowCost + fee[now][nextStep] ;
                    if( !seen.contains(nextStep) && fe < min ){
                        seen.add(nextStep) ;
                        DFS( nextStep , fe , k ) ;
                        seen.remove( nextStep ) ;
                    }
                }
            }
        }
    }

    public int findCheapestPrice( int n , int[][] flights , int src , int dst ,int k){
        graph = new HashMap<>() ;
        dst_ = dst ;
        int edgeNum = flights.length ;
        fee = new int[n][n] ;
        for( int i = 0 ; i < n ; i ++ ){
            for( int j = 0 ; j < n ; j ++ ){
                if( i != j ){
                    fee[i][j] = Integer.MAX_VALUE ;
                }
            }
        }
        for( int i = 0 ; i < edgeNum ; i ++ ){
            int start = flights[i][0] ;
            int end = flights[i][1] ;
            if( graph.get( start ) == null ){
                graph.put( start , new ArrayList<Integer>() ) ;
            }
            graph.get(start).add( end ) ;
            fee[start][end] = flights[i][2] ;
        }
        seen.add( src ) ;
        DFS(src,0,k) ;
        return min == Integer.MAX_VALUE ? -1 : min ;
    }

    public int findCheapestPriceOptim( int n , int[][] flights , int src , int dst ,int k){
        for( int i = 0 ; i < n ; i ++ ){
            for( int j = 0 ; j < n ; j ++ ){
                if( i != j ){
                    fee[i][j] = Integer.MAX_VALUE ;
                }
            }
        }
        int edgeNum = flights.length ;
        for( int i = 0 ; i < n ; i ++ ){
            int start = flights[i][0] ;
            int end = flights[i][1] ;
            fee[start][end] = flights[i][2] ;
        }
        int[] shortest = new int[n] ;
        int[] seen = new int[n] ;
        for( int i = 0 ; i < n ; i ++ ){
            shortest[i] = fee[dst][i] ;
        }
        seen[dst] = 1 ;
        for( int i = 0 ; i < k ; i ++ ){
            int min = Integer.MIN_VALUE ;
            int minIndex = dst ;
            for( int j = 0 ; j < n ; j ++ ){
                if( seen[j] == 0 && shortest[j] < min ){
                    min = shortest[j] ;
                    minIndex = seen[j] ;
                }
            }
            seen[minIndex] = 1 ;
            for( int j = 0 ; j < n ; j ++ ){
                if( seen[j] == 0 && shortest[minIndex] + fee[minIndex][dst] < shortest[j] ){
                    shortest[j] = shortest[minIndex] + fee[minIndex][dst] ;
                }
            }
            if( minIndex == src ){
                break ;
            }
        }
        return shortest[src] == Integer.MAX_VALUE ? -1 : shortest[src] ;
    }

    public int findCheapestPriceDP( int n , int[][] flights , int src , int dst ,int k ){
        final int INF = 1000 * 101 + 1 ;
        int[][] dp = new int[ k + 2 ][ n ] ;
        for( int i = 0 ; i < k  +2 ; i ++ ){
            Arrays.fill( dp[i] , INF ) ;
        }
        dp[ 0 ][ src ] = 0 ;
        for( int i = 1 ; i <= k + 1 ; i ++ ){
            for (int[] flight : flights) {
                int start = flight[0] ;
                int end = flight[1] ;
                int cost = flight[2] ;
                dp[i][ end ] = Math.min( dp[i][end] , dp[ i - 1 ][ start ] + cost ) ;
            }
        }
        int ans = INF ;
        for( int i = 0 ; i <= k + 1 ; i ++ ){
            ans = Math.min( ans , dp[i][dst] ) ;
        }
        return ans ;
    }
}
