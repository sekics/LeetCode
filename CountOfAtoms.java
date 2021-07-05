import java.util.HashMap;
import java.util.Map;

public class CountOfAtoms{

    public String countOfAtoms(String formula){
        Map<String,Integer> map = reversionCnt(formula) ;
        List<String> keys = new ArrayList(map.keySet());
        Collections.sort(keys);
        
        StringBuilder sb = new StringBuilder();
        for(String key : keys) {
            int count = map.get(key);
            sb.append(key);
            if (count > 1) {
                sb.append(count);
            }
        }
        return sb.toString();
    }

    public void multiMap(Map<String,Integer> map,int value ){
        for( Map.Entry<String,Integer> entry : map.entrySet() ){
            map.put(entry.getKey(),entry.getValue() * value ) ;
        }
    }

    public Map<String,Integer> CombineMap(Map<String,Integer> map,Map<String,Integer> remap){
        for( Map.Entry<String,Integer> entry : remap.entrySet() ){
            String key = entry.getKey() ;
            map.
            put( key , map.getOrDefault(key, 0) + entry.getValue() ) ;
        }
        return map ;
    }

    public Map<String,Integer> reversionCnt( String formula ){
        HashMap<String,Integer> map = new HashMap<>() ;
        if( formula == null || formula.length == 0 ){
            return map ;
        }
        int size = formula.length() ;
        char first = formula.charAt(0) ;
        if( first == '('){
            int cntParen = 1 ;
            int i ;
            for( i = 1 ; i < size ; i ++ ){
                if( formula.charAt(i) == '('){
                    cntParen ++ ;
                }
                else if( formula.charAt(i) == ')'){
                    cntParen -- ;
                }
                if( cntParen == 0 ){
                    break ;
                }
            }
            Map<String,Integer> map1 = reversionCnt(formula.substring(1, i)) ;
            int value = getValue( i + 1 ,formula) ;
            multiMap(map1, value);
            if( i == size ){
                return map1 ;
            }
            else{
                return CombineMap(map1,count(formula.substring(i))) ;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(first);
        int i = 1;
        int cnt = 0;
        while(i < len) {
            char c = formula.charAt(i);
            if (c >= 'a' && c <= 'z') {
                sb.append(c);
                i++;
            } else if (c >= '0' && c <= '9') {
                cnt *= 10;
                cnt += (c - '0');
                i++;
            } else {
                break;
            }
        }
        if (cnt == 0) {
            cnt = 1;
        }
        String name = sb.toString();
        map.put(name, map.getOrDefault(name, 0) + cnt);
        
        if (i == size ) {
            return map;
        }
        
        return combine(map, count(formula.substring(i)));
    }

    public int getValue(int j ,String formula){
        if( j < formula.length() ){
            int value = 0 ;
            while( j < formula.length() && formula.charAt(j) <= '9' && formula.charAt(j) >= '1' ){
                value = value * 10 + ( formula.charAt( j ) - '0' ) ;
                j ++ ;
            }
            return value == 0 ? 1 : value ;
        }
        else{
            return 1 ;
        }
    }
    public int Cnt(String formula,Map<String,Integer> map){
        StringBuilder sb = new StringBuilder() ;
        int n = formula.length() ;
        sb.append( formula.charAt( j ++ ) ) ;
        while( j < n && ( formula.charAt(j) ) >= 'a' && ( formula.charAt(j) <= 'z') ){
            sb.append( formula.charAt(j) ) ;
            j ++ ;
        }
        int value = getValue(formula) ;
        String str = sb.toString() ;
        map.put( str , map.getOrDefault(str, 0) + value ) ;
        return j ;
    }
}