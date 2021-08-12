publbic class PeakIndexInMountainArray{
    
    public int peakIndexInMountainArray(int[] arr){
        int n = arr.length ;
        int left = 0 ,right = n - 1 ;
        int mid = 0 ;
        while( left <= right ){
            mid = ( left + right ) / 2 ;
            if( mid - 1 >= 0 && mid + 1 < n ){
                if( arr[ mid - 1 ] < arr[ mid ] && arr[mid] > arr[ mid + 1 ] ){
                    return mid ;
                }
                else if( arr[ mid - 1 ] < arr[mid] && arr[ mid ] < arr[ mid + 1 ] ){
                    left = mid + 1 ;
                }
                else{
                    right = mid - 1 ;
                }
            }
        }
        return left ;
    }
}