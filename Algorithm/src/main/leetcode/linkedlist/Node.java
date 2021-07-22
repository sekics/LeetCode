package main.leetcode.linkedlist;

public class Node {
    public int val ;
    public Node next ;
    public Node random ;
    public Node( int val ){
        this.val = val ;
        this.next = null ;
        this.random = null ;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public void setRandom(Node random ){
        this.random = random ;
    }
}
