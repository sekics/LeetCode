package main.leetcode.treetraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class HasPathSum {

        public boolean getSum( TreeNode root , int targetSum , int nowSum ){
            if( root != null ){
                boolean left = false ;
                boolean right = false ;
                if( root.left == null && root.right == null && targetSum == nowSum ){
                    return true ;
                }
                if( root.left != null ){
                    left = getSum(root.left ,targetSum,nowSum + root.left.val) ;
                }
                if( root.right != null ){
                    right = getSum(root.right,targetSum,nowSum + root.right.val) ;
                }
                return left || right ;
            }
            else{
                return false ;
            }
        }

    public boolean hasPathSum( TreeNode root , int targetSum ){
        if( root == null ){
            return false ;
        }
        boolean ans = false ;
        ans = getSum(root,targetSum,root.val) ;
        return ans ;
    }

    public void getPath( TreeNode root , int targetSum , int nowSum , LinkedList<Integer> tmp ){
        if( root != null ){
            if( root.left == null && root.right == null && nowSum == targetSum ){
                ans.add( new ArrayList<>(tmp)) ;
                return ;
            }
            if( root.left != null ){
                tmp.addFirst( root.left.val ); ;
                getPath( root.left , targetSum , nowSum + root.left.val , tmp ) ;
                tmp.removeLast() ;
            }
            if( root.right != null ){
                tmp.addFirst( root.right.val ) ;
                getPath( root.right , targetSum , nowSum + root.right.val , tmp) ;
                tmp.removeLast() ;
            }
            return ;
        }
        else{
            return ;
        }
    }
    List<List<Integer>> ans = new ArrayList<>() ;
    public List<List<Integer>> pathSum(TreeNode root,int targetSum){
        if( root == null ){
            return ans ;
        }
        LinkedList<Integer> tmp = new LinkedList<>() ;
        getPath(root,targetSum,0,tmp) ;
        return ans ;
    }
}
