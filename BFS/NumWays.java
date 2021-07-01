import java.util.LinkedList;
import java.util.Queue;

public class NumWays{
    
    public int numWays(int n,int[][] relation,int k){
        Map<Integer,Set<Integer>> map = new HashMap<Integer,Set<Integer>>() ;
        int rn = relation.length ;
        for( int i = 0 ; i < rn ; i ++ ){
            int start = relation[i][0] ;
            int end = relation[i][1] ;
             Set<Integer> now = map.get(start) ;
             if( now == null ){
                 now = new HashSet<Integer>() ;
                 now.add(end) ;
                 map.put(start,now) ;
             }
             else{
                 now.add(end) ;
             }
        }
        Queue<Integer> nodes = new LinkedList<Integer>() ;
        nodes.add(0) ;
        int level = 0 ;
        int rs = 0 ;
        while( level <= k ){
            int size = nodes.size() ;
            level ++ ;
            Set<Integer> seenThisLayer = new HashSet<Integer>() ;
            for( int i = 0 ; i < size ; i ++ ){
                int now = nodes.poll() ;
                // System.out.println(level + " " + now) ;
                if( map.get(now) != null ){
                    for( Integer item : map.get(now)){
                    if( level == k ){
                        if( item == n -1 ){
                            rs ++ ;
                        }
                    }
                    else{
                        nodes.add(item) ;
                    }
                }
                }
            }
        }
        return rs ;
    }
}