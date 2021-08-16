package main.leetcode;

public class MinNonZeroProduct {

    int MOD = 1000000007 ;

    //递归快速幂法因为会取模，所以会出错
    public long quickPow( long p , long n ){
        if( n == 0 ){
            return 1 ;
        }
        else{
            long res = quickPow( p , n / 2 ) % MOD ;
            res = ( res * res ) % MOD ;
            res = n % 2 == 0 ? res : ( res * p ) % MOD ;
            return res  ;
        }
    }

    public long quick_pow(long a, long b){
        long ret = 1;
        while (b > 0){
            if((b & 1) == 1) ret = ret * a % MOD;
            a = a * a % MOD;
            b >>= 1; // b /= 2;
        }
        return ret % MOD;
    }

    public int minNonZeroProduct(int p) {
        long n = ( 1L << p ) - 1 ;
        long pairs = n / 2 ;
        long res = ( ( n % MOD ) * quick_pow( (n - 1 ) % MOD , pairs)) % MOD ;
        return ( int ) res ;
    }
}
