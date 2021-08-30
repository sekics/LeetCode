package main.leetcode;

import java.util.Random;

public class PickIndex {


    private int[] prob ;
    private Random random ;
    private int n ;

    public PickIndex(int[] w) {
        this.n = w.length ;
        this.prob = new int[ this.n ] ;
        this.prob[0] = w[0] ;
        for( int i = 1 ; i < this.n ; i ++ ){
            this.prob[i] = this.prob[ i - 1 ] + w[i] ;
        }
        random = new Random() ;
    }

    public int pickIndex() {
        int generate = new Random().nextInt( this.prob[ this.n - 1 ] ) + 1 ;
        int left = 0 , right = this.n - 1 ;
        while( left < right ){
            int mid = ( right - left ) / 2 + left ;
            if( this.prob[mid] < generate ){
                left = mid + 1 ;
            }
            else if( this.prob[mid] > generate){
                right = mid ;
            }
            else{
                left = mid ;
                break ;
            }
        }
        return left ;
    }

}
