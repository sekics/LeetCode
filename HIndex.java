import java.util.Arrays;

class HIndex{

    public int partition( int[] citations,int low,int high){
        int pivot = citations[low] ;
        while( low < high ){
            while( low < high && citations[high] < pivot ){
                high -- ;
            }
            citations[low] = citations[high] ;
            while( low < high && citations[low] >= pivot ){
                low ++ ;
            }
            citations[high] = citations[low] ;
        }
        citations[low] = pivot ;
        return low ;
    }
    public void QuickSort(int[] citations,int low,int high){
        if( low < high ){
            int mid = partition(citations,low,high) ;
            QuickSort(citations,low,mid - 1 ) ;
            QuickSort(citations,mid + 1 ,high ) ;
        }
    }
    public int hIndex(int[] citations) {
        int n = citations.length ;
        QuickSort( citations , 0 , n - 1 ) ;
        // System.out.println(Arrays.toString(citations)) ;
        int left = 0 , right = n - 1 ;
        int mid = 0 ,rs = 0 ;
        while( left <= right ){
            mid = ( left + right ) / 2 ;
            if( citations[mid] >= mid + 1 ){
                rs = mid + 1 ;
                left = mid + 1 ;
            }
            else{
                right = mid - 1 ;
            }
        }
        // System.out.println(left + " " + right ) ;
        return rs ;
    }

    public int hIndexInOrder(int[] citations){
        int n = citations.length ;
        int left = 0 , right = n - 1 , rs = 0 ;
        int mid ;
        while( left <= right ){
            mid = ( left + right ) / 2 ;
            if( citations[mid] >= n - mid){
                rs = mid - 1 ;
                right = mid - 1 ;
            }
            else{
                left = mid + 1 ;
            }
        }
        return n - rs ;
    }
}