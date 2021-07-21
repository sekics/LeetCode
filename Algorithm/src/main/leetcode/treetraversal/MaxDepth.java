package main.leetcode.treetraversal;

import java.util.LinkedList;
import java.util.Queue;

public class MaxDepth {

    public int maxDepthBFS( TreeNode root ){
        int depth = 0 ;
        Queue<TreeNode> queue = new LinkedList<TreeNode>() ;
        queue.offer( root ) ;
        TreeNode tmp ;
        while( !queue.isEmpty() ){
            int size = queue.size() ;
            depth ++ ;
            for( int i = 0 ; i < size ; i ++ ){
                tmp = queue.poll() ;
                if( tmp.left != null ){
                    queue.offer( tmp.left ) ;
                }
                if( tmp.right != null ){
                    queue.offer( tmp.right ) ;
                }
            }
        }
        return depth ;
    }

    public int DFS( TreeNode root ){
        if( root == null ){
            return 0 ;
        }
        else {
            int depth = Math.max( DFS(root.left) , DFS( root.right) ) + 1 ;
            return depth ;
        }
    }
    public int maxDepthDFS( TreeNode root ){
        int depth = DFS( root ) ;
        return depth ;
    }
}
