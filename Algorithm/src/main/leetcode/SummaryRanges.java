package main.leetcode;

import java.util.*;

public class SummaryRanges {

    private int[] records ;
    private Set<Integer> starts;

    public SummaryRanges() {
        this.records = new int[10002] ;
        for( int i = 0 ; i < 10002 ; i ++ ){
            this.records[i] = 0 ;
        }
        this.starts = new HashSet<>() ;
    }

    public void addNum(int val) {
        if( this.records[val] == 0 ){
            this.records[val] = this.records[ val + 1 ] + 1 ;
            this.starts.add(val) ;
            if( this.records[ val + 1 ] != 0 ){
                this.starts.remove(val + 1 ) ;
                this.records[ val + this.records[val] - 1 ] = this.records[val] ;
            }
            if( val !=0 && this.records[ val - 1 ] != 0 ){
                int start = val - this.records[ val - 1 ] ;
                this.starts.remove(val) ;
                this.records[start] = this.records[start] + this.records[val] ;
                this.records[start + this.records[start] - 1 ] = this.records[start] ;
            }
        }
    }

    public int[][] getIntervals() {
        List<Integer> ss = new ArrayList<>(starts) ;
        Collections.sort(ss);
        int[][] ans = new int[ss.size()][2] ;
        for( int i = 0 ; i <ss.size() ; i ++ ){
            ans[i][0] = ss.get(i) ;
            ans[i][1] = ss.get(i) + this.records[ss.get(i)] - 1 ;
        }
        return ans ;
    }
}
