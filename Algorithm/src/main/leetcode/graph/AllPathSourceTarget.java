package main.leetcode.graph;

import java.util.*;

public class AllPathSourceTarget {

    Set<Integer> seen = new HashSet<>() ;
    List<List<Integer>> ans = new ArrayList<>() ;
    int n_ ;
    int[][] graph_ ;
    public void DFS( int nowIndex , Stack<Integer> tmp ){
        if( nowIndex == n_ - 1 ){
            ans.add( new ArrayList<>(tmp) ) ;
        }
        else if( seen.size() < n_ ){
            seen.add( nowIndex ) ;
            for( int i = 0 ; i < graph_[i].length; i ++ ){
                if( !seen.contains(graph_[nowIndex][i] )  ){
                    tmp.push( graph_[nowIndex][i] ) ;
                    DFS( graph_[nowIndex][i] , tmp ) ;
                    tmp.pop() ;
                }
            }
            seen.remove( nowIndex ) ;
        }
    }
    public List<List<Integer>> allPathSourceTarget(int[][] graph){
//        seen.add(0) ;
        n_ = graph.length ;
        graph_ = graph ;
//        LinkedList<Integer> tmp = new LinkedList<>() ;
        Stack<Integer> tmp = new Stack<>() ;
        DFS(0,tmp) ;
        return ans ;
    }

}