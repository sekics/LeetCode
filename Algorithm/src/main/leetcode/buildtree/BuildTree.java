package main.leetcode.buildtree;

import main.leetcode.treetraversal.TreeNode;

import java.util.HashMap;
import java.util.Map;

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

    public TreeNode inPostBuild( int[] inorder , int il , int ir , int[] postorder , int pl , int pr ){
        int val = postorder[ pr ] ;
        TreeNode left = null ;
        TreeNode right = null ;
        int i = map.get(val) ;
        int index = pl + i - 1 - il ;
        if( i - 1 >= il && index >= pl ){
            left = inPostBuild( inorder , il , i - 1 , postorder , pl , index ) ;
        }
        if( ir >= i + 1 && pr - 1 >= index + 1 ){
            right = inPostBuild( inorder , i + 1 , ir , postorder , index + 1 , pr - 1 ) ;
        }
        return new TreeNode( val , left ,right ) ;
    }

    Map<Integer,Integer> map = new HashMap<Integer,Integer>() ;

    public TreeNode buildTree2(int[] inorder,int[] postorder){
        for( int i = 0 ; i < inorder.length ; i ++ ){
            map.put(inorder[i],i) ;
        }
        TreeNode root = inPostBuild( inorder , 0 , inorder.length - 1 , postorder , 0, postorder.length - 1 ) ;
        return root ;
    }
}
