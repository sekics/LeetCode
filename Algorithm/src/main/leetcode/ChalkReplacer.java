package main.leetcode;

public class ChalkReplacer {

    public int chalkReplacer( int [] chalk , int k ){
        int n = chalk.length ;
        long[] preSum = new long[n] ;
        preSum[0] = chalk[0] ;
        for( int i = 1 ; i < n ; i ++ ){
            preSum[i] = preSum[ i - 1 ] + chalk[i] ;
        }

        long remain = k % preSum[ n - 1 ] ;
        int left = 0 , right = n - 1 ;
        while( left <= right ){
            int mid = ( left + right ) / 2 ;
            if( preSum[ mid ] == remain ){
                return mid + 1 ;
            }
            else if( preSum[ mid ] > remain){
                right = mid - 1 ;
            }
            else{
                left = mid + 1 ;
            }
        }
        return ( left ) % n ;
    }

}
