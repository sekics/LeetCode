public class HammingWeight{
    public int hammingWeight(int n){
        int cnt = 0 ;
        if( n >= 0 ){
            while( n > 0 ){
            if( n % 2 == 1 ){
                cnt ++ ;
            }
            n /= 2 ;
            }
        }
        else{
            long N = n ;
            N = -n ;
            List<Integer> list = new ArrayList<Integer>() ;
            int[] bits = new int[32] ;
            int CNT = 0 ;
            while( N > 0 ){
                bits[ CNT ++ ] = N % 2 == 1 ? 0 : 1 ;
                N = N / 2 ;
            }
            cnt = 32 - CNT ;
            int jinwei = 1 ;
            int i = 0 ;
            while( i < CNT && jinwei == 1 ){
                if( bits[i] == 0 ){
                    bits[i] += 1 ;
                    jinwei = 0 ;
                }
                else{
                    bits[i] = 0 ;
                    jinwei = 1 ;
                }
                i ++ ;
            }
            for( i = 0 ; i < CNT ; i ++ ){
                if( bits[i] == 1 ){
                    cnt ++ ;
                }
            }
        }
        return cnt ;
    }
}