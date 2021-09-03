package main.leetcode;

import java.util.Arrays;

public class SmallestK {

    public int[] smallestK( int[] arr , int k ){
        Arrays.sort( arr ) ;
        int[] ans = new int[k] ;
        for( int i = 0 ; i < k ; i ++ ){
            ans[i] = arr[i] ;
        }
        return ans ;
    }


    //如果所有的数为正或者知道数组中的最小值,这个方法需要多次遍历且知道最值
    public int[] smallestKOptim( int[] arr , int k ){
        int min = Integer.MAX_VALUE ;
        for( int i = 0 ; i < arr.length ; i ++ ){
            min = Math.min( min , arr[i] ) ;
        }
        if( min < 0 ){
            min = - min ;
        }
        int[] cnt = new int[ 100001 + min ] ;
        for( int i = 0 ; i < arr.length ; i ++ ){
            cnt[ arr[i] ] ++ ;
        }
        int i = 0 ;
        int index = 0 ;
        int[] ans = new int[k] ;
        while( i < k ){
            while( cnt[index] > 0 && i < k ){
                cnt[index] -- ;
                ans[ i ++ ] = index ;
            }
            index ++ ;
        }
        return ans ;
    }

    public int partition( int[] arr , int left , int right ){
        int pivot = arr[left] ;
        while( left < right ){
            while( arr[right] >= pivot && left < right){
                right -- ;
            }
            arr[left] = arr[right] ;
            while( arr[left] < pivot & left < right ){
                left ++ ;
            }
            arr[right] = arr[left] ;
        }
        arr[ left ] = pivot ;
        return left ;
    }

    int k_ ;
    public void quickSort( int[] arr , int left , int right ){
        while( left < right ){
            int base = partition( arr , left , right ) ;
            if( base ==  k_ ){
                return ;
            }
            quickSort( arr , left , base - 1 ) ;
            quickSort( arr , base + 1 , right ) ;
        }
    }
    //可以使用快排的变种
    public int[] smallestKQuickSort( int[] arr , int k ){
        k_ = k ;
        quickSort( arr , 0 , arr.length - 1 ) ;
        int[] ans = new int[k] ;
        for( int i = 0 ; i < k ; i ++ ){
            ans[i] = arr[i] ;
        }
        return ans ;
    }
}
