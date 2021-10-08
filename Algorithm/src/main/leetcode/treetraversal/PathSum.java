package main.leetcode.treetraversal;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.Stack;

public class PathSum {

    int ans = 0 ;
    public void traverse( TreeNode root , int targetSum , Stack<Integer> stack ){
        if( root != null ){
            int nowSum = root.val ;
            if( !stack.isEmpty() ){
                nowSum = stack.peek() + root.val ;
            }
            stack.push( nowSum ) ;
            int n =stack.size() ;
            if( nowSum == targetSum ){
                ans ++ ;
            }
            for( int i = 0 ; i < n - 1 ; i ++ ){
                if( nowSum - stack.get(i) == targetSum ){
                    ans ++ ;
                }
            }

            if( root.left != null ){
                traverse( root.left , targetSum , stack ) ;
            }
            if( root.right != null ){
                traverse( root.right , targetSum , stack );
            }
            stack.pop() ;
        }
    }
    public int PathSum( TreeNode root , int targetSum ){
        Stack<Integer> stack = new Stack<Integer>() ;
        traverse( root , targetSum , stack ) ;
        return ans ;
    }
}
