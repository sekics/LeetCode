package test;

import org.junit.Test;

import java.util.Arrays;

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

    @Test
    public void testStringBuilder(){
        byte[] bytes= { 0x24 , 0x47 , 0x4E , 0x52 , 0x4D , 0x43 , 0x2C , 0x30 , 0x30 , 0x30 ,
                0x30 , 0x30 , 0x30 , 0x30 , 0x30 , 0x30 , 0x2C , 0x56 , 0x2C , 0x30 , 0x30 ,
                0x30 , 0x30 , 0x30 , 0x30 , 0x30 , 0x30 , 0x30 , 0x30 , 0x2C , 0x30 , 0x2C ,
                0x30 , 0x30 , 0x30 , 0x30 , 0x30 , 0x30 , 0x30 , 0x30 , 0x30 , 0x30 , 0x30 ,
                0x2C , 0x30 , 0x2C , 0x30 , 0x30 , 0x30 , 0x30 , 0x30 , 0x2C , 0x30 , 0x30 ,
                0x30 , 0x30 , 0x30 , 0x2C , 0x30 , 0x30 , 0x30 , 0x30 , 0x30 , 0x30 , 0x2C ,
                0x4F , 0x4B , 0x2A , 0x30 , 0x37 , 0x3A , 0x37} ;
        StringBuilder sb = new StringBuilder() ;
        System.out.println( bytes.length );
        System.out.println(Arrays.toString(bytes));
        for( int i = 0 ; i < bytes.length ; i ++ ){
            sb.append( (char) bytes[i]) ;
        }
        System.out.println( sb.toString() );
    }
}
