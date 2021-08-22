package main.leetcode.graph;

public class CountPaths {

    int MOD = 1000000007 ;
    int[][] graph ;
    int ans = 0 ;
    int n_ ;
    public void DFS( int nowIndex , int nowCnt , int target ){
        if( target == nowCnt ){
            ans ++ ;
            ans %= MOD ;
        }
        else if( nowCnt > target ){
            return ;
        }
        else{
            for( int i = 0 ; i < n_ ; i ++ ){
                if( i != nowIndex && graph[nowIndex][i] != Integer.MAX_VALUE ){
                    DFS( i , nowCnt + graph[nowIndex][i] , target ) ;
                }
            }
        }
    }

    public int countPaths(int n, int[][] roads) {
        graph = new int[n][n] ;
        n_ = n ;
        for( int i = 0 ; i < n ; i ++ ){
            for( int j = 0 ; j < n ; j ++ ){
                if( i == j ){
                    graph[i][j] = 0 ;
                }
                else{
                    graph[i][j] = Integer.MAX_VALUE ;
                }
            }
        }
        for( int i = 0 ; i < roads.length ; i ++ ){
            int start = roads[i][0] ;
            int end = roads[i][1] ;
            int cost = roads[i][2] ;
            graph[ start ][ end ] = cost ;
            graph[ end ][ start ] = cost ;
        }
        int[] shortes = new int[n] ;
        for( int i = 0 ; i < n ; i ++ ){
            shortes[i] = graph[0][i] ;
        }
        int[] vis = new int[n] ;
        vis[0] = 1 ;
        for( int i = 1 ; i < n ; i ++ ){
            int minIndex = 0 ;
            int maxValue = Integer.MAX_VALUE ;
            for( int j = 0 ; j < n ; j ++ ){
                if( vis[j] == 0 && shortes[j] < maxValue ){
                    maxValue = shortes[j] ;
                    minIndex = j ;
                }
            }
            vis[minIndex] = 1 ;
            for( int j = 0 ; j < n ; j ++ ){
                if( vis[j] == 0 && vis[ minIndex ] + graph[minIndex][j] < vis[j] ){
                    vis[j] = vis[ minIndex ] + graph[minIndex][j] ;
                }
            }
        }
        int target = shortes[ n - 1 ] ;
        DFS( 0 , 0 , target ) ;
        return ans ;
    }
}
