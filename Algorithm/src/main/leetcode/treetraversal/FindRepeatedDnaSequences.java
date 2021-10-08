package main.leetcode.treetraversal;

import java.util.*;

//class TrieNode{
//    boolean isEnd ;
//    String sequence ;
//    TrieNode[] children ;
//    public TrieNode(boolean isEnd){
//        this.isEnd = isEnd ;
//        children = new TrieNode[4] ;
//    }
//    public TrieNode(boolean isEnd,String sequence){
//        this.sequence = sequence ;
//        children = new TrieNode[4] ;
//    }
//}
class TrieNode{
    TrieNode[] children ;
    public TrieNode(){
        children = new TrieNode[4] ;
    }
}
class Trie{
    TrieNode[] root ;
    Map<Character,Integer> charToInt ;
    public Trie(){
        root = new TrieNode[4] ;
        charToInt = new HashMap<>() ;
        char[] chars = {'A','C','G','T'} ;
        for( int i = 0 ; i < chars.length ; i ++ ){
            this.charToInt.put( chars[i] , i ) ;
        }
    }
    public boolean search(String sequence){
        if( sequence.length() < 10 ){
            return false ;
        }
        int idx = this.charToInt.get( sequence.charAt(0) ) ;
        if( root[idx] == null ){
            root[idx] = new TrieNode() ;
        }
        TrieNode st = root[idx] ;
        TrieNode parent = null ;
        for( int i = 1 ; i < 10 ; i ++ ){
            idx = this.charToInt.get( sequence.charAt(i) ) ;
            parent = st ;
            st = st.children[idx] ;
            if( st == null ){
                st = new TrieNode() ;
                parent.children[idx] = st ;
                if( i == 9 ){
                    return false ;
                }
            }
            else{
                if( i == 9 ){
                    return true ;
                }
            }
        }
        return false ;
    }
}
//class Trie{
//    TrieNode[] root ;
//    Map<Character,Integer> charToInt ;
//    public Trie(){
//        root = new TrieNode[4] ;
//        charToInt = new HashMap<>() ;
//        char[] chars = {'A','C','G','T'} ;
//        for( int i = 0 ; i < chars.length ; i ++ ){
//            this.charToInt.put( chars[i] , i ) ;
//        }
//    }
//    public boolean search(String sequence){
//        if( sequence.length() < 10 ){
//            return false;
//        }
//        char ch = sequence.charAt(0) ;
//        int idx = this.charToInt.get(ch) ;
//        if( root[idx] == null ){
//            root[ idx ] = new TrieNode(false) ;
//        }
//        TrieNode st = root[ idx ] ;
//        TrieNode parent = null ;
//        for( int i = 1 ; i < 10 ; i ++ ){
//            idx = this.charToInt.get( sequence.charAt(i) ) ;
//            parent = st ;
//            // System.out.println(parent) ;
//            st = st.children[idx] ;
//            // System.out.println(st) ;
//            if( st == null ){
//                if( i == 9 ){
//                    st = new TrieNode(true,sequence) ;
//                    parent.children[idx] = st ;
//                    return false ;
//                }
//                else{
//                    st = new TrieNode(false) ;
//                    parent.children[idx] = st ;
//                }
//            }
//            else{
//                if( i == 9 ){
//                    return true ;
//                }
//            }
//        }
//        return false ;
//    }
//}
public class FindRepeatedDnaSequences {

    public List<String> findRepeatedDnaSequences(String s){
        //自己创建字典树
        int n = s.length() ;
        Set<String> ans = new HashSet<>() ;
        Trie dic = new Trie() ;
        for( int i = 0 ; i <= n - 10 ; i ++ ){
            String parttern = s.substring( i ,  i + 10 ) ;
            if( dic.search(parttern) == true ){
                ans.add( parttern ) ;
            }
        }
        return new ArrayList<>(ans) ;
//        Map<String,Integer> records = new HashMap() ;
//        Set<String> tmp = new HashSet() ;
//        int n = s.length() ;
//        for( int i = 0 ; i <= n - 10 ; i ++ ){
//            String pattern = s.substring( i , i + 10 ) ;
//            if( records.get(pattern) == null ){
//                records.put( pattern , 1 ) ;
//            }
//            else{
//                tmp.add(pattern) ;
//            }
//        }
//        return new ArrayList(tmp) ;
    }
}
