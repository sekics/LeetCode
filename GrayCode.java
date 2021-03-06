import java.util.List;

class GrayCode{

    
    public List<Integer> grayCode(int n){
        List<Integer> ans = new ArrayList<Integer>() ;
        ans.add(0) ;
        int tail = 1 ;
        for( int i = 0 ; i < n ; i ++ ){
            for( int j = ans.size() - 1 ; j >= 0 ; j -- ){
                ans.add( head + ans.get(j) ) ;
            }
            head <<= 1 ;
        }
        return ans ;
    }
}