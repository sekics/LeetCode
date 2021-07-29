package main.leetcode.treetraversal;

public class HasPathSum {

        public boolean getSum( TreeNode root , int targetSum , int nowSum ){
//            if( targetSum == nowSum ){
//                return true ;
//            }
//            else
            if( targetSum < nowSum ){
                return false ;
            }
            else{
                boolean left = false ;
                boolean right = false ;
                if( root.left == null && root.right == null && targetSum == nowSum ){
                    return false ;
                }
                if( root.left != null ){
                    left = getSum(root.left ,targetSum,nowSum + root.left.val) ;
                }
                if( root.right != null ){
                    right = getSum(root.right,targetSum,nowSum + root.right.val) ;
                }
                return left || right ;
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
}
