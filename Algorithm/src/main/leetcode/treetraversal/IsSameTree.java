package main.leetcode.treetraversal;

public class IsSameTree {

    public boolean preOrder(TreeNode p , TreeNode q){
        if( p != null && q != null ){
            if( p.val != q.val ){
                return false ;
            }
            boolean left = preOrder( p.left , q.left ) ;
            boolean right = preOrder( p.right , q.right ) ;
            return left && right ;
        }
        else if( p == null && q == null ){
            return true ;
        }
        else{
            return false ;
        }
    }
    public boolean isSameTree(TreeNode p , TreeNode q){
        boolean ans = preOrder(p,q) ;
        return ans ;
    }
}
