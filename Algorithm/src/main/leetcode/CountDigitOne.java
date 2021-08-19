package main.leetcode;

import java.util.Arrays;

public class CountDigitOne {

    public int[] getBase( int n ){
        int[] ans = new int[2] ;
        ans[1] = 10 ;
        while( n / ans[1] > 0 ){
            ans[1] *= 10 ;
            ans[0] ++ ;
        }
        ans[1] /= 10 ;
        return ans ;
    }
    public int count(int n ,int[] table){
        if( n == 0 ){
            return 0 ;
        }
        else if( n < 10 ){
            return 1 ;
        }
        else{
            int[] base = getBase(n) ;
            int ans = 0 ;
            int p = n / base[1] ;
            ans = p == 1 ? n - base[1] + 1 : base[1] ;
            ans = ans + table[base[0]] * p + count( n % base[1],table) ;
            return ans ;
        }
    }

    public int countDigitOne(int n) {
        int[] table = new int[11] ;
        table[1] = 1 ;
        int base = 10 ;
        for( int i = 2 ; i < 11 ; i ++ ){
            table[i] = base + table[ i - 1 ] * 10 ;
            base = base * 10 ;
        }
        if( n == 1e9){
            return table[9] + 1 ;
        }
        int ans = count(n,table) ;
        return ans ;
    }
}
