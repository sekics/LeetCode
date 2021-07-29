package main.leetcode.treetraversal;

public class MinDepth {

    int ans = Integer.MAX_VALUE ;
    public void getMinDepth( TreeNode root , int depth ){

        if( root != null ){
            if( root.left == null && root.right == null && depth < ans ){
                ans = depth ;
                return ;
            }
            else if( depth > ans ){
                return ;
            }
            else if( root.left != null ){
                getMinDepth( root.left,depth + 1 ) ;
            }
            else if( root.right != null ){
                getMinDepth( root.right , depth + 1 ) ;
            }
        }
    }
    public int minDepth(TreeNode root){
        if( root == null ){
            return 0 ;
        }
        getMinDepth( root , 1 ) ;
        return ans ;
    }
}
