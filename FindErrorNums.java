public class FindErrorNums{

    public int[] findErrorNums(int[] nums){

        int n = nums.length ;
        int[] rs = new int[2] ;
        int[] hash = new int[ n + 1 ] ;
        for( int i = 0 ; i < n ; i ++ ){
            hash[ nums[i] ] -- ;
        }
        for( int i = 1 ; i <= n ; i ++ ){
            if( hash[i] == 0 ){
                rs[1] = i ;
            }
            else if( hash[i] == -2 ){
                rs[0] = i ;
            }
        }
        // for( int i = 1 ; i <= n ; i ++ ){
        //     hash[i] = 1 ;
        // }
        // for( int i = 0 ; i < n ; i ++ ){
        //     hash[ nums[i] ] -- ;
        // }
        // for( int i = 1 ; i <= n ; i ++ ){
        //     if( hash[i] == 1 ){
        //         rs[1] = i ;
        //     }
        //     else if( hash[i] == -1 ){
        //         rs[0] = i ;
        //     }
        // }
        return rs ;
    }
}