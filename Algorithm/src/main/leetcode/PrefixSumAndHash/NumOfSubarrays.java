import java.util.Map;

public class NumOfSubarrays{

    public int numOfSubarrays(int[] nums,int k){
        Map<Integer,Integer> map = new HashMap<Integer,Integer>() ;
        map.put(0,1) ;
        int sum = 0 ;
        int n = nums.length ;
        int rs = 0 ;
        for( int i = 0 ; i < n ; i ++ ){
            if( nums[i] % 2 == 1 ){
                sum = sum + 1 ;
            }
            if( map.containsKey( sum - k )){
                rs = rs + map.get( sum - k ) ;
            }
            map.put( sum , map.getOrDefault( sum , 0) + 1 ) ;
        }
        return rs ;
    }
}