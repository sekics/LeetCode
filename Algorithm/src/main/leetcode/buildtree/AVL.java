package main.leetcode.buildtree;

public class AVL {

    public int getHight( TreeNode root ){
        if( root == null ){
            return 0 ;
        }
        return 1 + Math.max( getHight(root.left) , getHight(root.right) ) ;
    }

    public TreeNode leftRotation(TreeNode root){
        TreeNode tmp = root.right.left ;
        root.left.right = root ;
        root.right = tmp ;
        return root ;
    }
    public TreeNode rightRotation(TreeNode root){
        TreeNode tmp = root.left.right ;
        root.left.right = root ;
        root.left = tmp ;
        return root.left ;
    }
    public TreeNode leftRightRotation(TreeNode root){
        root.left = leftRotation(root.left) ;
        return rightRotation(root) ;
    }
    public TreeNode rightLeftRotation(TreeNode root){
        root.right = rightRotation(root.right) ;
        return leftRotation(root) ;
    }
    public TreeNode buildAVL(TreeNode root, int val ){
        if( root == null ){
            root = new TreeNode(val) ;
            return root;
        }
        else if( val <= root.val ){
            root.left = buildAVL( root.left , val ) ;
        }
        else{
            root.right = buildAVL( root.right , val ) ;
        }
        if( Math.abs( getHight(root.left) - getHight(root.right)) >= 2 ){
            //左节点失衡
            if( getHight(root.left) > getHight( root.right) ){
                //左左右
                if( root.left.val < val ){
                    root = leftRightRotation(root) ;
                }
                //左左左
                else{
                    root = rightRotation(root) ;
                }
            }
            //右节点失衡
            else{
                //右右右
                if( root.right.val < val ){
                    root = leftRotation(root) ;
                }
                //右右左{
                else{
                    root = rightLeftRotation(root) ;
                }
            }
        }
        return root ;
    }
    public TreeNode sortedArrayToBST(int[] nums){
        TreeNode root = null ;
        for( int i = 0 ; i < nums.length ; i ++ ){
            root = buildAVL(root,nums[i]) ;
        }
        return root ;
    }
}
