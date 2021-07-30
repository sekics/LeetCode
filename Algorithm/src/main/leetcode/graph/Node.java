package main.leetcode.graph;

import java.util.ArrayList;
import java.util.List;

public class Node {
    public int val ;
    public List<Node> neighbors ;
    public Node(){
        this.val = 0 ;
        this.neighbors = new ArrayList<>() ;
    }
    public Node(int _val){
        this.val = _val ;
        this.neighbors = new ArrayList<>() ;
    }
    public Node(int _val,ArrayList<Node> _neighbors){
        this.val = _val ;
        this.neighbors = _neighbors ;
    }
}
