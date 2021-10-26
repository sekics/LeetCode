package main.leetcode;

public class Divide {

    public int divide(int dividend,int divisor){
        if( dividend == Integer.MIN_VALUE && divisor == -1 ){
            return Integer.MAX_VALUE ;
        }
        boolean sign = ( dividend > 0 && divisor > 0 ) || ( dividend < 0 && dividend < 0 ) ;

        dividend = -Math.abs(dividend) ;
        divisor = -Math.abs(divisor) ;

        int result = 0 ;
        while( dividend > divisor ){
            int tmp = divisor ;
            int c = 1 ;
            while( dividend - tmp >= tmp ){
                tmp = tmp << 1 ;
                c = c << 1 ;
            }
            dividend -= tmp ;
            result += c ;
        }
        return sign ? result : -result ;
    }
}
