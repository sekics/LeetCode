package main.leetcode.treetraversal;

import java.util.ArrayList;
import java.util.List;

public class Flatten {

    public void preOrder(TreeNode root,List<TreeNode> nodes){
        if( root != null ){
            nodes.add(root) ;
            preOrder(root.left,nodes);
            preOrder(root.right,nodes);
        }
    }
    public void flatten(TreeNode root){
        List<TreeNode> nodes = new ArrayList<>() ;
        preOrder(root,nodes) ;
        TreeNode tmp = root ;
        for( int i = 1 ; i < nodes.size() ; i ++ ){
            tmp.left = null ;
            tmp.right = nodes.get(i) ;
            tmp = tmp.right ;
        }
    }
}
