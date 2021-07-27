package main.leetcode.treetraversal;

import java.util.*;

public class FindSecondMiniValue {

    public void preOrder(TreeNode root,Set<Integer> set){
        if( root != null ){
            preOrder(root.left,set);
            set.add(root.val) ;
            preOrder(root.right,set);
        }
    }
    public int findSecondMiniValu(TreeNode root){
        Set<Integer> set = new HashSet<>() ;
        preOrder(root,set) ;
        List<Integer> list = new ArrayList<>(set) ;
        Collections.sort(list);
        if( list.size() < 2 ){
            return -1 ;
        }
        else{
            return list.get(1) ;
        }
    }

    public void preOrderMin( TreeNode root , int minValue ){
        if( root != null ){
            preOrderMin( root.left , minValue ) ;
            if( root.val > minValue && root.val < secondMin ){
                secondMin = root.val ;
            }
            preOrderMin( root.right , minValue );
        }
    }

    long secondMin = Long.MAX_VALUE ;
    public int findSecondMinimumValue(TreeNode root) {
        int minValue = root.val ;
        preOrderMin( root , minValue ) ;
        if( secondMin == Long.MAX_VALUE ){
            return -1 ;
        }
        else{
            return (int) secondMin ;
        }
    }
}
