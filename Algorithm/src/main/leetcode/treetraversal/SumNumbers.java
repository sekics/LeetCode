package main.leetcode.treetraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SumNumbers {

    public void DFS( TreeNode root , List<Integer> list , int preVal ){
        if( root != null ){
            if( root.left != null ){
                DFS( root.left , list , preVal * 10 + root.val ) ;
            }
            if( root.right != null ){
                DFS( root.right , list , preVal * 10 + root.val ) ;
            }
            if( root.right == null && root.left == null ){
                list.add( preVal * 10 + root.val ) ;
            }
        }
    }
    public int sumNumbers(TreeNode root){
        List<Integer> list = new ArrayList<>() ;
        DFS(root,list,0) ;
        int sum = 0 ;
        for( int i = 0 ; i < list.size() ; i ++ ){
            sum += list.get(i) ;
        }
        return sum ;
    }
}
