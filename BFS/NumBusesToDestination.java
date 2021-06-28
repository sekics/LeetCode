import java.util.HashMap;
import java.util.HashSet;
import java.util.Queue;

public class NumBusesToDestination{

    public int numBusesToDestination(int[][] routes,int source,int target){
        if(source == target){
            return 0 ;
        }
        int n = routes.length ;
        int[] flag = new int[n] ;
        Map<Integer,Set<Integer>> map = new HashMap<Integer,Set<Integer>>() ;
        for( int i = 0 ; i < n ; i ++ ){
            int size = routes[i].length ;
            for( int j = 0 ; j < size ; j ++ ){
                int num = routes[i][j] ;
                if( map.get(num) == null ){
                    Set<Integer> set = new HashSet<Integer>() ;
                    set.add(i) ;
                    map.put(num,set) ;
                }
                else{
                    Set<Integer> set = map.get(num) ;
                    if( !set.contains(i) ){
                        set.add(i) ;
                    }
                }
            }
        }
        HashSet<Integer> seen = new HashSet<Integer>() ;
        HashSet<Integer> seenLine = new HashSet<Integer>() ;
        Queue<Integer> next = new LinkedList<Integer>() ;
        Set<Integer> first = map.get(source) ;
        for( Integer item : first ){
            seenLine.add(item) ;
            for( int  i = 0 ; i < routes[item].length ; i ++ ){
                next.offer(routes[item][i]) ;
                seen.add(routes[item][i]) ;
            }
        }
        int time = 0 ;
        while( !next.isEmpty() ){
            time ++ ;
            int size = next.size() ;
            for( int i = 0 ; i < size ; i ++ ){
                int now = next.poll() ;
                Set<Integer> lines = map.get(now) ;
                for( Integer item : lines ){
                    if( !seenLine.contains(item) ){
                        seenLine.add(item) ;
                        for( int j = 0 ; j < routes[item].length ; j ++ ){
                            int stop = routes[item][j] ;
                            if( !seen.contains( stop ) ){
                                seen.add( stop ) ;
                                next.offer( stop ) ;
                            }
                        }
                    }
                }
                if( now == target ){
                    return time ;
                }
            }
            // System.out.println(next.toString()) ;
        }
        return -1 ;
    }
}