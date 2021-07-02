public class NumTrees{

    public int numTrees(int n){
        int rs = 0 ;
        for( int i = 1 ; i <= n ; i ++ ){
            int leftCount = getCount( 1 , i - 1 , n ) ;
            int rightCount = getCount( i + 1 , n , n ) ;
            rs = rs + leftCount * rightCount ;
        }
        return rs ;
    }
    public int getCount( int left , int right , int n){
        if( left == right ){
            return 1 ;
        }
        else if( left < right ){
            int rs = 0 ;
            for( int i = left ; i <= right ; i ++ ){
                int leftCount = getCount( left , i - 1 ,n ) ;
                int rightCount = getCount( i + 1 ,right , n ) ;
                rs = sr + leftCount * rightCount ;
            }
            return rs ;
        }
    }

    //转化为动态规划

    public int numTreesDP(int n){
        int[] cnt = new int[ n + 1 ] ;
        cnt[0] = 1 ;
        cnt[1] = 1 ;
        for( int i = 2 ; i <= n ; i ++ ){
            for( int j = 1 ; j <= i ; j ++ ){
                cnt[i] += cnt[ j - 1 ] * cnt[ i - j ] ;
            }
        }
        return cnt[n] ;
    }
}