import java.util.Map;

public class SubarraySum{


    public int subarraySum(int[] nums,int k){
        int n = nums.length ;
        int rs = 0 ;
        int sum = 0 ;
        Map<Integer,Integer> map = new HashMap<>() ;
        map.put(0,1) ;
        for( int i = 0 ; i < n ; i ++ ){
            sum = sum + nums[i] ;
            if( map.containsKey( sum - k ) ){
                rs = rs + map.get( sum - k ) ;
            }
            map.put( sum , map.getOrDefault(sum, 0 ) + 1 ) ; 
        }
        return rs ;
    }

}
