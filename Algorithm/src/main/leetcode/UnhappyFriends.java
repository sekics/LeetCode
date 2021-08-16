package main.leetcode;

public class UnhappyFriends {

    public int unhappyFriends( int n , int[][] preferences,int[][] pairs ){
        int[] table = new int[n] ;
        for( int i = 0 ; i < pairs.length ; i ++ ){
            table[pairs[i][0]] = table[pairs[i][1]] ;
            table[pairs[i][1]] = table[pairs[i][0]] ;
        }
        int ans = 0 ;
        for( int i = 0 ; i < pairs.length ; i ++ ){
            int[] pair = pairs[i] ;
            for( int j = 0 ; j < 2 ; j ++ ){
                int nowIndex = pair[j] ;
                int lastIndex = pair[ j ^ 1 ] ;
                int[] preference = preferences[nowIndex] ;
                int k = 0 ;
                boolean unhappy = false ;
                while( preference[k] != lastIndex && !unhappy ){
                    int index = preference[k] ;
                    int pairIndex = table[index] ;
                    int[] indexPreference = preferences[index] ;
                    int nowPre = 0 , pairPre = 0 ;
                    for( int m = 0 ; m < n ; m ++ ){
                        if( indexPreference[m] == nowIndex ){
                            nowPre = m ;
                        }
                        if( indexPreference[m] == pairIndex ){
                            pairPre = m ;
                        }
                    }
                    if( nowPre > pairPre ){
                        unhappy = true ;
                    }
                }
                if( unhappy ){
                    ans ++ ;
                }
            }
        }
        return ans ;
    }
}
