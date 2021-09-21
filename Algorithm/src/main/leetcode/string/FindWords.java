package main.leetcode.string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindWords {

    public class TrieNode{
        TrieNode[] child ;
        String word ;
        public TrieNode(){
            child = new TrieNode[26] ;
            word = "" ;
        }
    }

    public class Trie{

        TrieNode[] root ;

        public Trie(){
            this.root = new TrieNode[26] ;
        }

        public void insert( String str ){
            char start = str.charAt(0) ;

            if( root[ start - 'a' ] == null ){
                root[ start - 'a' ] = new TrieNode() ;
            }
            if( str.length() == 1 ){
                root[ start - 'a' ].word = str ;
                return ;
            }
            TrieNode tmp = root[ start - 'a' ] ;
            for( int i = 1 ; i < str.length() ; i ++ ){
                char ch = str.charAt( i ) ;
                if( tmp.child[ ch - 'a' ] == null ){
                    tmp.child[ ch - 'a' ] = new TrieNode() ;
                }
                if( i == str.length() - 1 ){
                    tmp.child[ ch - 'a' ].word = str ;
                }
                tmp = tmp.child[ ch - 'a' ] ;
            }
        }

        // public boolean isContain( String str ){
        //     TrieNode tmp = root[ str.charAt(0) - 'a' ] ;
        //     for( int i = 1 ; i < str.length() ; i ++ ){
        //         if( tmp == null ){
        //             return false ;
        //         }
        //         tmp = tmp.child[ str.charAt(i) - 'a' ];
        //     }
        //     return true ;
        // }

    }

    public void DFS( char[][] board , int x , int y , TrieNode trieNode , Set<String> ans){

        if( trieNode == null ){
            return ;
        }
        else if( !"".equals( trieNode.word) ){
            ans.add( trieNode.word ) ;
        }
        char ch = board[x][y] ;
        board[x][y] = '#' ;
        for (int[] dir : dirs) {
            int newX = x + dir[0] , newY = y + dir[1] ;
            if( newX >= 0 && newX < board.length && newY >= 0 && newY < board[0].length && board[ newX ][ newY ] != '#'){
                DFS( board , newX , newY , trieNode.child[ board[ newX ][ newY ] - 'a' ] , ans ) ;
            }
        }
        board[x][y] = ch ;
    }

    int[][] dirs = {{ -1 , 0 } , { 1 , 0 } , { 0 , -1 } , { 0 , 1 } } ;
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie() ;
        for (String word : words) {
            trie.insert(word);
        }
        int m = board.length , n = board[0].length ;
        Set<String> ans = new HashSet<>() ;
        for( int i = 0 ; i < m ; i ++ ){
            for( int j = 0 ; j < n ; j ++ ){
                DFS( board , i , j , trie.root[ board[i][j] - 'a' ] , ans ); ;
            }
        }
        return new ArrayList<>(ans) ;
    }
}
