import java.util.LinkedList;
public class Combine{

    public void DFS(int n,int now,int k ,int cnt,List<Integer> record){
        if( cnt == k ){
            record.add(now) ;
            ans.add(new ArrayList(record)) ;
            record.removeLast() ;
        }
        else if( cnt > k ){
            return ;
        }
        else{
            record.add(now) ;
            for( int i = now + 1 ; i <= n ; i ++ ){
                DFS( n , i , k , cnt + 1 , record ) ;

            }
            record.removeLast() ;
        }
    }
    public List<List<Integer>> combine(int n,int k){
        LinkedList<Integer> record = new LinkedList<Integer>() ;
        List<List<Integer>> ans = new List<List<Integer>>() ;
        DFS(n,0,k,1,record) ;
        return ans ;
    }
}