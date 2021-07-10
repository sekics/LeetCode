import java.util.HashMap;
import java.util.List;

class TimeMap {

    private Map<String,List<Integer>> map ;
    private Map<String,String> keyTValue ;
    /** Initialize your data structure here. */
    public TimeMap() {
        this.map = new HashMap<>() ;
        this.keyTValue = new HashMap<>() ;
    }
    
    public void set(String key, String value, int timestamp) {
        List<Integer> list = map.get(key) ;
        if( list == null ){
            list = new ArrayList<>() ;
            map.put(key,list) ;
        }
        list.add(timestamp) ;
        StringBuilder sb = new StringBuilder(key) ;
        sb.append('.') ;
        sb.append(String.valueOf(timestamp)) ;
        keyTValue.put(sb.toString(),value) ;
    }
    
    public int getIndex(List<Integer> times,int timestamp){
        int left = 0 , right = times.size() - 1 ;
        int mid ;
        while( left <= right ){
            mid = ( left + right ) / 2 ;
            if( times.get(mid) == timestamp ){
                return times.get(mid) ;
            }
            else if( times.get(mid) < timestamp ){
                left = mid + 1 ;
            }
            else{
                right = mid - 1 ;
            }
        }
        while( right + 1 < times.size() && times.get( right + 1 ) < timestamp ){
            right ++ ;
        }
        if( right < 0 ){
            return -1 ;
        }
        return times.get(right) ;
    }

    public String get(String key, int timestamp) {
        List<Integer> times = map.get(key) ;
        if( times == null ){
            return "" ;
        }
        int index = getIndex(times,timestamp) ;
        // System.out.println(index) ;
        StringBuilder sb = new StringBuilder(key) ;
        sb.append('.') ;
        sb.append(String.valueOf(index)) ;
        String value = keyTValue.get(sb.toString()) ;
        return value == null ? "" : value ;
    }
}