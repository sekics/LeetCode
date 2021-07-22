package main.leetcode.linkedlist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CopyRandomList {

    public Node copyRandomList(Node head){
        List<Integer> list = new ArrayList<>() ;
        Map<Node,Integer> map = new HashMap<>() ;
        List<Integer> randomIndex = new ArrayList<>() ;
        Node tmp = head ;
        while( tmp != null ){
            map.put(tmp,list.size()) ;
            list.add( tmp.val ) ;
            tmp = tmp.next ;
        }
        tmp = head ;
        while( tmp != null ){
            if( tmp.random == null ){
                randomIndex.add(-1) ;
            }
            else{
                randomIndex.add( map.get(tmp.random) ) ;
            }
            tmp = tmp.next ;
        }
        Node newHead = new Node( list.get(0) ) ;
        Map<Integer,Node> numToNode = new HashMap<>() ;
        numToNode.put(0,newHead) ;
        tmp = newHead ;
        for( int i = 1 ; i < list.size() ; i ++ ){
            tmp.next = new Node( list.get(i) ) ;
            tmp = tmp.next ;
            numToNode.put(i,tmp) ;
        }
        tmp = newHead ;
        for( int i = 0 ; i < randomIndex.size() ; i ++ ){
            if( randomIndex.get(i) == -1 ){
                tmp.random = null ;
            }
            else{
                tmp.random = numToNode.get( randomIndex.get(i) ) ;
            }
            tmp = tmp.next ;
        }
        return newHead ;
    }
}
