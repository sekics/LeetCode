import java.util.HashMap;
import java.util.Map;

public class NumSubarraysWithSum{

    //超内存：
    public int numSubarraysWithSum(int[] nums,int goal){
        int n = nums.length ;
        int[][] cnt = new int[n][n] ;
        for( int i = n - 1 ; i >= 0 ; i -- ){
            for( int j = i ; j < n ; j ++ ){
                if( i == j ){
                    cnt[i][j] = nums[i] ;
                }
                else{
                    cnt[i][j] = cnt[i][ j - 1 ] + cnt[j][j] ;
                }
            }
        }
        int rs = 0 ;
        for( int i = 0 ; i < n ; i ++ ){
            for( int j = i ; j < n ; j ++ ){
                if( cnt[i][j] == goal ){
                    rs ++ ;
                }
            }
        }
        return rs ;
    }

    public int numSubarraysWithSum2(int[] nums,int goal){
        int n = nums.length ;
        int[] cnt = new int[n] ;
        int rs = 0 ;
        int flag = n ;
        for( int i = n - 1 ; i >= 0 ; i -- ){
            for( int j = i ; j < flag ; j ++ ){
                if( i == j ){
                    cnt[i] = nums[i] ;
                }
                else if( cnt[ j - 1 ] <= goal){
                    cnt[j] = cnt[ j - 1 ] + nums[j] ;
                }
                else{
                    flag = j - 1 ;
                }
            }
            for( int j = i ; j < flag ; j ++ ){
                if( cnt[j] == goal ){
                    rs ++ ;
                }
            }
        }
        return rs ;
    }

    public int sumSubarraysWithSumHash(int[] nums,int goal){
        int n = nums.length ;
        Map<Integer,Integer> map = new HashMap<>() ;
        map.put(nums[0],0) ;
        sum = nums[0] ;
        int rs = 0 ;
        int preLen = 0 ;
        for( int i = 1 ; i < n ; i ++ ){
            sum = sum + nums[i] ;
            map.put(sum,i) ;
            if( sum - goal >= 0 && map.containsKey( sum - goal ) ){
                if( nums[i] == 0 ){
                    rs = rs + preL ;
                }
                else{
                    int j = map.get( sum - goal ) ;
                    int k = j + 1 ;
                    while( k < n && nums[k] == 0 ){
                        k ++ ;
                    }
                    rs = rs + k - j ;
                    preL = k - j ;
                }
            }
        }
        return rs ;
    }

    public int sumSuarraysWithSumHash2(int[] nums,int goal){
        int n = nums.length ;
        Map<Integer,Integer> map = new HashMap<>() ;
        int sum = 0 ;
        map.put(0,1) ;
        int rs = 0 ;
        for( int i = 0 ; i < n ; i ++ ){
            sum += nums[i] ;
            if( map.containsKey( sum - goal ) ){
                rs = rs + map.get( sum - goal ) ;
            }
            map.put(sum,map.getOrDefault(sum, 0) + 1 ) ;
        }
        return rs;
    }
}