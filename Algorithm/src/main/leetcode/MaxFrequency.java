package main.leetcode;

import org.junit.Test;

import java.util.Arrays;

public class MaxFrequency {

    @Test
    public void test(){
        int[] nums = {9930,9923,9983,9997,9934,9952,9945,9914,9985,9982,9970,9932,9985,9902,9975,9990,9922,9990,9994,9937,9996,9964,9943,9963,9911,9925,9935,9945,9933,9916,9930,9938,10000,9916,9911,9959,9957,9907,9913,9916,9993,9930,9975,9924,9988,9923,9910,9925,9977,9981,9927,9930,9927,9925,9923,9904,9928,9928,9986,9903,9985,9954,9938,9911,9952,9974,9926,9920,9972,9983,9973,9917,9995,9973,9977,9947,9936,9975,9954,9932,9964,9972,9935,9946,9966} ;
        int k = 3056 ;
        int n = nums.length ;
        int[] prefix = new int[ 100001 ] ;
        int[] sorted = new int [n] ;
        for( int i = 0 ; i < n ; i ++ ){
            prefix[ nums[i] ] ++ ;
        }
        int max = 0 ;
        for( int i = 1 ; i < 100001 ; i ++ ){
            prefix[ i ] = prefix[i] + prefix[ i - 1 ] ;
            int cnt = 0 ;
            if( i - k >= 0 ){
                cnt = prefix[ i ] - prefix[ i - k - 1 ] ;
            }
            else{
                cnt = prefix[ i ] ;
            }
            if( cnt > max ){
                max = cnt ;
            }
        }
        System.out.println(max) ;
    }

    //题意理解错误
    public int maxFrequency1(int[] nums,int k){

        int n = nums.length ;
        int[] prefix = new int[ 100001 ] ;
        for( int i = 0 ; i < n ; i ++ ){
            prefix[ nums[i] ] ++ ;
        }
        int max = 0 ;
        for( int i = 1 ; i < 100001 ; i ++ ){
            prefix[ i ] = prefix[i] + prefix[ i - 1 ] ;
            int cnt = 0 ;
            if( i - k >= 0 ){
                cnt = prefix[ i ] - prefix[ i - k ] ;
            }
            else{
                cnt = prefix[ i ] ;
            }
            if( cnt > max ){
                max = cnt ;
            }
        }
        return max ;
    }

    //超出时间限制
    public int maxFrequency2( int[] nums,int k ){
        int n = nums.length ;
        int[] prefix = new int[n] ;
        Arrays.sort(nums) ;
        for( int i = 1 ; i < n ; i ++ ){
            prefix[ i ] = prefix[ i - 1 ] + ( nums[ i ] - nums[ i  - 1 ] ) * ( i  );
        }
        // System.out.println(Arrays.toString(nums)) ;
        // System.out.println(Arrays.toString(prefix)) ;
        int max = 1 ;
        for( int i = 0 ; i < n ; i ++ ){
            for( int j = i + 1 ; j < n ; j ++ ){
                int need = prefix[j] - prefix[i] - ( i  ) * ( nums[j] - nums[i] ) ;
                // System.out.println( i + "----" + j + "-------" + need ) ;
                if( need > k ){
                    break ;
                }
                if( j - i + 1 < max ){
                    continue ;
                }
                if( j - i + 1 > max ){
                    // System.out.println( i + "----" + j + "-------" + need ) ;
                    max = j - i + 1 ;
                }
            }
        }
        return max ;
    }

    public int maxFrequency( int[] nums , int k ){
        int n = nums.length ;
        int[] prefix = new int[n] ;
        Arrays.sort(nums) ;
        for( int i = 1 ; i < n ; i ++ ){
            prefix[ i ] = prefix[ i - 1 ] + ( nums[ i ] - nums[ i  - 1 ] ) * ( i  );
        }
        int max = 1 ;
        for( int i = 0 ; i < n ; i ++ ){
            int left = i  , right = n - 1 ;
            int mid = 0 ;
            int need = 0 ;
            if( n - i < max ){
                continue ;
            }
            while( left <= right ){
                mid = ( left + right ) / 2 ;
                need = prefix[mid] - prefix[i] - i * ( nums[mid] - nums[i]) ;
                if( need <= k ){
                    left = mid + 1 ;
                }
                else{
                    right = mid - 1 ;
                }
            }
            // if( need <= k && ( mid - i + 1 ) > max ){
            //     max = mid - i + 1 ;
            // }
            if( need <= k && ( left - i  ) > max ){
                max = left - i  ;
            }
        }
        return max ;
    }
}
