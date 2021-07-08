import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CountPairs{

    //超时
    public int countPairs(int[] deliciousness){
        if( deliciousness.length < 2 ){
            return 0 ;
        }
        int[] table = new int[22] ;
        table[0] = 1 ;
        for( int i = 1 ; i < 22 ; i ++ ){
            table[ i ] = table[ i - 1 ] * 2 ;
        }
        int mod = 1000000007 ;
        Map<Integer,List<Integer>> map = new HashMap<>() ;
        for( int i = 0 ; i < deliciousness.length ; i ++ ){
            List<Integer> list ;
            if( map.get(deliciousness[i]) == null ){
                list = new ArrayList<>() ;
                map.put(deliciousness[i],list) ;
            }
            list = map.get(deliciousness[i]) ;
            list.add(i) ;
            map.put(deliciousness[i],list) ;
        }
        int rs = 0 ;
        for( int i = 0 ; i < deliciousness.length ; i ++ ){
            for( int j = 0 ; j < 22 ; j ++ ){
                int remain = table[j] - deliciousness[i] ;
                List<Integer> indexes = map.get(remain) ;
                if( remain >= 0 && indexes != null ){
                    // System.out.println( i + " " + indexes.toString() ) ;
                    int cnt = 0 ;
                    while( cnt < indexes.size() && indexes.get(cnt) <= i ){
                        cnt ++ ;
                    }
                    rs = ( rs +  indexes.size() - cnt ) % mod ;
                }
            }
        }
        return rs ;
    }

    public int countParis2(int[] deliciousness){
        if( deliciousness.length < 2 ){
            return 0 ;
        }
        int[] table = new int[22] ;
        table[0] = 1 ;
        for( int i = 1 ; i < 22 ; i ++ ){
            table[ i ] = table[ i - 1 ] * 2 ;
        }
        int mod = 1000000007 ;
        Map<Integer,Integer> map = new HashMap<>() ;
        for( int item : deliciousness ){
            map.put(item,map.getOrDefault(item, 0) + 1 ) ;
        }
        long rs = 0 ;
        for( Integer item : map.keySet() ){
            for( int i = 0 ; i < 22 ; i ++ ){
                if( item > table[i] ) continue ;
                if( map.containsKey( table[i] - item )){
                    long a = (long)map.get(item) ;
                    long b = (long)map.get( table[i] - item ) ;
                    // if( item > table[i] - item ) continue ;
                    if( item == table[i] - item ){
                        rs  = rs + ( a * ( a - 1 ) / 2 ) ;
                    }
                    else if( item < table[i] - item ){
                        rs = ( rs + a * b ) ;
                    }
                    rs = rs % mod ;
                }
            }
        }
        return (int)rs ;
    }
}