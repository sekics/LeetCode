package main.leetcode.treetraversal;

import java.util.ArrayList;
import java.util.List;

public class IsValidBST {

    public void inOrder(TreeNode root,List<Integer> vals){
        if( root != null ){
            inOrder(root.left,vals) ;
            vals.add(root.val) ;
            inOrder(root.right,vals) ;
        }
    }
    public boolean isValidBST(TreeNode root){
        List<Integer> vals = new ArrayList<>() ;
        inOrder(root,vals) ;
        for( int i = 1 ; i < vals.size() ; i ++ ){
            if( vals.get(i) <= vals.get( i - 1 ) ){
                return false ;
            }
        }
        return true ;
    }
}
