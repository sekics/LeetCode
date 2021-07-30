package main.leetcode.graph;

import java.util.*;

public class CloneGraph {

    public void dfs( Node node , Map<Integer,Node> map){
        if( node != null ){
            map.put( node.val , node ) ;
            List<Node> nodes = node.neighbors ;
            for( int i = 0 ; i < nodes.size() ; i ++ ){
                if( ! map.containsKey( nodes.get(i).val)  ){
                    dfs( nodes.get(i),map) ;
                }
            }
        }
    }
    public Node cloneGraph(Node node){
        Map<Integer,Node> map = new HashMap<>() ;
        dfs(node,map) ;
        Map<Integer,List<Integer>> neighbors = new HashMap<>() ;
        Map<Integer,Node> newNodes = new HashMap<>() ;
        for (Integer integer : map.keySet()) {
            Node item = map.get(integer) ;
            List<Node> items = item.neighbors ;
            List<Integer> ints = new ArrayList<>();
            for( int i = 0 ; i < items.size() ; i ++ ){
                ints.add( items.get(i).val ) ;
            }
            neighbors.put( integer , ints ) ;
            newNodes.put( integer, new Node(integer) ) ;
        }
        for (Map.Entry<Integer, List<Integer>> entry : neighbors.entrySet()) {
            Node tmp = newNodes.get( entry.getKey() ) ;
            List<Integer> intNeighbors = entry.getValue() ;
            for( int i = 0 ; i < intNeighbors.size() ; i ++ ){
                tmp.neighbors.add( newNodes.get( intNeighbors.get(i) ) ) ;
            }
        }
        return newNodes.get( node.val ) ;
    }
}
