public class NumWays{

    Map<Integer,Set<Integer>> map = new HashMap<Integer,Set<Integer>>() ;
    int rs = 0 ;
    int k_ ;
    int n_ ;
    public int numWays(int n,int[][] relation,int k){
        int rn = relation.length ;
        k_ = k ;
        n_ = n ;
        for( int i = 0 ; i < rn ; i ++ ){
            int start = relation[i][0] ;
            int end = relation[i][1] ;
            Set<Integer> now = map.get(start) ;
            if( now == null ){
                now = new HashSet<Integer>() ;
                map.put(start,now) ;
            }
            now.add(end) ;
        }
        Queue<Integer> nodes = new LinkedList<>() ;
        
        DFS(0,1) ;
    }

    public void DFS(Queue<Integer> nodes,int nowLayer){
        Set<Integer> nowSet = map.get(now) ;
        if( nowLayer == k_ ){
            if( nowSet != null ){
                for( Integer item : nowSet ){
                    if( item == n_ - 1 ){
                        rs ++ ;
                    }
                }
            }
            return ;
        }
        else{
            if( nowSet != null ){
                for( Integer item : nowSet ){
                    DFS(item,nowLayer + 1 ) ;
                }
            }
        }
    }

}