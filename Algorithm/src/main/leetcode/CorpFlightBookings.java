package main.leetcode;

public class CorpFlightBookings {

    public int[] corpFlightBookings( int[][] bookings , int n ){
        int[] ans = new int[ n ] ;
        for( int i = 0 ; i < bookings.length ; i ++ ){
            int start = bookings[i][0] - 1 ;
            int end = bookings[i][1] - 1 ;
            int num = bookings[i][2] ;
            for( int j = start ; j <= end ; j ++ ){
                ans[j] += num ;
            }
        }
        return ans ;
    }
}
