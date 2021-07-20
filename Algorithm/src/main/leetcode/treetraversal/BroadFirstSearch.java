package main.leetcode.treetraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BroadFirstSearch {

    public List<List<Integer>> levelOrder(TreeNode root){
        List<List<Integer>> rs = new ArrayList<>() ;
        if( root == null ){
            return rs ;
        }
        Queue<TreeNode> queue = new LinkedList<>() ;
        queue.offer(root) ;
        while( !queue.isEmpty() ){
            int size = queue.size() ;
            List<Integer> level = new ArrayList<>() ;
            TreeNode tmp ;
            for( int i = 0 ; i < size ; i ++ ){
                tmp = queue.poll() ;
                level.add(tmp.val) ;
                if( tmp.left != null ){
                    queue.offer( tmp.left ) ;
                }
                if( tmp.right != null ){
                    queue.offer( tmp.right ) ;
                }
            }
            rs.add(level) ;
        }
        return rs ;
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root){
        List<List<Integer>> rs = new ArrayList<>();
        if( root == null ){
            return rs ;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root) ;
        while( !queue.isEmpty() ){
            int size = queue.size() ;
            List<Integer> level = new ArrayList<>() ;
            TreeNode tmp ;
            for( int i = 0 ; i < size ; i ++ ){
                tmp = queue.poll() ;
                level.add(tmp.val) ;
                if( tmp.left != null ){
                    queue.offer( tmp.left ) ;
                }
                if( tmp.right != null ){
                    queue.offer( tmp.right ) ;
                }
            }
            rs.add(0,level ) ;
        }
        return rs ;
    }
}
