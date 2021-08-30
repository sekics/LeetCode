package main.leetcode.DFS;

import java.util.Arrays;

public class MinSessions {

    int[] tasks_ ;
    int s_ ;
    int ans = 15 ;

    //有问题
    public int minSessionsGreedy( int[] tasks , int sessionTime ){
        Arrays.sort( tasks );
        int n = tasks.length ;
        int left = 0 , right = n - 1 ;
        int ans = 0 ;
        while( left <= right ){
            int nowRemain = sessionTime ;
            while( tasks[right] <= nowRemain ){
                nowRemain -= tasks[right] ;
                right -- ;
            }
            while( tasks[left] <= nowRemain ){
                nowRemain -= tasks[left] ;
                left ++ ;
            }
            ans ++ ;
        }
        return ans ;
    }

    public boolean isOk( int[] cnt){
        for( int i = 0 ; i < cnt.length ; i ++ ){
            if( cnt[i] > 0 ){
                return false ;
            }
        }
        return true ;
    }

    public boolean isContinue( int[] cnt , int nowRemain ){
        for( int i = 1 ; i < cnt.length ; i ++ ){
            if( cnt[i] > 0 && nowRemain >= i ){
                return true ;
            }
        }
        return false ;
    }

    int[] cnt_ ;
    int max ;
    public void DFS( int[] cnt ,int nowIndex ,int nowSum , int nowReamin ){
        if( nowIndex == 0 || nowIndex > nowReamin ){
            if( nowSum > max ){
                cnt_ = cnt.clone() ;
            }
        }
        else{
            for( int i = nowIndex ; i >= 1 ; i -- ){

                if( cnt[i] > 0 && nowReamin > i ){
                    cnt[i] -- ;
                    DFS( cnt , i , nowSum + i , nowReamin - i ) ;
                }
            }
        }
    }

    public int minSessions( int[] tasks , int sessionTime ){
        int n = tasks.length ;
        int[] cnt = new int[11] ;
        for( int i = 0 ; i < n ; i ++ ){
            cnt_[ tasks[i] ] ++ ;
        }
        int ans = 0 ;

        while( isOk(cnt) ){
            cnt = cnt_ ;
            max = 0 ;
            DFS( cnt , 10 , 0 , sessionTime ) ;
//            int nowRemain = sessionTime ;
//            int max = Integer.MAX_VALUE ;
//            while( isContinue(cnt,nowRemain) ){
//
//                int nowReamin = sessionTime ;
//                DFS( cnt,10, 0 , nowReamin ) ;
//
//            }
            ans ++ ;
        }
        return ans ;
    }
}
