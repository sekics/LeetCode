package test;

import org.junit.Test;

public class TestQuickPow {
    int MOD = 1000000007 ;

    public long quick_pow( long a , long b ){
        long res = 1 ;
        while( b > 0 ){
            if( ( b & 1 ) == 1 ) {
                res = (res * a) % MOD;
            }
//            if( b == 1 ){
//                System.out.println( b + "   " + ( b & 1 ) + "   " + a ) ;
//                res = ( res * a ) % MOD ;
//            }
            a = ( a * a ) % MOD ;
            b >>= 1 ;
            System.out.println( res ) ;
        }
        return res % MOD ;
    }

    public long quickPow( long a , long b ){
        if( b == 0 ){
            return 1 ;
        }
        else{
            long res = quickPow( a , b / 2  ) % MOD ;
            res = ( res * res ) % MOD ;
            res = b % 2 == 0 ? res : (res * a) % MOD ;
            System.out.println( "res : " + b + "   "  + res ) ;
            return res ;
        }
    }

    @Test
    public void test(){
        int n = 64 ;
//        System.out.println(quick_pow(2,n) + "   " + quickPow(2,n)) ;
        long p = quick_pow(2,n) ;
        System.out.println( quick_pow( p % MOD , p ) + " " + quickPow( p % MOD , p ) ) ;
    }
}
