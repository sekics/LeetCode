import java.util.Arrays;

public class MaxIceCream{

    public int maxIceCreamQuickSort(int[] costs,int coins){
        partition( costs , 0 , costs.length - 1 ) ;
        int rs = 0 ;
        for( int i = 0 ; i < costs.length && coins >= costs[i] ; i ++ ){
            coins -= costs[i] ;
            rs ++ ;
        }
        System.out.println(Arrays.toString(costs)) ;
        return rs ;
    }

    public void partition(int[] costs,int left , int right ){
        if( left < right ){
            int mid = getIndex(costs,left,right) ;
            partition(costs, left , mid - 1 ) ;
            partition(costs,mid + 1 , right ) ;
        }
    }

    public int getIndex(int[] costs,int left,int right){
        int value = costs[left] ;
        while( left < right ){
            while( left < right && value < costs[right] ){
                right -- ;
            }
            costs[left] = costs[right] ;
            while( left < right && value > costs[left] ){
                left ++ ;
            }
            costs[right] = costs[left] ;
        }
        costs[left] = value ;
        return left ;
    }
}