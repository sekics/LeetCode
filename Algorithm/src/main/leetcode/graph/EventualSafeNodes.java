package main.leetcode.graph;

import java.util.*;

public class EventualSafeNodes {

    int[][] graph_ ;

//    public boolean isSafeNode(int startNode , int nowNode , int cnt , Set<Integer> ends ,Set<Integer> unsafeNodes ,LinkedList<Integer> list){
//        if( cnt > 0 && ( startNode == nowNode ) ){
//            unsafeNodes.addAll(list) ;
//            return false ;
//        }
//        else{
//            boolean res = true ;
//            for( int i = 0 ; i < graph_[nowNode].length ; i ++ ){
//                int end = graph_[nowNode][i] ;
//                if( ends.contains(end) ){
//                    continue ;
//                }
//                else if( unsafeNodes.contains(end) || res == false ){
//                    unsafeNodes.add(nowNode) ;
//                    return false ;
//                }
//                else{
//                    list.addLast(end);
//                    res = isSafeNode(startNode,end,cnt + 1 ,ends ,unsafeNodes,list) ;
//                    list.removeLast() ;
//                }
//            }
//            ends.add(nowNode) ;
//            return true ;
//        }
//    }


    //拓扑排序
    public List<Integer> enventualSafeNodes(int[][] graph){
        int n = graph.length ;
        int[] outDegree = new int[n] ;
        Map<Integer,Set<Integer>> inVertex = new HashMap<>() ;
        Queue<Integer> zeroDegree = new LinkedList<>() ;
        Set<Integer> ends = new HashSet<>() ;
        for( int i = 0 ; i < n ; i ++ ){
            if( graph[i].length == 0 ){
                zeroDegree.offer(i) ;
                outDegree[i] = 0 ;
            }
            else{
                outDegree[i] = graph[i].length ;
                for( int j = 0 ; j < graph[i].length ; j ++ ){
                    if( inVertex.containsKey(graph[i][j])){
                        inVertex.get(graph[i][j]).add(i) ;
                    }
                    else{
                        Set<Integer> set = new HashSet<>() ;
                        set.add(i) ;
                        inVertex.put(graph[i][j],set) ;
                    }
                }
            }
        }
        while( !zeroDegree.isEmpty() ){
            int nowNode = zeroDegree.poll() ;
            ends.add(nowNode) ;
            Set<Integer> in = inVertex.get(nowNode) ;
            for(Integer integer : in ){
                if( !ends.contains(integer) ){
                    outDegree[integer] -- ;
                    if( outDegree[integer] == 0 ){
                        zeroDegree.add(integer) ;
                    }
                }
            }
        }
        List<Integer> ans = new ArrayList<>(ends) ;
        Collections.sort(ans);
        return ans ;
    }
}
