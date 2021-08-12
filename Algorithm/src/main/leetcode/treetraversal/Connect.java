package main.leetcode.treetraversal;

import java.util.LinkedList;
import java.util.Queue;

public class Connect {

    public Node connect(Node root){
        if( root == null ){
            return null ;
        }
        Queue<Node> queue = new LinkedList<>() ;
        queue.offer(root) ;
        while( !queue.isEmpty() ) {
            int size = queue.size() ;
            for( int i = 0 ; i < size ; i ++ ){
                Node tmp = queue.poll() ;
                if( i != size - 1 ){
                    tmp.next = queue.peek() ;
                }
                else{
                    tmp.next = null ;
                }
                if( tmp.left != null ){
                    queue.offer( tmp.left ) ;
                }
                if( tmp.right != null ){
                    queue.offer( tmp.right ) ;
                }
            }
        }
        return root ;
    }
}
