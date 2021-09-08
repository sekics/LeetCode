package main.leetcode.dynamicprogramming;

public class MinDistance {

    public int minDistance( String word1 , String word2 ){
        int m = word1.length() , n = word2.length() ;
        int[][] dp = new int[ m + 1 ][ n + 1 ] ;
        for( int i = 0 ; i <= n ; i ++ ){
            dp[0][i] = i ;
        }
        for( int i = 0 ; i <= m ; i ++ ){
            dp[i][0] = i ;
        }
        //dp[i][j]表示word1的前i个字符和word2的前j个字符的编辑距离
        for( int i = 1 ; i <= m ; i ++ ){
            for( int j = 1 ; j <= n ; j ++ ){
                if( word1.charAt( i - 1 ) != word2.charAt( j - 1 ) ){
                    //dp[ i - 1 ][ j ]是在word1的前i - 1 到 word2的前j个字符的编辑距离的基础上再加一个字符，使得word1的前i个字符与word2的前J个相等，本质是word1删除一个字符
                    //dp[ i ][ j - 1 ]是在word1的前i到word2的前j - 1 个字符的编辑距离的基础上，删除掉word2的一个，本质是在word1中添加一个字符
                    //dp[ i - 1 ][ j - 1 ]是在此前的基础上再修改i,j中的一个使得他们相等
                    dp[i][j] = Math.min( dp[ i - 1 ][j] , Math.min( dp[ i ][ j - 1 ] , dp[ i - 1 ][ j - 1 ] ) ) + 1 ;
                }
                else{
                    dp[ i ][ j ] = Math.min( dp[ i - 1 ][j] , Math.min( dp[ i ][ j - 1 ] , dp[ i - 1 ][ j - 1 ] - 1 ) ) + 1 ;
                }
            }
        }
        return dp[m][n] ;
    }
}
