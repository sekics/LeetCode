package main.leetcode.buildtree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class IsBalanced {

    public int getHeight( TreeNode root ){
        if( root == null ){
            return 0 ;
        }
        else{
            return Math.max( getHeight(root.left) , getHeight(root.right) ) + 1 ;
        }
    }
    public boolean isBalanced(TreeNode root ){
        Stack<TreeNode> stack = new Stack<>() ;
        Queue<TreeNode> queue = new LinkedList<>() ;
        queue.offer(root) ;
        while( !queue.isEmpty() ){
            int size = queue.size() ;
            for( int i = 0 ; i < size ; i ++ ){
                TreeNode tmp = queue.poll() ;
                stack.push(tmp) ;
                if( tmp.left != null ){
                    queue.offer( tmp.left ) ;
                }
                if( tmp.right != null ){
                    queue.offer( tmp.right ) ;
                }
            }
        }
        while( !stack.isEmpty() ){
            TreeNode tmp = stack.pop() ;
            if( Math.abs( getHeight(tmp.left) - getHeight(tmp.right)) >= 2 ){
                return false ;
            }
        }
        return true ;
    }
}
