package main.leetcode.buildtree;

import main.leetcode.treetraversal.TreeNode;

public class BuildTree {

    public TreeNode preInBuild(int[] preorder, int pl , int pr , int[] inorder , int il , int ir ){
        int val = preorder[pl] ;
        TreeNode left = null ;
        TreeNode right = null ;
        int i = 0 ;
        for( i = il ; i <= ir ; i ++  ){
            if( inorder[i] == val ){
                break ;
            }
        }
        if ( i - il >= 0 && i - 1 >= il ){
            left = preInBuild(preorder,pl + 1 ,pl + i - il , inorder , il , i - 1 ) ;
        }
        if( pr >= pl + 1 + i - il && ir >= i + 1 ){
            right = preInBuild(preorder, pl + 1 + i - il , pr , inorder , i + 1 ,ir ) ;
        }
        return new TreeNode(val,left,right) ;
    }
    public TreeNode buildTree(int[] preorder,int[] inorder){
        TreeNode root = preInBuild(preorder,0,preorder.length - 1 ,inorder,0,inorder.length - 1 ) ;
        return root ;
    }
}
