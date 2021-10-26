package main.leetcode.string;

import java.util.List;

class TreeNode{
    public TreeNode[] children ;
    boolean isWord ;
}
public class WordDictionary {

    TreeNode root  ;
    public WordDictionary(){
        this.root = new TreeNode() ;
    }

    public void addWord(String word){
        TreeNode p = root ;
        for( int i = 0 ; i < word.length() ; i ++ ){
            int idx = word.charAt(i) - 'a' ;
            if( p.children[idx] == null ){
                p.children[idx] = new TreeNode() ;
            }
            p = p.children[idx];
        }
        p.isWord = true ;
    }

//    public boolean DFS( TreeNode node , String word , int index ){
//        if( index >= word.length() || node == null ){
//            return false ;
//        }
//        else if( index == word.length() - 1 && node != null ){
//            return true ;
//        }
//        else{
//            boolean ans = false ;
//            if( word.charAt(index) == '.' ){
//                for( int i = 0 ; i < 26 ; i ++ ){
//                    ans = ans || DFS( node.children[i] , word , index + 1 ) ;
//                }
//            }
//            else{
//                ans = DFS( node.children[ word.charAt( index ) - '0'], word , index + 1  ) ;
//            }
//            return ans ;
//        }
//    }
    public boolean DFS(String word , TreeNode now , int index ){
        int n = word.length() ;
        if( index == n ){
            return now.isWord ;
        }
        char ch = word.charAt(index) ;
        if( ch == '.'){
            for( int i = 0 ; i < 26 ; i ++ ){
                if( now.children[i] != null && DFS( word , now.children[i] , index + 1 ) ){
                    return true ;
                }
            }
            return false ;
        }
        else{
            int idx = ch - 'a' ;
            if( now.children[idx] == null ){
                return false ;
            }
            return DFS(word , now.children[idx], index + 1  ) ;
        }
    }
    public boolean search(String word){
        return DFS(word , root , 0 ) ;
    }
}
