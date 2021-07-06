import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class DisplayTable{

    public List<List<String>> displayTable(List<List<String>> orders){
        Set<String> dishes = new HashSet<>() ;
        Map<String,Set<String>> map = new HashMap<>() ;
        Map<String,Integer> cnt = new HashMap<>() ; 
        for( int i = 0 ; i < orders.size() ; i ++ ){
            List<String> nowList = orders.get(i) ;
            String table = nowList.get(1) ;
            String dish = nowList.get(2) ;
            dishes.add(dish) ;
            if( map.get(table) == null ){
                Set<String> ar = new HashSet<String>() ;
                map.put(table,ar) ;
            }
            map.get(table).add(dish) ;
            String tableDish = table + dish ;
            cnt.put( tableDish , cnt.getOrDefault(tableDish, 0) + 1 ) ;
        }
        List<String> allDish = new ArrayList<>(dishes) ;
        Collections.sort(allDish) ;
        allDish.add(0,"Table") ;
        List<String> tables = new ArrayList<>(map.keySet()) ;
        Collections.sort(tables,(String a,String b) -> Integer.valueOf(a) - Integer.valueOf(b)) ;
        List<List<String>> rs = new ArrayList<List<String>>() ;
        rs.add(allDish) ;
        for( int i = 0 ; i < tables.size() ; i ++ ){
            String table = tables.get(i) ;
            Set<String> tableDish = map.get(table) ;
            List<String> tableRs = new ArrayList<>() ; 
            tableRs.add(table) ;
            for( int j = 1 ; j < allDish.size() ; j ++ ){
                String dish = allDish.get(j) ;
                if( tableDish.contains(dish) ){
                    tableRs.add( String.valueOf(cnt.get( table + dish ))) ;
                }
                else{
                    tableRs.add( "0" ) ;
                }
            }
            rs.add(tableRs) ;
        }
        return rs ;
    }
}