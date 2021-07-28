package main.leetcode.treetraversal;

import java.util.*;

public class DistanceK {
    
    public List<Integer> distanceK(TreeNode root,TreeNode target,int k){
        int[][] graph = new int[501][501] ;
        Queue<TreeNode> queue = new LinkedList<>() ;
        queue.offer(root) ;
        List<Integer> all = new ArrayList<>() ;
        while( !queue.isEmpty() ){
            int size = queue.size() ;
            for( int i = 0 ; i < size ; i ++ ){
                TreeNode tmp = queue.poll() ;
                all.add(tmp.val) ;
                if( tmp.left != null ){
                    queue.offer(tmp.left) ;
                    graph[tmp.left.val][tmp.val] = 1 ;
                    graph[tmp.val][tmp.left.val] = 1 ;
                }
                if( tmp.right != null ){
                    queue.offer(tmp.right) ;
                    graph[tmp.right.val][tmp.val] = 1 ;
                    graph[tmp.val][tmp.right.val] = 1 ;
                }
            }
        }
        Set<Integer> res = new HashSet<>() ;
        Set<Integer> seen = new HashSet<>() ;
        Queue<Integer> dispose = new LinkedList<>() ;
        seen.add(target.val) ;
        dispose.add(target.val) ;
        int level = 0 ;
        while( !dispose.isEmpty() ){
            int size = dispose.size() ;
            level ++ ;
            for( int i = 0 ; i < size ; i ++ ){
                int start = dispose.poll() ;
                for( int j = 0 ; j < all.size() ; j ++ ){
                    int end = all.get(j) ;
                    if( graph[start][end] != 0 && !seen.contains(end) ){
                        dispose.offer(end) ;
                        if( level == k ){
                            res.add(end) ;
                        }
                    }
                }
            }
        }
        return new ArrayList<>(res) ;
    }
}
