class MaximumElementAfterDecrementAndRearranging{
    
    public int maximumElementAfterDecrementAndRearranging(int[] arr){
        int n = arr.length ;
        Arrays.sort(arr) ;
        arr[0] = 1 ;
        for( int i = 1 ; i < n ; i ++ ){
            if(  arr[ i ] - arr[ i - 1 ] > 1 ){
                arr[i] = arr[ i - 1 ] + 1 ;
            }
        }
        int max = 1 ;
        for( int i = 0 ; i < n ; i ++ ){
            if( arr[i] > max ){
                max = arr[i] ;
            }
        }
        return max ;
    }
}