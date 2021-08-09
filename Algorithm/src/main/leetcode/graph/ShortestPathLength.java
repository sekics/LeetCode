package main.leetcode.graph;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathLength {

    public int shortesPathLength(int[][] graph){
        int n = graph.length ;
        Queue<int[]> queue = new LinkedList<>() ;
        boolean[][] seen = new boolean[n][ 1 << n ] ;
        for( int i = 0 ; i < n ; i ++ ){
            //向queue中压入三元组，{u,mask,length} u为当前节点编号，mask和length用于记录状态，mask记录经过length步后经过了哪些节点
            //比如0号节点初始时压入的是{0,1,0}
            //1号节点压入为{1,2,0}   2号节点{2,4,0}  3号节点{3,8,0},保证所有的可能路径都会遍历到
            queue.offer(new int[]{ i , 1 << i , 0 } ) ;
            seen[i][ 1 << i ] = true ;
        }
        int ans = Integer.MAX_VALUE ;
        while( ! queue.isEmpty() ){
            int[] now = queue.poll() ;
            int index = now[0] , mask = now[1] , length = now[2] ;
            //随着遍历过程的不断推移，length会越来越大，因此最先遇到所有节点都被标记的三元组即为最短的路径，此时返回的值为最小
            if( mask == ( ( 1 << n ) - 1 ) ){
                ans = length ;
                break ;
            }
            for( int v : graph[index]){
                //异或把当前点和下个点,得到下个点的mask状态
                int maskV = mask | ( 1 << v ) ;
                if( seen[v][maskV] == false ){
                    queue.offer(new int[]{v,maskV,length + 1 } ) ;
                    seen[v][maskV] = true ;
                }
            }
        }
        return ans ;
    }


    @Test
    public void test(){
        int n = 5 ;
        boolean[][] seen = new boolean[n][ 1 << n ] ;
        System.out.println( seen[0].length ) ;
    }
}
