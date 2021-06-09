public class AddToArrayForm {
    public static void main(String[] args){

    }
    public static List<Integer> addToArrayForm(int[] A,int K){
        int n = A.length;
        int k = K ;
        int m = 0 ;
        while( k > 0 ){
            m ++ ;
            k /= 10 ;
        }
        m = m > n ? m : n ;
        int[] temp = new int[ m + 1 ];
        int i = n - 1 ;
        int sum;
        int jinwei = 0 ;
        int now = 0 ;
        while( i >= n && K > 0 ){
            k = K % 10 ;
            sum = k + A[i] + jinwei ;
            jinwei = 0 ;
            if( sum >= 10 ){
                jinwei = 1 ;
                sum -= 10 ;
            }
            temp[now++] = sum ;
            i -- ;
            k = k / 10 ;
        }
        while( i >=0 ){
            sum = A[i] + jinwei;
            jinwei= 0 ;
            if( sum >= 10 ){
                jinwei = 1;
                sum -= 10;
            }
            i -- ;
            temp[now ++ ] = sum;
        }
        while( K > 0 ){
            k = K % 10 ;
            sum = k + jinwei;
            jinwei = 0 ;
            if( sum >= 10 ){
                jinwei = 1;
                sum -= 10;
            }
            k = k / 10;
            temp[now ++ ] = sum;
        }
        if( jinwei > 0 ){
            temp[ now ++ ] = 1;
        }
        List<Integer> res = new ArrayList<Integer>();
        for( ; now >= 0 ; now -- ){
            res.add(temp[now]);
        }
        return res;
    }
}
